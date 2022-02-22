package edu.ics211.h03;

/**
 * Class that represents Cheddar cheese. 
 * 
 * @author narowetz
 */
public class Cheddar extends Firm {
  
  /**
   * Constructor that makes Cheddar cheese.
   * 
   * @param name of the cheese
   * @param fatPercentage is fat percentage represented as a double 
   */
  public Cheddar(String name, Double fatPercentage) {
    super(name, CheeseType.FIRM, fatPercentage);
    
  }
  
  /**
   * Constructor that makes Cheddar cheese with random fat %. 
   * 
   * @param name of the cheese 
   */
  public Cheddar(String name) {
    super(name, CheeseType.FIRM, Math.random() * ((60 - 5) + 1) + 5);
    
  }
  

}
