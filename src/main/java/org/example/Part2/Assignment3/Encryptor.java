package org.example.Part2.Assignment3;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.security.NoSuchAlgorithmException;

import static org.example.Part2.Assignment3.Const.*;

public class Encryptor {

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();
        File inputFile = new File(INPUT_FILE);
        File encryptedFile = new File(ENCRYPTED_FILE);

        Operation.encryptFile(key, inputFile, encryptedFile);

        System.out.println("File has been encrypted...");

        Operation.transfer(encryptedFile); // Transfer file

        File receivedFile = new File(RESULT_FILE);
        File decryptedFile = new File(DECRYPTED_FILE);

        Operation.decryptFile(key, receivedFile, decryptedFile);

        Operation.readFile(decryptedFile); // Read and decrypt file content

    }

    static SecretKey generateKey() {
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance(Const.ALGORITHM);
            generator.init(KEY_SIZE);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error generating key... Check algorithm...");
        }

        return (generator != null) ? generator.generateKey() : null;
    }

}