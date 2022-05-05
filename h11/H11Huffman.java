package edu.ics211.h11;

/**
 * Where the huffman encoder program starts and runs. 
 *
 * @author narowetz
 */
public class H11Huffman {

  /**
   * Start of the program.
   */
  public static void main(String[] args) {
    // Set argument to string
    String fileName = args[0];
    // Check if ends with .huff
    if (!fileName.endsWith(".huff")) {
      System.err.println("Try agian and, use a file with .huff");
      System.exit(1);
    }
    
    // If all good continue to make new file
    // Create new file
    // Then the data through the huffman tree and add to the new file.
    // Return the file to the user and remove the .huff
  }

}
