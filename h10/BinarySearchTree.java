package edu.ics211.h10;

import java.util.Comparator;
import java.util.List;


public class BinarySearchTree<E> implements InOrder<E>, SearchTree<E> {

  // Search Tree Variables
  private BinaryNode<E> root;
  public Comparator<E> comp;
  private int size; 
  
  // Return method variables
  private boolean addMethod; 
  private boolean deleteMethod; 
  
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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public E find(E target) {
    // Start with first recursive Call
    return findRecursive(root, target); 
  }
  
  private E findRecursive(BinaryNode<E> currentNode, E target) {
    return null;
  }

  @Override
  public E delete(E target) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(E target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    return size; 
  }

  @Override
  public List<E> inorder() {
    // TODO Auto-generated method stub
    return null;
  }



}
