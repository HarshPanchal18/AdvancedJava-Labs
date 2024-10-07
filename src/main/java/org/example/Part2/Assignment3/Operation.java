package org.example.Part2.Assignment3;

import javax.crypto.*;
import java.io.*;

public class Operation {

    static void writeFile(File file, byte[] bytes) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            System.out.println("File writing failed...");
        }
    }

    static byte[] readFile(File file) {
        FileInputStream fis;
        byte[] data = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(data);
            fis.close();
        } catch (IOException e) {
            System.out.println("File reading failed...");
        }

        return data;
    }

    // NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
    static byte[] encrypt(SecretKey key, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(Const.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    static byte[] decrypt(SecretKey key, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(Const.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    static void encryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {
        byte[] ipBytes = readFile(inputFile); // IOException
        byte[] opBytes = encrypt(key, ipBytes);
        writeFile(outputFile, opBytes);
    }

    static void decryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {
        byte[] ipBytes = readFile(inputFile); // IOException
        byte[] opBytes = decrypt(key, ipBytes);
        writeFile(outputFile, opBytes);
    }

    static void transfer(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(Const.RESULT_FILE);

            byte[] buffer = new byte[10]; // 1-MB
            int length;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            fis.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("File transferring failed...");
        }
    }

}