package edu.ics211.h05;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

class SortableListTest {
  SortableList<String> list = new SortableList<String>();
  StringComparator comp = new StringComparator();
  
  @Test
  void testSortableList() {
    SortableList<String> list = new SortableList<String>(); 
    list.add("apple");
    assertEquals("apple", list.get(0));
    // Created SortableList
  }


  @Test
  void testInsertionSort() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.insertionSort(comp);
    assertEquals("apple", list.get(0));
    assertEquals("bar", list.get(1));
    assertEquals("car", list.get(2));
  }


  @Test
  void testBubbleSort() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.bubbleSort(comp);
    assertEquals("apple", list.get(0));
    assertEquals("bar", list.get(1));
    assertEquals("car", list.get(2));
  }


  @Test
  void testSelectionSort() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.selectionSort(comp);
    assertEquals("apple", list.get(0));
    assertEquals("bar", list.get(1));
    assertEquals("car", list.get(2));
  }


  @Test
  void testGetNumberOfSwaps() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.selectionSort(comp);
    assertEquals(2, list.getNumberOfSwaps());
  }


  @Test
  void testGetNumberOfComparisons() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.selectionSort(comp);
    assertEquals(3, list.getNumberOfComparisons());
  }


  @Test
  void testGetSortTime() {
    list.add("bar");
    list.add("car");
    list.add("apple");
    list.selectionSort(comp);
    if (list.getSortTime() <= 0) {
      fail("time never changed");
    }
  }


  @Test
  void testGet() {
    list.add("apple");
    list.add("bar");
    list.add("car");
    assertEquals("apple", list.get(0));
    assertEquals("bar", list.get(1));
    assertEquals("car", list.get(2)); 
    // Returned all correct values 
  }


  @Test
  void testSet() {
    list.add("apple");
    list.add("bar");
    list.add("car");
    list.set(1, "zeebra");
    assertEquals("apple", list.get(0));
    assertEquals("zeebra", list.get(1));
    assertEquals("car", list.get(2)); 
    // Set and returned the correct value 
  }


  @Test
  void testIndexOf() {
    list.add("apple");
    list.add("bar");
    list.add("car");
    assertEquals(1, list.indexOf("bar"));
    // Gives the correct index
  }


  @Test
  void testSize() {
    list.add("apple");
    list.add("bar");
    list.add("car");
    assertEquals(3, list.size()); 
    list.remove(2);
    assertEquals(2, list.size()); 
    // Returns the correct size
  }


  @Test
  void testAddE() {
    list.add(0, "hi");
    list.add(0, "bye");
    list.add("new");
    assertEquals("new", list.get(2)); 
    // Adds the correct element at index
  }


  @Test
  void testAddIntE() {
    list.add("1");
    list.add("3");
    list.add(1, "2");
    assertEquals("2", list.get(1)); 
    // Adds at the correct index
  }


  @Test
  void testRemove() {
    list.add("apple");
    list.add("bar");
    list.add("car");
    list.remove(1);
    assertEquals("apple", list.get(0));
    assertEquals("car", list.get(1)); 
    // Removes the correct element 
  }
}
