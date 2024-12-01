package org.example.IO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadingRandomAccessFiles {
    public static void main(String[] args) {

        try {
            // Creating a new file
            RandomAccessFile raFile = new RandomAccessFile("Random.txt", "rw");

            raFile.write("Hello File".getBytes()); // Writing to file
            raFile.seek(0); // Setting FilePointer

            System.out.println(raFile.read()); // Reading single byte

            raFile.seek(0); // Re-Setting FilePointer

            byte[] b = {1, 2, 3};

            System.out.println(".read(byte[]): " + raFile.read(b));
            System.out.println(".readBoolean(): " + raFile.readBoolean());
            System.out.println(".readByte(): " + raFile.readByte());

            // Reach EOF
            raFile.seek(raFile.length());
            raFile.write('G');

            raFile.seek(0);

            byte[] arr = new byte[(int) raFile.length()];
            raFile.readFully(arr);

            String s1 = new String(arr);
            System.out.println(".readFully(): " + s1);

            raFile.seek(0);

            raFile.read(arr, 0, 8);
            String s2 = new String(arr);
            System.out.println("Use of readFully(byte[] b, int off, int len) : " + s2);

            raFile.close();

        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}