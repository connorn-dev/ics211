package edu.ics211.h06;

import edu.ics211.h04.IList211;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * A class which represents a DoublyLinked List that is Circular.
 * 
 * @author narowetz
 * @param <E> represents generic type
 *
 */
public class CircularDoublyLinkedList<E> implements Iterable<E>, IList211<E> {
  
  // LinkedList variables
  DLinkedNode head;
  DLinkedNode tail; 
  private int size; 
 
  /**
   * Constructor method for the CircularDoublyLinkedList class, with array item parameters.
   */
  public CircularDoublyLinkedList(E[] items) {
    this();
    for (E item: items) {
      add(item);
    }
    
  }
  
  /**
   * Constructor method for the CircularDoublyLinkedList class, no parameters. 
   */
  public CircularDoublyLinkedList() {

  }
  
  /**
   * Class to represent ListInterator. 
   */
  public class CircularDoublyLinkedListIterator implements ListIterator<E> {

    // Iterator variables
    DLinkedNode nextNode; 
    DLinkedNode jumped;
    private int nextIndex;
    private int size; 
    
    /**
     * Method creates a list iterator object. 
     */
    public CircularDoublyLinkedListIterator(DLinkedNode head) {
      this.nextNode = head;
      this.nextIndex = 0; 
      this.jumped = null;
    }
    
    
    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      if (nextNode != null) {
        return true;
      } else {
        return false; 
      }
    }

    @Override
    public E next() {
      if (hasNext()) {
        jumped = nextNode; 
        E temp = nextNode.item;
        nextNode = nextNode.next;
        nextIndex++;
        return temp;
      } else {
        throw new NoSuchElementException();
      }
    }

    @Override
    public boolean hasPrevious() {
      if (nextNode != null) {
        return true;
      } else {
        return false; 
      }
    }

    @Override
    public E previous() {
      if (hasPrevious()) {
        nextNode = nextNode.prev;
        E temp = nextNode.item;
        return temp;
      } else {
        throw new NoSuchElementException();
      }
    }

    @Override
    public int nextIndex() { 
      
      if (hasNext()) {
        return indexOf(nextNode.item);
      }
      throw new IndexOutOfBoundsException();
    }

    @Override
    public int previousIndex() {
      if (hasPrevious()) {
        return indexOf(nextNode.prev.item);
      }
      throw new IndexOutOfBoundsException();
    }
      

    @Override
    public void remove() {
      nextNode.prev.next = nextNode.next;
      nextNode.next.prev = nextNode.prev;
    }

    @Override
    public void set(Object e) {
      // NOT REQUIRED FOR PROJECT
      
    }

    @Override
    public void add(Object e) {
      // NOT REQUIRED FOR PROJECT
      
    }
  }

  
  // DLinkedNode class 
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
    
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }
  
  @Override
  public E get(int index) {
    // Check if index is good 
    if (checkIndex(index) && index != size) {
      // traverse to the element 
      DLinkedNode temp = traverse(index);
      return temp.item; 
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public E set(int index, E element) {
    E oldVal = null;
    // Check if index is valid 
    if (checkIndex(index) && index != size) {
      // Traverse to index
      DLinkedNode temp = traverse(index); 
      oldVal = temp.item; 
      temp.item = element;
    } else {
      throw new IndexOutOfBoundsException();
    }
    return oldVal;
  }

  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = tail;
    // Loop through all elements
    for (int i = size - 1; i >= 0; i--) {
      if (temp.item.equals(obj)) {
        return i;
      }
      temp = temp.prev; 
    }
    return -1;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean add(E e) {
    // Call other add method
    add(size(), e);
    return true;
  }

  @Override
  public void add(int index, E element) {
    if (checkIndex(index)) {
      DLinkedNode node = new DLinkedNode(element, null, null);
      if (size == 0) {
        head = node;
        tail = node; 
      } else if (index == 0) {
        head.prev = node; 
        node.next = head;
        head = node;
        head.prev = tail; 
        tail.next = head; 
      } else if (index == size) {
        tail.next = node;
        node.prev = tail;
        tail = node; 
        head.prev = tail; 
        tail.next = head; 
      } else {
        DLinkedNode temp = traverse(index);
        node.prev = temp.prev; 
        temp.prev.next = node; 
        node.next = temp; 
        temp.prev = node; 
      }
      size++; 
    }
  }

  @Override
  public E remove(int index) {
    E e = null; 
    if (checkIndex(index)) {
      if (size == 0) {
        e = tail.item; 
        head = null; 
        tail = null;
      } else if (index == size) {
        throw new IndexOutOfBoundsException("index must be in range");
      } else if (index == 0) {
        e = head.item;
        head = head.next;
        head.prev = tail;
      } else if (index == size - 1) {
        e = tail.item;
        tail = tail.prev;
        tail.next = head;
      } else {
        DLinkedNode temp = traverse(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
      }
      size--; 
    }
    return e; 
  }
  
  private boolean checkIndex(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index must be in range");
    } else {
      return true; 
    }
  }
  
  private DLinkedNode traverse(int index) {
    DLinkedNode temp = tail; 
    for (int i = size - 1; i > index; i--) {
      temp = temp.prev;
    }
    return temp;
  }

  @Override
  public Iterator<E> iterator() {
    return new CircularDoublyLinkedListIterator(head);
  }

}
