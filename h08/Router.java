package edu.ics211.h08;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents Router Class and implements routerInterface. 
 * 
 * @author narowetz
 */
public class Router implements RouterInterface {
  private PacketQueue[] queues;
  private PacketSenderInterface sender;
  private List<Packet> droppedPackets;
  
  /**
   * Router constructor.
   */
  public Router(PacketSenderInterface sender) {
    this.queues = new PacketQueue[8];
    this.droppedPackets = new ArrayList<Packet>();
    this.sender = sender;
    // Create new queues
    for (int i = 0; i < 8; i++) {
      queues[i] = new PacketQueue();
    }
  }
  
  @Override
  public void advanceTime() {
    // Go over queues 
    for (int i = 0; i < 8; i++) {
      Packet temp = queues[i].poll();
      if (temp != null) {
        sender.send(i, temp);
      }
    }
  }

  @Override
  public boolean acceptPacket(Packet p) { 
    // Get address
    int address = p.getAddress();
    // Compare
    if (queues[address].offer(p)) {
      return true; 
    }
    droppedPackets.add(p);
    return false; 
  }

  @Override
  public List<Packet> getDroppedPackets() {
    // Use array listed for dropped packet list
    List<Packet> allDrop = new ArrayList<Packet>(droppedPackets);
    droppedPackets = new ArrayList<Packet>();
    return allDrop;
  }

}
