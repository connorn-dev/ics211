package edu.ics211.h02;

/**
 * Singleton class that creates cheese.
 * 
 * @author narowetz
 */
public class ManoaCheeseFromager implements CheeseFromager {
  private static ManoaCheeseFromager instance;
  
  /**
   * Returns the singleton instance. 
   * 
   * @return the singleton instance 
   */
  public static ManoaCheeseFromager getInstance() {
    if (instance == null) {
      instance = new ManoaCheeseFromager(); 
    }
    return instance; 
  }
  
  
  /**
   * Hide Constructor because it is a singleton. 
   */
  private ManoaCheeseFromager() {
    // TODO Auto-generated constructor stub
  }
  
  

  
  @Override
  public Cheese makeCheese(String name, CheeseType type, Double fatPercentage) {
    if (type == CheeseType.FRESH) {
      return new Mozzarella(name, fatPercentage);
    }
    if (type == CheeseType.SOFT) {
      return new Brie(name, fatPercentage);
    }
    if (type == CheeseType.FIRM) {
      if (Math.random() >= 0.5) {
        return new Parmesan(name, fatPercentage);
      } else {
        return new Cheddar(name, fatPercentage);
      }
    }
    return null;
  }


  @Override
  public Cheese makeCheese(String name, CheeseType type) {
    if (type == CheeseType.FRESH) {
      return new Mozzarella(name);
    }
    if (type == CheeseType.SOFT) {
      return new Brie(name);
    }
    if (type == CheeseType.FIRM) {
      if (Math.random() >= 0.5) {
        return new Parmesan(name);
      } else {
        return new Cheddar(name);
      }
    }
    return null;
  }


  @Override
  public Cheese makeMozzarella(String name, Double fatPercentage) {
    Cheese makeMozzarella = new Mozzarella(name, fatPercentage);
    return makeMozzarella; 
  }


  @Override
  public Cheese makeMozzarella(String name) {
    Mozzarella makeMozzarella = new Mozzarella(name);
    return makeMozzarella; 
  }


  @Override
  public Cheese makeBrie(String name, Double fatPercentage) {
    Cheese makeBrie = new Brie(name, fatPercentage);
    return makeBrie;
  }


  @Override
  public Cheese makeBrie(String name) {
    Brie makeBrie = new Brie(name);
    return makeBrie; 
  }


  @Override
  public Cheese makeCheddar(String name, Double fatPercentage) {
    Cheese makeCheddar = new Cheddar(name, fatPercentage);
    return makeCheddar; 
  }


  @Override
  public Cheese makeCheddar(String name) {
    Cheddar makeCheddar = new Cheddar(name);
    return makeCheddar;
  }


  @Override
  public Cheese makeParmesan(String name, Double fatPercentage) {
    Cheese makeParmesan = new Parmesan(name, fatPercentage);
    return makeParmesan;
  }


  @Override
  public Cheese makeParmesan(String name) {
    Parmesan makeParmesan = new Parmesan(name);
    return makeParmesan;
  }

}
