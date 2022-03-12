package edu.ics211.h08;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Class that represents a Queue that holds packets. Abstract class because we only need some of 
 * the interface not all of it. 
 * 
 * @author narowetz
 */
public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {

  private int size; 
  private int maxSize; 
  private DLinkedNode front; 
  private DLinkedNode rear; 
  
  /**
   * Constructor for PacketQueue. 
   */
  public PacketQueue() {
    this.size = 0; 
    this.maxSize = 10; 
    this.front = null; 
    this.rear = null; 
  }
  
  /**
   * Class for queue iterator. 
   */
  public class PacketQueueInterator implements ListIterator<Packet> {
    private DLinkedNode nextNode; 
    private int nextIndex; 
    
    /**
     * Constructor for iterator. 
     */
    public PacketQueueInterator(DLinkedNode front) {
      nextNode = front; 
      nextIndex = 0; 
    }
    
    @Override
    public boolean hasNext() {
      if (nextNode != null) {
        return true;
      } else {
        return false; 
      }
    }

    @Override
    public Packet next() {
      if (hasNext()) {
        Packet temp = nextNode.contents;
        nextNode = nextNode.next;
        nextIndex++;
        return temp;
      } else {
        throw new NoSuchElementException();
      }
    }

    @Override
    public boolean hasPrevious() {
      // NOT USED FOR ASSIGMENT... 
      return false;
    }

    @Override
    public Packet previous() {
      // NOT USED FOR ASSIGMENT... 
      return null;
    }

    @Override
    public int nextIndex() {
      return nextIndex; 
    }

    @Override
    public int previousIndex() {
      // NOT USED FOR ASSIGMENT... 
      return 0;
    }

    @Override
    public void remove() {
     // NOT USED FOR ASSIGMENT... 
    }

    @Override
    public void set(Packet e) {
      // NOT USED FOR ASSIGMENT... 
    }

    @Override
    public void add(Packet e) {
    // NOT USED FOR ASSIGMENT... 
    }
    
  }
  
  // Class to represent DLinkedNodes to create the queue. 
  private class DLinkedNode {
    Packet contents;
    DLinkedNode next;
    
    public DLinkedNode(Packet contents, DLinkedNode next) {
      this.contents = contents;
      this.next = next;
    }
  }
  
  @Override
  public int size() {
    return this.size; 
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true; 
    } else {
      return false; 
    }
  }

  @Override
  public Iterator<Packet> iterator() {
    return new PacketQueueInterator(front);
  }

  @Override
  public boolean offer(Packet e) {
    // Create new node. 
    DLinkedNode node = new DLinkedNode(e, null);
    // If empty make new node rear node. 
    if (isEmpty()) {
      rear = node; 
      front = rear;
    } else {
      if (size >= maxSize) {
        return false; 
      }
      rear.next = node;
      rear = rear.next;
    }
    size++; 
    if (rear != null) {
      return true;
    } else {
      return false; 
    }
  }

  @Override
  public Packet poll() {
    // If empty return null, else get first element in line and remove. 
    if (isEmpty()) {
      return null; 
    } else {
      Packet oldPacket = front.contents; 
      front = front.next; 
      size--;
      return oldPacket; 
    }
  }
  
  @Override
  public Packet peek() {
    // If empty return null, else get first in line. 
    if (isEmpty()) {
      return null; 
    } else {
      return front.contents; 
    }
  } 
  
  /**
   * Method to return the entire queue to String format.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder(); 
    Iterator<Packet> iter = iterator();
    while (iter.hasNext()) {
      Packet p = iter.next();
      sb.insert(0, p.getAddress());
    }
    return sb.toString();
  }

}
