package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class that represents Readfile object to read files.
 * 
 * @author narowetz
 */
public class ReadFile implements IReadFile {

  @Override
  public String readFile(String fileName) throws IOException {
    
    DataInputStream in = new DataInputStream(new FileInputStream(fileName));
    
    // Read how many bytes there are
    int numberOfBytes = in.readInt();
    System.out.println(numberOfBytes);
    
    // Find out what scheme is being used for encoding
    Byte encoding = in.readByte();
    System.out.println(encoding);
    
    // Create new byte array
    byte[] b = new byte[numberOfBytes];
    
    // Read data into the array
    int bytes = in.read(b);
    System.out.println(bytes);
    
    // Create string based on encoding and array contents
    String str;
    if (encoding == 1) {
      str = new String(b, StandardCharsets.US_ASCII);
    } else if (encoding == 2) {
      str = new String(b, StandardCharsets.UTF_16LE);
    } else if (encoding == 3) {
      str = new String(b, StandardCharsets.UTF_8);
    } else if (encoding == 4) {
      str = new String(b, StandardCharsets.UTF_16);
    } else {
      str = new String("error");
    }
    in.close();
    return str; 
  }

}
