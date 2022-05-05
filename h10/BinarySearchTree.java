package edu.ics211.h10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class represents the Binary Search Tree. 
 * 
 * @author narowetz
 * @param <E> element/object
 */ 
public class BinarySearchTree<E> implements InOrder<E>, SearchTree<E> {

  // Search Tree Variables
  private BinaryNode<E> root;
  public Comparator<E> comp;
  private int size; 
  
  // Return method variables
  private boolean addMethod; 
  private boolean deleteMethod; 
  private E returnDelete; 
  List<E> list = new ArrayList<E>(); 
  
  /**
   * Constructor for our Binary Search Tree. 
   */ 
  public BinarySearchTree(Comparator<E> comp) {
    this.root = null; 
    this.comp = comp; 
    this.size = 0;
  }
  
  private static class BinaryNode<E> {
    BinaryNode<E> left; 
    BinaryNode<E> right;
    E item; 
    
    private BinaryNode(E item) {
      this.item = item; 
      this.left = null; 
      this.right = null; 
    }
  }
  
  @Override
  public boolean add(E item) {
    // Start recursive call with root 
    root = addRecursive(root, item);
    return addMethod; 
  }
  
  private BinaryNode<E> addRecursive(BinaryNode<E> currentNode, E item) {
    // If root is null set node (base case)
    if (currentNode == null) {
      addMethod = true;
      size++;
      return new BinaryNode<E>(item);
    }
    // If root is full, then compare values for next nodes, if same return false
    if (comp.compare(item, currentNode.item) == 0) {
      addMethod = false; 
      return currentNode; 
    } else if (comp.compare(item, currentNode.item) < 0) {
      currentNode.left = addRecursive(currentNode.left, item); 
      return currentNode;
    } else {
      currentNode.right = addRecursive(currentNode.right, item); 
      return currentNode; 
    }
  }
  
  @Override
  public boolean contains(E item) {
    // Run the find method and based on results return true or false
    if (find(item) != null) {
      return true; 
    } else {
      return false; 
    }
  }

  @Override
  public E find(E target) {
    // Start with first recursive Call
    return findRecursive(root, target); 
  }
  
  private E findRecursive(BinaryNode<E> currentNode, E target) {
    if (currentNode == null) {
      return null;
    }
    if (comp.compare(target, currentNode.item) == 0) {
      return currentNode.item;
    } else if (comp.compare(target, currentNode.item) < 0) {
      return findRecursive(currentNode.left, target);
    } else {
      return findRecursive(currentNode.right, target); 
    }
  }

  @Override
  public E delete(E target) {
    // Start with the first recursive call
    size--; 
    root = deleteRecursive(root, (E) target);
    return returnDelete; 
  }
  
  private BinaryNode<E> deleteRecursive(BinaryNode<E> currentNode, E item) {
    if (currentNode == null) {
      returnDelete = null; 
      deleteMethod = false; 
      return currentNode; 
    }
    if (comp.compare(item, currentNode.item) < 0) {
      currentNode.left = deleteRecursive(currentNode.left, item);
      return currentNode;
    } else if (comp.compare(item, currentNode.item) > 0) {
      currentNode.right = deleteRecursive(currentNode.right, item);
      return currentNode;
    } else {
      return replace(currentNode); 
    }
    
  }
  
  private BinaryNode<E> replace(BinaryNode<E> currentNode) {
    returnDelete = currentNode.item;
    // Base case
    if (currentNode.left == null) {
      return currentNode.right; 
    } else if (currentNode.right == null) {
      return currentNode.left; 
    } else {
      if (currentNode.left.right == null) {
        currentNode.item = currentNode.left.item; 
        currentNode.left = currentNode.left.left; 
        return currentNode; 
      } else {
        currentNode.item = find(currentNode.left.item);
        return currentNode; 
      }
    }
  }
  
  
  @Override
  public boolean remove(E target) {
    deleteMethod = true; 
    size--; 
    root = deleteRecursive(root, target);
    return deleteMethod; 
  }

  @Override
  public int size() {
    return size; 
  }

  @Override
  public List<E> inorder() {
    // First call to inorder
    List<E> newList = inorder(root);
    return newList;
  }
  
  // (Source: https://www.java67.com/2016/08/binary-tree-inorder-traversal-in-java.html)
  private List<E> inorder(BinaryNode<E> currentNode) {
    // Check if root is null
    if (currentNode == null) {
      return list; 
    }
    // Go left, then go right
    inorder(currentNode.left);
    list.add(currentNode.item);
    inorder(currentNode.right); 
    return list; 
  }
}
