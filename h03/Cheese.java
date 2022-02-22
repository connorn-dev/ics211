package edu.ics211.h03;

/**
 * Abstract class that represents the cheese objects.
 * 
 * @author narowetz
 * 
 */
public abstract class Cheese implements Comparable<Cheese> {
  private String name;
  private CheeseType type; 
  private Double fatPercentage; 
  
  /**
   * Creates new Cheese.
   * 
   * @param name is the name of the cheese.
   * @param type is the type of the cheese.
   * @param fatPercentage is the fat % for the cheese as double.
   */
  protected Cheese(String name, CheeseType type, Double fatPercentage) {
    super();
    this.name = name;
    this.type = type; 
    this.fatPercentage = fatPercentage;
  }
  
  /**
   * Returns the name of the cheese.
   * 
   * @return name;
   */
  public String getName() {
    return name;
  }
  
  /**
   * Returns the type of cheese.
   * 
   * @return the type of cheese
   */
  public CheeseType getType() {
    return type; 
  }
  
  /**
   * Returns the fat percentage of the cheese.
   * 
   * @return the fat percentage as a double of the cheese
   */
  public Double getFatPercentage() {
    return fatPercentage;
  }
  
  /**
   * Sets the cheese's name.
   * 
   * @param name of cheese as a String type
   */
  public void setName(String name) {
    this.name  = name; 
  }
  
  /**
   * Compares the cheese.
   * 
   * @return integer compared against
   */
  public int compareTo(Cheese o) {
    return this.name.compareTo(o.name);
  }

}
