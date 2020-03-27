package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOHandler {

  public static String getMessageFromInputFile(Options options) {
    StringBuilder sb = new StringBuilder();
    try (Scanner sc = new Scanner(options.getInputFile())) {
      while (sc.hasNext()) {
        sb.append(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }

  public static void writeToOutputFile(Options options, String message) {
    try (PrintWriter writer = new PrintWriter(options.getOutputFile())) {
      writer.println(message);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
