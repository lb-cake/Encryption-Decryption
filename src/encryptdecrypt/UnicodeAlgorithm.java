package encryptdecrypt;

public class UnicodeAlgorithm implements EncryptionAlgorithm {

  @Override
  public void encrypt(Options options) {
    StringBuilder encryptedMessage = new StringBuilder();
    String message;
    if (options.getData().equals("")) {
      // we know that this default has not been overriden
      message = FileIOHandler.getMessageFromInputFile(options);
    } else {
      message = options.getData();
    }

    // actual encryption starts here...
    char[] arr = message.toCharArray();
    for (char a : arr) {
      int asciiCode = convertCharToASCII(a);
      asciiCode = asciiCode + options.getKey();
      encryptedMessage.append(convertIntToChar(asciiCode));
    }

    if (options.getOutputFile() != null) {
      FileIOHandler.writeToOutputFile(options, encryptedMessage.toString());
    } else {
      System.out.println(encryptedMessage.toString());
    }
  }

  @Override
  public void decrypt(Options options) {
    StringBuilder decryptedMessage = new StringBuilder();
    String message;
    if (options.getData().equals("")) {
      message = FileIOHandler.getMessageFromInputFile(options);
    } else {
      message = options.getData();
    }

    // actual decryption starts here
    char arr[] = message.toCharArray();
    for (char a : arr) {
      int asciiCode = convertCharToASCII(a);
      asciiCode = asciiCode - options.getKey();
      decryptedMessage.append(convertIntToChar(asciiCode));
    }

    if (options.getOutputFile() != null) {
      FileIOHandler.writeToOutputFile(options, decryptedMessage.toString());
    } else {
      System.out.println(decryptedMessage.toString());
    }
  }

  private char convertIntToChar(int i) {
    return (char) i;
  }

  private int convertCharToASCII(char c) {
    return c;
  }
}
