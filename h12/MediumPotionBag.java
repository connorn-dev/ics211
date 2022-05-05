package edu.ics211.h12;

import java.util.TreeMap;

/**
 * Class for the medium potion bag, Using tree map because it can store 2 value pairs,
 * it is also at best bigO(logN). 
 * 
 * @author narowetz
 */
public class MediumPotionBag implements PotionBag {
  // Create static instance
  private static MediumPotionBag instance; 
  // Create tree map as it is medium speed for this  
  private TreeMap<Potion, Potion> potions = new TreeMap<Potion, Potion>(new PotionComparator()); 
  
  
  /**
   * Empty Constructor class. 
   */
  private MediumPotionBag() {
  }
  
  @Override
   public void store(Potion p) {
    // Put method on potion 
    potions.put(p, p); 
  }

  @Override
  public long timedStore(Potion p) {
    // Start time
    long st = System.nanoTime();
    store(p);
    long et = System.nanoTime(); 
    return et - st; 
  }

  @Override
  public Potion retrieve(Potion p) {
    // Retrieve method on potion 
    return potions.remove(p);
  }

  @Override
  public long timedRetrieve(Potion p) {
    // Same as timedStore
    long st = System.nanoTime(); 
    retrieve(p);
    long et = System.nanoTime(); 
    return et - st; 
  }

  @Override
  public int size() {
    // Return size
    return potions.size(); 
  }

  /**
   * Makes sure there is an instance. 
   */
  public static MediumPotionBag getInstance() {
    // Check for instance of class
    if (instance == null) {
      instance = new MediumPotionBag(); 
    }
    return instance; 
  }
  
}
