package edu.ics211.h03;

/**
 * Class that represents Parmesan cheese. 
 * 
 * @author narowetz
 */
public class Parmesan extends Firm {
  
  /**
   * Constructor that makes Parmesan cheese.
   * 
   * @param name of the cheese
   * @param fatPercentage is fat percentage represented as a double 
   */
  public Parmesan(String name, Double fatPercentage) {
    super(name, CheeseType.FIRM, fatPercentage);
    
  }
  
  /**
   * Constructor that makes Parmesan cheese with random fat %. 
   * 
   * @param name of the cheese 
   */
  public Parmesan(String name) {
    super(name, CheeseType.FIRM, Math.random() * ((60 - 5) + 1) + 5);
    
  }
  

}
