package edu.ics211.h05;

import java.util.Comparator;

/** 
 * A simple class to compare two strings together. 
 * 
 * @author narowetz
 *
 */
public class StringComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    return o1.compareTo(o2);
  }
}
