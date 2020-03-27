package encryptdecrypt;

public interface EncryptionAlgorithm {
    public void encrypt(Options options);

    public void decrypt(Options options);
}
