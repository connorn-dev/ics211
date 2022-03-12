package edu.ics211.h08;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class QueueTest {

  @Test
  void testEmptyQueue() {
    PacketQueue q = new PacketQueue(); 
    assertNotNull(q);
    // Remove when empty
    assertEquals(null,q.poll());
    try {
      q.remove();
    } catch (Exception e) {
      assertNotNull(e);
    }
    // Try and add 
    Packet p = new Packet(15); 
    q.offer(p);
    q.add(p);
    // Remove/ poll now
    assertEquals(15,q.poll().getAddress());
    assertEquals(15,q.remove().getAddress());
  }
  
  @Test
  void testOneElementQueue() {
    // Same as before
    PacketQueue q = new PacketQueue(); 
    assertNotNull(q);
    Packet p = new Packet(15); 
    q.offer(p);
    assertEquals(15,q.remove().getAddress());
    q.offer(p);
    q.offer(p);
    q.remove();
    q.remove();
    assertEquals(null,q.poll());
    try {
      q.remove();
    } catch (Exception e) {
      assertNotNull(e);
    }
  }
  
  @Test
  void testAlmostFullQueue() {
    PacketQueue q = new PacketQueue(); 
    Packet p = new Packet(15); 
    for (int i = 0; i < 9; i++) {
      q.offer(p);
    }
    assertEquals(9,q.size());
    q.add(p);
    // Failure test
    assertEquals(false,q.offer(p));
    try {
      q.add(p);
    } catch (Exception  e) {
      assertNotNull(e);
    }
    //try and remove
    q.remove();
    q.poll();
    assertEquals(15, q.poll().getAddress());
    // peek
    assertEquals(15, q.peek().getAddress());
  }
  
  @Test
  void testFullQueue() {
    PacketQueue q = new PacketQueue(); 
    Packet p = new Packet(15); 
    for (int i = 0; i < 10; i++) {
      q.offer(p);
    }
    assertEquals(10,q.size());
    // Failure test
    assertEquals(false,q.offer(p));
    try {
      q.add(p);
    } catch (Exception  e) {
      assertNotNull(e);
    }
    // try and remove
    q.remove();
    q.poll();
    assertEquals(15, q.poll().getAddress());
    // peek
    assertEquals(15, q.peek().getAddress());
  }
}
