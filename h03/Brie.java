package edu.ics211.h03;

/**
 * Class that represents Brie cheese. 
 * 
 * @author narowetz
 */
public class Brie extends Soft {
  
  /**
   * Constructor that makes Brie cheese.
   * 
   * @param name of the cheese
   * @param fatPercentage is fat percentage represented as a double 
   */
  public Brie(String name, Double fatPercentage) {
    super(name, CheeseType.SOFT, fatPercentage);
    
  }
  
  /**
   * Constructor that makes Brie cheese with random fat %. 
   * 
   * @param name of the cheese 
   */
  public Brie(String name) {
    super(name, CheeseType.SOFT, Math.random() * ((60 - 5) + 1) + 5);
    
  }
  

}
