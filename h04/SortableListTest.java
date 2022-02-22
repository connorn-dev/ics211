package edu.ics211.h04;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

class SortableListTest {

  SortableList<String> list = new SortableList<String>();
  StringComparator comp = new StringComparator();
  
  @Test
  void testSortableList() {
    // Create object and test the first index after 10 to see if it can double array size
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    list.add("f");
    list.add("h");
    list.add("i");
    list.add("j");
    list.add("k");
    list.add("l");
    list.add("m");
    list.add("n");
    
    assertEquals("l", list.get(10));
    assertEquals("n", list.get(12));
  }


  @Test
  void testInsertionSort() {
    // Test the insertion sort sorts a simple array properly. 
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.insertionSort(comp);
    assertEquals("bar", list.get(0));
    assertEquals("baz", list.get(1));
    assertEquals("foo", list.get(2));
  }


  @Test
  void testBubbleSort() {
    // Test the bubble sort sorts a simple array properly. 
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.bubbleSort(comp);
    assertEquals("bar", list.get(0));
    assertEquals("baz", list.get(1));
    assertEquals("foo", list.get(2));
  }


  @Test
  void testSelectionSort() {
    // Test the selection sort sorts a simple array properly. 
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.selectionSort(comp);
    assertEquals("bar", list.get(0));
    assertEquals("baz", list.get(1));
    assertEquals("foo", list.get(2));
  }


  @Test
  void testGetNumberOfSwaps() {
    // Check if it can get the number of swaps.
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.bubbleSort(comp);
    assertEquals(2, list.numSwaps);
  }


  @Test
  void testGetNumberOfComparisons() {
    // Test if it can get the number of comparisons.
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.insertionSort(comp);
    assertEquals(3, list.numComps);
  }


  @Test
  void testGetSortTime() {
    // Try and get the sort time. If it is 0 or less fail the test. 
    list.add("baz");
    list.add("foo");
    list.add("bar");
    list.insertionSort(comp);
    if (list.getSortTime() <= 0) {
      fail("Time to sort was wrong..");
    }
  }


  @Test
  void testGet() {
    // Test the a method call can get the first and last element.
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals("a", list.get(0));
    assertEquals("c", list.get(2));
  }


  @Test
  void testSet() {
    // Test the set method to make sure it sets the right element.
    list.add("a");
    list.add("b");
    list.add("c");
    list.set(1, "z");
    assertEquals("z", list.get(1));
  }


  @Test
  void testIndexOf() {
    // Test the method returns the correct index of the element given.
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    assertEquals(3, list.indexOf("d"));
    assertEquals(1, list.indexOf("b"));
  }


  @Test
  void testSize() {
    // Test the method returns the correct size of the list. 
    list.add("a");
    list.add("b");
    list.add("c");
    assertEquals(3, list.size());
  }


  @Test
  void testAddE() {
    // Test the function can add a element. 
    list.add("a");
    assertEquals("a", list.get(0));
  }


  @Test
  void testAddIntE() {
    // Test the function can add an element at a given index
    list.add("4");
    list.add("3");
    list.add("1");
    list.add("2");
    list.add(2, "99");
    assertEquals("4", list.get(0));
    assertEquals("3", list.get(1));
    assertEquals("99", list.get(2));
    assertEquals("1", list.get(3));
    assertEquals("2", list.get(4));
  }


  @Test
  void testRemove() {
    // Test that the remove function works and that it works with other functions to test overall. 
    list.add("d");
    list.add("z");
    list.add("c");
    list.add("d");
    list.add("a");
    assertEquals("c", list.remove(2));
    list.insertionSort(comp);
    assertEquals(4, list.size());
    assertEquals("a", list.get(0));
  }

}
