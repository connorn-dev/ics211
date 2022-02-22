package edu.ics211.h04;

import java.util.Comparator;

/**
 * Abstract class that represents the cheese objects.
 * 
 * @author narowetz
 * 
 * @param <E>
 * 
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  // Variables for the SortableList 
  @SuppressWarnings("unchecked")
  private E[] data;
  private int size;
  int numSwaps;
  int numComps;
  double timeToSort; 
  
  /**
   * Constructor function for the SortableList class. 
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    // Set all the variable values
    this.data = (E[]) new Object[10];
    this.size = 0;
    this.numSwaps = 0;
    this.numComps = 0;
    this.timeToSort = 0; 
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
      int nextPosition = i;
      while (nextPosition > 0 && compare.compare(data[nextPosition], data[nextPosition - 1]) < 0) {
        numComps++;
        E key = data[nextPosition];
        data[nextPosition] = data[nextPosition - 1];
        data[nextPosition - 1] = key;
        nextPosition--;
        numSwaps++;
      }
      if (nextPosition > 0) {
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
        if (compare.compare(data[j], data[j + 1]) > 0) {
          E temp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = temp;
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
        if (compare.compare(data[j], data[minIndex]) < 0) {
          minIndex = j;
        }
      }
      // Swap elements 
      E temp = data[minIndex];
      data[minIndex] = data[i];
      data[i] = temp;
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
    // Check if the index is valid 
    E temp = null; 
    if (checkIndexValid(index)) {
      temp = data[index];
    }
    return temp; 
  }

  @Override
  public E set(int index, E element) {
    // Check that the index is valid
    if (checkIndexValid(index)) {
      // Set the old value to temp variable to return it after setting new variable.
      E temp = data[index];
      data[index] = element;
      return temp; 
    } else {
      return null; 
    }
  }

  @Override
  public int indexOf(Object obj) {
    // Loop through the array and find the object
    for (int i = 0; i < size; i++) {
      if (data[i].equals(obj)) {
        return i; 
      }
    }
    // Return -1 if it cant find the object.
    return -1;
  }

  @Override
  public int size() {
    // Check if index is valid 
    return size; 
  }

  @Override
  public boolean add(E e) {
    // Check if there is space
    if (checkForSpace()) {
      data[size] = e;
      size++; 
      return true;
    } else {
      return false; 
    }
  }

  @Override
  public void add(int index, E element) {
    // Check if the index given is good
    if (index == 0) {
      // next check if there is space
      if (checkForSpace()) {
        // Create temp array 
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[data.length];
        for (int i = 0; i < index; i++) {
          temp[i] = data[i];
        }
        // Replace at the index given with the element given
        temp[index] = element; 
        // Loop the right side of the array
        for (int i = index; i < size; i++) {
          temp[i + 1] = data[i];
        }
        // Set the index to the temp one used. 
        data = temp; 
      }
    } else if (checkIndexValid(index - 1)) {
      // next check if there is space
      if (checkForSpace()) {
        // Create temp array 
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[data.length];
        for (int i = 0; i < index; i++) {
          temp[i] = data[i];
        }
        // Replace at the index given with the element given
        temp[index] = element; 
        // Loop the right side of the array
        for (int i = index; i < size; i++) {
          temp[i + 1] = data[i];
        }
        // Set the index to the temp one used. 
        data = temp; 
      }
    }
    size++;
  }

  @Override
  public E remove(int index) {
    // Check if the index is valid 
    E temp = data[index];
    if (checkIndexValid(index)) {
      @SuppressWarnings("unchecked")
      // Get elements before remove
      E[] tempArr = (E[]) new Object[data.length];
      for (int i = 0; i < index; i++) {
        tempArr[i] = data[i];
      }
      // Get elements after remove
      for (int i = index; i < size; i ++) {
        tempArr[i] = data[i + 1];
      }
      data = tempArr; 
    }
    size--;
    return temp;
  }
  
  private boolean checkIndexValid(int index) {
    // Checks if the index is valid and returns a true or false
    if (index >= 0 && index < size) {
      return true;
    } else {
      throw new IndexOutOfBoundsException("Index is out of bounds");
    }
  }
  
  private boolean checkForSpace() {
    for (int i = 0; i < data.length; i++) {
      // Check if any element is null 
      if (data[i] == null) {
        return true;
      }
    }
    // If there is no space create array 2x the size and move everything 
    @SuppressWarnings("unchecked")
    E[] temp = (E[]) new Object[data.length * 2];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[i];
    }
    data = temp; 
    return true; 
  }

}
