package encryptdecrypt;

import java.util.Arrays;
import java.util.List;

public class ShiftAlgorithm implements EncryptionAlgorithm {

  private Character[] upperAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private Character[] lowerAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
      'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


  /**
   * @return
   */
  @Override
  public void encrypt(Options options) {
    StringBuilder encryptedMessage = new StringBuilder();
    String message = options.getMessage();
    char[] arr = message.toCharArray();
    List<Character> upperAlphabetList = Arrays.asList(upperAlphabet);
    List<Character> lowerAlphabetList = Arrays.asList(lowerAlphabet);
    for (int i = 0; i < arr.length; i++) {
      if (upperAlphabetList.contains(arr[i])) {
        encryptedMessage.append(shiftedLetterEncryption(options, arr[i], true));
      } else if (lowerAlphabetList.contains(arr[i])) {
        encryptedMessage.append(shiftedLetterEncryption(options, arr[i], false));
      } else {
        encryptedMessage.append(arr[i]);
      }
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
    String message = options.getMessage();
    char[] arr = message.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (Arrays.asList(upperAlphabet).contains(arr[i])) {
        decryptedMessage.append(shiftedLetterDecryption(options, arr[i], true));
      } else if (Arrays.asList(lowerAlphabet).contains(arr[i])) {
        decryptedMessage.append(shiftedLetterDecryption(options, arr[i], false));
      } else {
        decryptedMessage.append(arr[i]);
      }
    }

    if (options.getOutputFile() != null) {
      FileIOHandler.writeToOutputFile(options, decryptedMessage.toString());
    } else {
      System.out.println(decryptedMessage.toString());
    }
  }

  private char shiftedLetterDecryption(Options options, char letter, boolean isUpper) {
    // get the index of the letter in relation to the alphabet
    int index = 0;
    if (isUpper) {
      for (int i = 0; i < upperAlphabet.length; i++) {
        if (letter == upperAlphabet[i]) {
          index = i;
        }
      }
    } else {
      for (int i = 0; i < lowerAlphabet.length; i++) {
        if (letter == lowerAlphabet[i]) {
          index = i;
        }
      }
    }

    if (index - options.getKey() < 0) {
      System.out.println("yeah this is less?");
      index = (index - options.getKey()) + 26;
    } else {
      index = index - options.getKey();
    }

    if (isUpper) {
      return upperAlphabet[index];
    }
    return lowerAlphabet[index];
  }

  private char shiftedLetterEncryption(Options options, char letter, boolean isUpper) {
    // get the index of the letter in relation to the alphabet
    int index = 0;
    if (isUpper) {
      for (int i = 0; i < upperAlphabet.length; i++) {
        if (letter == upperAlphabet[i]) {
          index = i;
        }
      }
    } else {
      for (int i = 0; i < lowerAlphabet.length; i++) {
        if (letter == lowerAlphabet[i]) {
          index = i;
        }
      }
    }

    if (index + options.getKey() > 26) {
      index = (index + options.getKey()) - 26;
    } else {
      index = index + options.getKey();
    }

    if (isUpper) {
      return upperAlphabet[index];
    }
    return lowerAlphabet[index];
  }
}
