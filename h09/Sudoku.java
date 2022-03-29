package edu.ics211.h09;

import java.util.ArrayList;

/**
 * Class for recursively finding a solution to a Sudoku problem.
 *
 * @author Biagioni, Edoardo, Cam Moore

 */
public class Sudoku {
  
  /**
   * Find an assignment of values to sudoku cells that makes the sudoku valid.
   *
   * @param sudoku the sudoku to be solved
   * @return whether a solution was found if a solution was found, the sudoku is filled in with the
   */
  public static boolean solveSudoku(int[][] sudoku) {
    // Loop over the sudoku, find an empty cell.
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        if (sudoku[i][j] == 0) {
          // Once found, create ArrayList with all the possible values with legal values function.
          ArrayList<Integer> possibleValues = legalValues(sudoku, i, j);
          // Check possibleValues to verify some exist, if not, it is not solution return false
          if (possibleValues.size() == 0) {
            return false; 
          }
          // For every value in the possibleValues, try with the sudoku problem.
          for (int k = 0; k < possibleValues.size(); k++) {
            sudoku[i][j] = possibleValues.get(k);
            // Make recursive call to see if there is a solution with current number in cell 
            if (solveSudoku(sudoku) == true) {
              return true; 
            } else {
              // If no solution, set cell to zero so backtracking works.
              sudoku[i][j] = 0; 
            }
            // After checking all possibleValues, return false if none worked, not solution. 
          }
          return false; 
        }
      }
    }
    // After filling every cell, check sudoku. If true, sudoku solution found, return true; 
    if (checkSudoku(sudoku, true)) {
      return true; 
    } else {
      return false; 
    }
  }



  /**
   * Find the legal values for the given sudoku and cell.
   *
   * @param sudoku the sudoku being solved.
   * @param row the row of the cell to get values for.
   * @param column the column of the cell.
   * @return an ArrayList of the valid values.
   */
  public static ArrayList<Integer> legalValues(int[][] sudoku, int row, int column) {
    // Create ArrayList for values.
    ArrayList<Integer> vals = new ArrayList<Integer>(); 
    // Verify cell is empty, in case above fails.
    if (sudoku[row][column] != 0) {
      return null;
    }
    // Try every possible value 1-9. 
    for (int i = 1; i < 10; i++) {
      // Set new value to cell. 
      sudoku[row][column] = i;
      // See if value is valid with checkSudoku. 
      if (checkSudoku(sudoku, false)) {
        vals.add(i);
      }
    }
    // Set back to zero.
    sudoku[row][column] = 0; 
    // Return ArrayList of Values.
    return vals; 
  }


  /**
   * checks that the sudoku rules hold in this sudoku puzzle. cells that contain 0 are not checked.
   *
   * @param sudoku to be checked
   * @param printErrors whether to print the error found, if any
   * @return true if this sudoku obeys all of the sudoku rules, otherwise false
   */
  public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
    if (sudoku.length != 9) {
      if (printErrors) {
        System.out.println("sudoku has " + sudoku.length + " rows, should have 9");
      }
      return false;
    }
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i].length != 9) {
        if (printErrors) {
          System.out.println("sudoku row " 
              + i + " has " + sudoku[i].length + " cells, should have 9");
        }
        return false;
      }
    }
    /* check each cell for conflicts */
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        int cell = sudoku[i][j];
        if (cell == 0) {
          continue; /* blanks are always OK */
        }
        if ((cell < 1) || (cell > 9)) {
          if (printErrors) {
            System.out.println("sudoku row " + i + " column " + j + " has illegal value " + cell);
          }
          return false;
        }
        /* does it match any other value in the same row? */
        for (int m = 0; m < sudoku.length; m++) {
          if ((j != m) && (cell == sudoku[i][m])) {
            if (printErrors) {
              System.out.println("sudoku row " + i 
                  + " has " + cell + " at both positions " + j + " and " + m);
            }
            return false;
          }
        }
        /* does it match any other value it in the same column? */
        for (int k = 0; k < sudoku.length; k++) {
          if ((i != k) && (cell == sudoku[k][j])) {
            if (printErrors) {
              System.out.println("sudoku column " 
                  + j + " has " + cell + " at both positions " + i + " and " + k);
            }
            return false;
          }
        }
        /* does it match any other value in the 3x3? */
        for (int k = 0; k < 3; k++) {
          for (int m = 0; m < 3; m++) {
            int testRow = (i / 3 * 3) + k; /* test this row */
            int testCol = (j / 3 * 3) + m; /* test this col */
            if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
              if (printErrors) {
                System.out.println("sudoku character " + cell + " at row " + i + ", column " + j
                    + " matches character at row " + testRow + ", column " + testCol);
              }
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * Converts the sudoku to a printable string.
   *
   * @param sudoku to be converted
   * @param debug whether to check for errors
   * @return the printable version of the sudoku
   */
  public static String toString(int[][] sudoku, boolean debug) {
    if ((!debug) || (checkSudoku(sudoku, true))) {
      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 3 == 0) {
          result = result + "+-------+-------+-------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 3 == 0) {
            result = result + "| ";
          }
          if (sudoku[i][j] == 0) {
            result = result + "  ";
          } else {
            result = result + sudoku[i][j] + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+-------+-------+-------+\n";
      return result;
    }
    return "illegal sudoku";
  }
}