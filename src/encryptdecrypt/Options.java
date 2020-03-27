package encryptdecrypt;

import java.io.File;

public class Options {
  private String mode = "enc";
  private String alg = "shift";
  private int key = 0;
  private String data = "";
  private File inputFile;
  private File outputFile;
  private boolean printToFile = false;

  public Options() {
  }

  public Options(String mode, int key, File inputFile, File outputFile) {
    this.mode = mode;
    this.key = key;
    this.inputFile = inputFile;
    this.outputFile = outputFile;
    this.printToFile = true;
  }

  public Options(String mode, int key, String data) {
    this.mode = mode;
    this.key = key;
    this.data = data;
    this.printToFile = false;
  }

  public String getAlg() {
    return alg;
  }

  public void setAlg(String alg) {
    this.alg = alg;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public File getInputFile() {
    return inputFile;
  }

  public void setInputFile(File inputFile) {
    this.inputFile = inputFile;
  }

  public File getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(File outputFile) {
    this.outputFile = outputFile;
  }

  public boolean isPrintToFile() {
    return printToFile;
  }

  public void setPrintToFile(boolean printToFile) {
    this.printToFile = printToFile;
  }

  public String getMessage() {
    if (inputFile != null) {
     return FileIOHandler.getMessageFromInputFile(this);
    }
    return data;
  }

  @Override
  public String toString() {
    return "Options{" +
        "mode='" + mode + '\'' +
        ", key=" + key +
        ", data='" + data + '\'' +
        ", inputFile=" + inputFile +
        ", outputFile=" + outputFile +
        ", printToFile=" + printToFile +
        '}';
  }
}
