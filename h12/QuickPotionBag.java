package edu.ics211.h12;

import java.util.Hashtable;

/**
 * Class for the quick potion bag, Using hash table because it can store 2 value pairs,
 * it is also at best bigO(1). 
 * 
 * @author narowetz
 */
public class QuickPotionBag implements PotionBag {
  // Create static instance
  private static QuickPotionBag instance; 
  // Create Hash table
  private Hashtable<Potion, Potion> potions = new Hashtable<Potion, Potion>(); 
  
  // Source: https://stackoverflow.com/questions/63665781/incorrect-number-of-arguments-for-type-liste-it-cannot-be-parameterized-with
  
  /**
   * Empty Constructor class. 
   */
  private QuickPotionBag() {
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
  public static QuickPotionBag getInstance() {
    // Check for instance of class
    if (instance == null) {
      instance = new QuickPotionBag(); 
    }
    return instance; 
  }
  
}
