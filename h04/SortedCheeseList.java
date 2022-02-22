package edu.ics211.h04;

import java.util.Comparator;

/**
 * Class that implements IList211.
 * 
 * @author narowetz
 * 
 * @param <Cheese> is the type of cheese.
 */
public class SortedCheeseList<Cheese> implements IList211<Cheese> {

  private SortableList<Cheese> cheeseList;
  private Comparator<Cheese> compare;
  
  /**
   * Class that constructs the list.
   */
  public SortedCheeseList(Comparator<Cheese> compare) {
    this.cheeseList = new SortableList<Cheese>();
    this.compare = compare; 
  }

  @Override
  public Cheese get(int index) {
    return cheeseList.get(index);
  }

  @Override
  public Cheese set(int index, Cheese element) {
    Cheese temp = cheeseList.set(index, element);
    cheeseList.insertionSort(compare);
    return temp; 
  }

  @Override
  public int indexOf(Object obj) {
    return cheeseList.indexOf(obj);
  }

  @Override
  public int size() {
    return cheeseList.size();
  }

  @Override
  public boolean add(Cheese e) {
    boolean temp; 
    temp = cheeseList.add(e);
    cheeseList.insertionSort(compare);
    return temp; 
  }

  @Override
  public void add(int index, Cheese element) {
    cheeseList.add(index, element);
    cheeseList.insertionSort(compare);
  }

  @Override
  public Cheese remove(int index) {
    return cheeseList.remove(index);
  }
  
}
