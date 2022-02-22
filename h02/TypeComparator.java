package edu.ics211.h02;

import java.util.Comparator;

/**
 * Represents a comparator that compares cheese types.
 *
 * @author Narowetz
 *
 */
public class TypeComparator implements Comparator<Cheese> {

  @Override
  public int compare(Cheese o1, Cheese o2) {
    if (o1.getType().compareTo(o2.getType()) > 0) {
      return 1; 
    } else if (o1.getType().compareTo(o2.getType()) == 0) {
      return 0;
    } else {
      return -1;
    }
  }

}
