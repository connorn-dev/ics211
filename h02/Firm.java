package edu.ics211.h02;

/**
 * Class that represents fresh cheese. 
 * 
 * @author narowetz
 */
public abstract class Firm extends Cheese {

  protected Firm(String name, CheeseType type, Double fatPercentage) {
    super(name, type, fatPercentage);
  }

}
