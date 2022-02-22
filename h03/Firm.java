package edu.ics211.h03;

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
