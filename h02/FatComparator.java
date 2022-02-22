package edu.ics211.h02;

import java.util.Comparator;

/**
 * Represents a comparator that compares fat values.
 *
 * @author Narowetz
 *
 */
public class FatComparator implements Comparator<Cheese> {

  @Override
  public int compare(Cheese o1, Cheese o2) {
    if (o1.getFatPercentage() > o2.getFatPercentage()) {
      return 1; 
    } else if (o1.getFatPercentage() == o2.getFatPercentage()) {
      return 0;
    } else {
      return -1; 
    }

  }

}
