package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Translates asBinaryString, asHexadecimalString, and asUtf8String. 
 * @author Narowetz
 */
public class Translator implements Translate {

  /**
   * Main translator class. 
   */
  public Translator() {
    // TODO Auto-generated constructor stub
  }


  @Override
  //Credit: (Discord: Micah Tilton)
  public String asBinaryString(InputStream in) {
    // Create bit reader object from Input Stream
    try {
      BitReader br = new BitReader(in);
      // Create String builder
      StringBuilder myString = new StringBuilder();
      // Loop until bit reader is finished
      while (!br.isDone()) {
        // Append 0 or 1 from bit reader to string builder
        myString.append(br.readAsInt());
      }
      // Return string
      br.close();
      return myString.toString();
      // Catch Statement for error
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override
  //Credit: (Discord: Micah Tilton)
  public String asHexadecimalString(InputStream in) {
    // Create string builder
    StringBuilder myString = new StringBuilder();
    // Create variable for byte
    byte[] byteArr;
    try {
      // Loop through hex
      byteArr = in.readAllBytes();
      for (byte b: byteArr) {
        myString.append(String.format("%02x", b, Integer.toHexString(Integer.valueOf(b))));
      }
      // Return string
      return myString.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override
  // Credit: (Discord: Micah Tilton) 
  public String asUtf8String(InputStream in) {
    // Create bit reader
    try {
      BitReader br = new BitReader(in);
      byte[] byteArr = new byte[in.available() + 1];
      for (int i = 0; i < byteArr.length; i++) {
        byteArr[i] = br.readByte();
      }
      br.close();
      return new String(byteArr, "UTF-8");
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Main method.  
   */
  public static void main(String[] args) {

  }

}
