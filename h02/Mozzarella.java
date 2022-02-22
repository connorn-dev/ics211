package edu.ics211.h02;

/**
 * Class that represents Mozzarella cheese. 
 * 
 * @author narowetz
 */
public class Mozzarella extends Fresh {
  
  /**
   * Constructor that makes Mozzarella cheese.
   * 
   * @param name of the cheese
   * @param fatPercentage is fat percentage represented as a double 
   */
  public Mozzarella(String name, Double fatPercentage) {
    super(name, CheeseType.FRESH, fatPercentage);
    
  }
  
  /**
   * Constructor that makes Mozzarella cheese with random fat %. 
   * 
   * @param name of the cheese 
   */
  public Mozzarella(String name) {
    super(name, CheeseType.FRESH, Math.random() * ((60 - 5) + 1) + 5);
    
  }
  

}
