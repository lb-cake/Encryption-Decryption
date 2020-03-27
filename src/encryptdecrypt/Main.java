package encryptdecrypt;

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    Options cli = getCommandLineArgs(args);
    System.out.println(cli.toString());
    if (cli.getAlg().equals("unicode")) {
      UnicodeAlgorithm ua = new UnicodeAlgorithm();
      if (cli.getMode().equals("enc")) {
        ua.encrypt(cli);
      } else {
        ua.decrypt(cli);
      }
    } else {
      ShiftAlgorithm sa = new ShiftAlgorithm();
      if (cli.getMode().equals("enc")) {
        sa.encrypt(cli);
      } else {
        sa.decrypt(cli);
      }
    }
  }

  /**
   * @param args
   * @return
   */
  public static Options getCommandLineArgs(String[] args) throws IOException {
    // search for mode
    Options struct = new Options();
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-mode")) {
        // get the next argument
        if (args[i + 1].equals("dec")) {
          struct.setMode("dec");
        } else if (args[i + 1].equals("enc")) {
          struct.setMode("enc");
        } else {
          System.err.println("Error - improper mode. Need either enc or dec");
        }
      } else if (args[i].equals("-key")) {
        struct.setKey(Integer.parseInt(args[i + 1]));
      } else if (args[i].equals("-alg")) {
        System.out.println("setting algorithm");
        struct.setAlg(args[i + 1]);
      } else if (args[i].equals("-data")) {
        struct.setData(args[i + 1]);
      } else if (args[i].equals("-in")) {
        struct.setInputFile(new File(args[i + 1]));
      } else if (args[i].equals("-out")) {
        struct.setOutputFile(new File(args[i + 1]));
        struct.getOutputFile().createNewFile();
      }
    }
    return struct;
  }
}
