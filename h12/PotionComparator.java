package edu.ics211.h12;

import java.util.Comparator;

/**
 * Represents slow PotionBag. 
 *
 * @author narowetz
 *
 */
public class PotionComparator implements Comparator<Potion> {

  @Override
  public int compare(Potion o1, Potion o2) {
    // Return difference in hash number
    return o1.hashCode() - o2.hashCode(); 
  }
}
