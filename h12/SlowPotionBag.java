package edu.ics211.h12;


/**
 * Class for the slow potion bag, Using array because it can store 2 value pairs,
 * it is also bigO(n). 
 * 
 * @author narowetz
 */
public class SlowPotionBag implements PotionBag {
  // Create static instance
  private static SlowPotionBag instance; 
  // Going to do array for the slow potion bag because it is the slowest
  // But will have to implement methods 
  // Start with size of 200k to be safe
  private Potion[] potions = new Potion[200000]; 
  
  
  /**
   * Empty Constructor class. 
   */
  private SlowPotionBag() {
  }
  
  @Override
  public void store(Potion p) {
    // Stores in next open array index
    for (int i = 0; i < potions.length; i++) {
      if (potions[i] == null) {
        potions[i] = p; 
        // Break from loop 
        break; 
      }
    }
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
    // Find the potion in the array
    for (int i = 0; i < potions.length; i++) {
      if (potions[i].equals(p)) {
        return potions[i];
      }
    }
    // If not in array return null
    return null; 
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
    // Loop through until first null and return index
    for (int i = 0; i < potions.length; i++) {
      if (potions[i] == null) {
        return i; 
      }
    }
    return potions.length; 
  }

  /**
   * Makes sure there is an instance. 
   */
  public static SlowPotionBag getInstance() {
    // Check for instance of class
    if (instance == null) {
      instance = new SlowPotionBag(); 
    }
    return instance; 
  }
  
}
