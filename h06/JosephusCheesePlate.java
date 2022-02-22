package edu.ics211.h06;

import edu.ics211.h02.Cheese;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


/**
 * A class which represents a JosephusCheesePlate.
 * 
 * @author narowetz
 *
 */
public class JosephusCheesePlate implements ICheeseTasting {
  Cheese[] array; 
  
  /**
   * A constructor method that creates the JosephusCheesePlate. 
   *
   */
  public JosephusCheesePlate(Cheese[] cheeses) {
    this.array = cheeses; 
  }
  
  
  @Override
  public List<Cheese> tasteCheeses(int start, int step, boolean isClockwise) {
    
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>(array);
    LinkedList<Cheese> tastedCheese = new LinkedList<Cheese>();   
    ListIterator<Cheese> iterator = (ListIterator<Cheese>) list.iterator();    
    
    if (isClockwise) {
      // Loop to the starting variable
      for (int i = 0; i < start - 1; i++) {
        iterator.next(); 
      }
      int size = list.size();
      while (tastedCheese.size() < size) {
        for (int j = 0; j < step - 1; j++) {
          iterator.next();
        }
        iterator.remove();
        tastedCheese.add(iterator.next());
      }
    } else {
      iterator.next(); 
      for (int i = 0; i < start - 1; i++) {
        iterator.next(); 
      }
      int size = list.size();
      while (tastedCheese.size() < size) {
        for (int j = 0; j < step - 1; j++) {
          iterator.previous();
        }
        tastedCheese.add(iterator.previous());
        iterator.remove();
      }
    }
    return tastedCheese;
  }
}