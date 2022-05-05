package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class CustomBinarySearchTreeTest {

  @Test
  void test() {
    // Create new binary search tree and test to make sure it exists
    Comparator<String> comp = new CustomCompare();
    BinarySearchTree<String> tree = new BinarySearchTree<String>(comp);
    assertNotNull(tree);
    // Add the first element and make sure it exists and can't add duplicate
    tree.add("bmw");
    assertFalse(tree.add("bmw")); 
    // Add the second element and third element
    tree.add("audi");
    tree.add("mb"); 
    // Make sure the size is correct
    assertEquals(3, tree.size()); 
    // Remove an element and make sure it is the same size and the 
    // other elements exist
    tree.remove("mb");
    assertFalse(tree.add("bmw"));
    assertFalse(tree.add("audi"));
    // Add some more elements
    tree.add("a");
    tree.add("ferrari");
    // See if tree contains the elements 
    assertTrue(tree.contains("a"));
    assertTrue(tree.contains("ferrari")); 
    // Finally check that all the elements are in order correctly 
    List<String> cars = tree.inorder();
    assertEquals("a", cars.get(0));
    assertEquals("bmw", cars.get(1));
    assertEquals("audi", cars.get(2));
    assertEquals("ferrari", cars.get(3));
  }

}
