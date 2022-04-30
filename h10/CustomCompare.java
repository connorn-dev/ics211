package edu.ics211.h10;

import java.util.Comparator;

/**
 * This comparator compares cars from slowest to fastest the order goes.
 * bmw --> audi --> lambo
 * So the more characters the word has, the faster it is. 
 * 
 * @author narowetz
 *
 */
public class CustomCompare implements Comparator<String> {

  @Override
  public int compare(String car1, String car2) {
    final int car1C = car1.length(); 
    final int car2C = car2.length(); 
    if (car1C > car2C) {
      return 1; 
    } else if (car1C == car2C) {
      return 0; 
    } else {
      return -1; 
    }
  }
}
