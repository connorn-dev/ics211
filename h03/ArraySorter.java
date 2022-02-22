package edu.ics211.h03;

import java.util.Comparator;

/**
 * Class that implements SortsArray.
 * 
 * @author narowetz
 * @param <E> the type of data
 */
public class ArraySorter<E> implements SortsArray<E> {
  
  int numSwaps;
  int numComps;
  double timeToSort; 
  
  @Override
  // Source: https://www.geeksforgeeks.org/insertion-sort/
  public void insertionSort(Comparator<E> compare, E[] data) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // Loop over the data
    for (int i = 1; i < data.length; i++) { 
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
  // Source: https://www.geeksforgeeks.org/bubble-sort/
  public void bubbleSort(Comparator<E> compare, E[] data) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // First loop goes over entire array
    for (int i = 0; i < data.length - 1; i++) {
      numComps++;
      // Second loop checks condition
      for (int j = 0; j < data.length - i - 1; j++) {
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
  
  // Source: https://www.geeksforgeeks.org/selection-sort/
  @Override
  public void selectionSort(Comparator<E> compare, E[] data) {
    // Set the start time and set up variables
    double timeStart = 0;
    timeStart = System.nanoTime();
    numSwaps = 0; 
    numComps = 0;
    // First loop to find and replace minimum
    for (int i = 0; i < data.length - 1; i ++) {
      int minIndex = i;
      for (int j = i + 1; j < data.length; j++) {
        numComps++;
        if (compare.compare(data[j], data[minIndex]) < 0) {
          minIndex = j;
        }
      }
      // Swap elements 
      E temp = data[minIndex];
      data[minIndex] = data[i];
      data[i] = temp;
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

}
