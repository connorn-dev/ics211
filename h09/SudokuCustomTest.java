package edu.ics211.h09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SudokuCustomTest {

  @Test
  void test() {
    // !!!!! TEST TAKES A GOOD WHILE TO COMPLETE, BECAUSE COMPLEX SUDOKU.....
    // !!!!! WAIT FOR TEST TO FINISH !!!!!
    // !!!!! TEST TAKES A GOOD WHILE TO COMPLETE, BECAUSE COMPLEX SUDOKU.....
    // !!!!! WAIT FOR TEST TO FINISH !!!!!
    // We need to test the solveSudoku method and the legalValues method for correctness. 
    
    // Create two hard Sudoku's to use to test both methods. 
    int[][] sudokuToTest1 = { 
        { 0, 1, 0, 0, 2, 0, 7, 0, 0 }, { 0, 0, 9, 0, 1, 7, 0, 0, 2 }, 
        { 7, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 4, 0, 0, 0, 0, 0, 0, 0 }, 
        { 2, 5, 0, 0, 9, 0, 0, 7, 6 }, { 0, 0, 0, 0, 0, 0, 0, 9, 0 },
        { 0, 8, 0, 0, 0, 0, 0, 0, 3 }, { 4, 0, 0, 1, 7, 0, 2, 0, 0 }, 
        { 0, 0, 5, 0, 6, 0, 0, 8, 0 } };
    
    int[][] sudokuToTest1Solution = { 
        { 8, 1, 4, 6, 2, 3, 7, 5, 9 }, { 5, 6, 9, 8, 1, 7, 4, 3, 2 }, 
        { 7, 3, 2, 5, 4, 9, 6, 1, 8 }, { 9, 4, 6, 7, 3, 5, 8, 2, 1 }, 
        { 2, 5, 8, 4, 9, 1, 3, 7, 6 }, { 3, 7, 1, 2, 8, 6, 5, 9, 4 },
        { 6, 8, 7, 9, 5, 2, 1, 4, 3 }, { 4, 9, 3, 1, 7, 8, 2, 6, 5 }, 
        { 1, 2, 5, 3, 6, 4, 9, 8, 7 } };
    
    int[][] sudokuToTest2 = { 
        { 0, 9, 0, 0, 0, 7, 0, 0, 0 }, { 0, 4, 0, 0, 1, 0, 0, 9, 5 }, 
        { 0, 0, 1, 0, 8, 0, 2, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 0 }, 
        { 0, 6, 5, 0, 2, 0, 4, 8, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 2 },
        { 0, 0, 4, 0, 6, 0, 1, 0, 0 }, { 3, 2, 0, 0, 5, 0, 0, 7, 0 }, 
        { 0, 0, 0, 9, 0, 0, 0, 3, 0 } };
    
    int[][] sudokuToTest2Solution = { 
        { 2, 9, 3, 5, 4, 7, 8, 6, 1 }, { 8, 4, 7, 2, 1, 6, 3, 9, 5 }, 
        { 6, 5, 1, 3, 8, 9, 2, 4, 7 }, { 7, 1, 2, 4, 3, 8, 9, 5, 6 }, 
        { 9, 6, 5, 7, 2, 1, 4, 8, 3 }, { 4, 3, 8, 6, 9, 5, 7, 1, 2 },
        { 5, 7, 4, 8, 6, 3, 1, 2, 9 }, { 3, 2, 9, 1, 5, 4, 6, 7, 8 }, 
        { 1, 8, 6, 9, 7, 2, 5, 3, 4 } };
    
    
    // Legal values test -> 
    
    assertNotNull(sudokuToTest1);
    assertNotNull(sudokuToTest2);
    ArrayList<Integer> test1 = Sudoku.legalValues(sudokuToTest1, 0, 1);
    // Test and make sure no possible values, because it is f3illed. 
    assertEquals(null, test1);
    // Test the first empty value.
    ArrayList<Integer> test2 = Sudoku.legalValues(sudokuToTest1, 0, 0);
    assertEquals(4, test2.size());
    assertEquals(3, (int) test2.get(0));
    assertEquals(5, (int)test2.get(1));
    assertEquals(6, (int)test2.get(2));
    assertEquals(8, (int)test2.get(3));
    // Test the last empty value.
    ArrayList<Integer> test3 = Sudoku.legalValues(sudokuToTest1, 8, 8);
    assertEquals(4, test3.size());
    assertEquals(1, (int)test3.get(0));
    assertEquals(4, (int)test3.get(1));
    assertEquals(7, (int)test3.get(2));
    assertEquals(9, (int)test3.get(3));
    
    // solveSudoku test -> 
    
    // Give sudoku's to solve
    Sudoku.solveSudoku(sudokuToTest1);
    Sudoku.solveSudoku(sudokuToTest2);
    
    
    // Make sure the Sudoku is still 9x9 and all cells are filled.
    // At the same time compare values of sudoku to solution and make sure are same.
    // This takes a while because complex sudoku, took 10 seconds on my machine. 
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        assertEquals(sudokuToTest1Solution[i][j], sudokuToTest1[i][j]);
        assertEquals(sudokuToTest2Solution[i][j], sudokuToTest2[i][j]);
      }
    }
  }

}
