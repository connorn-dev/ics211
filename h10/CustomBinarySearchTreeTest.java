package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
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
    // Make sure they all exist in the right spot 
    assertFalse(tree.add("bmw")); 
  }

}
