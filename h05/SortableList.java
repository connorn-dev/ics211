package edu.ics211.h05;


import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortableList;
import java.util.Comparator;


/**
 * Class that represents a SortableList that uses DLinkedNodes.
 *
 * @author narowetz
 * @param <E> generic type
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  
  // Class variables
  private DLinkedNode tail;
  private int size;
  int numSwaps;
  int numComps;
  double timeToSort; 
  
  /**
   * SortableList constructor.
   *
   * @author narowetz
   */
  public SortableList() {
    this.tail = null; 
    this.size = 0; 
    this.numSwaps = 0;
    this.numComps = 0; 
    this.timeToSort = 0; 
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
  public void insertionSort(Comparator<E> compare) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // Loop over the data
    for (int i = 1; i < size; i++) { 
      E save = get(i);
      int j = i - 1; 
      while (j >= 0 && compare.compare(save, get(j)) < 0) {
        numComps++;
        set(j + 1, get(j));
        j--;
        numSwaps++;
      }
      set(j + 1, save);
      if (i > 0) {
        numComps++;
      }
    }
    timeToSort = System.nanoTime() - timeStart; 
    
  }

  @Override
  public void bubbleSort(Comparator<E> compare) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // First loop goes over entire array
    for (int i = 0; i < size - 1; i++) {
      numComps++;
      // Second loop checks condition
      for (int j = 0; j < size - i - 1; j++) {
        // Check if index 0 is greater than index 1 
        if (compare.compare(get(j), get(j + 1)) > 0) {
          E temp = get(j);
          set(j, get(j + 1));
          set(j + 1, temp);
          numSwaps++;
        }
      }
    }
    timeToSort = System.nanoTime() - timeStart;
    
  }

  @Override
  public void selectionSort(Comparator<E> compare) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // First loop to find and replace minimum
    for (int i = 0; i < size - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < size; j++) {
        numComps++;
        if (compare.compare(get(j), get(minIndex)) < 0) {
          minIndex = j;
        }
      }
      // Swap elements 
      E temp = get(minIndex);
      set(minIndex, get(i));
      set(i, temp); 
      numSwaps++;
    }
    timeToSort = System.nanoTime() - timeStart;
    
    
  }

  @Override
  public int getNumberOfSwaps() {
    return numSwaps;
  }

  @Override
  public int getNumberOfComparisons() {
    return numComps; 
  }

  @Override
  public double getSortTime() {
    return timeToSort; 
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
    return size;
  }

  @Override
  public boolean add(E e) {
    // Call other add method
    add(size(), e);
    return true;
  }

  @Override
  public void add(int index, E element) {
    // Check if the index is valid
    if (checkIndex(index)) {
      // Create our new node
      DLinkedNode node = new DLinkedNode(element, null, null);
      // Check if first element
      if (size == 0) {
        tail = node;
      } 
      // Check if it's added at end of list
      if (index == size) {
        node.prev = tail; 
        tail.next = node; 
        tail = node; 
      } else {
        // If neither traverse and replace
        DLinkedNode temp = traverse(index);
        node.prev = temp.prev; 
        node.next = temp; 
        temp.prev = node; 
      } 
      // Set the new values previous pointer to current add
      if (node.prev != null) {
        node.prev.next = node;
      }
    }
  }

  @Override
  public E remove(int index) {
    E e = null; 
    // Check if the index is valid 
    if (checkIndex(index)) {
      // Check if deleting edge case
      if (index == size - 1) {
        e = tail.item;
        tail = tail.prev;
      } else {
        // Traverse to the index
        DLinkedNode temp = traverse(index);
        if (temp == null) {
          throw new IndexOutOfBoundsException("index must be in range");
        }
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        e = temp.item;
      }
    }
    size--;
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
 

}
