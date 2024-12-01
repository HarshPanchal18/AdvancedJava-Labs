package org.example.LabPracticals;

import java.util.Arrays;

public class ArrCopy {

    public static void main(String[] args) {
        // Original Array
        int[] A = {1, 2, 3, 4, 5, 6};
        System.out.print("Original Array : ");
        System.out.print(Arrays.toString(A));

        // size of the index
        int n = A.length;

        // Index at which the element be added
        int p = 2;

        // element that needs to be added
        int x = 10;

        // new Array of size +1
        // of the original array
        int[] B = new int[n + 1];

        // copy till pth index
        System.arraycopy(A, 0, B, 0, p);

        // copy from pth position to end of array A to array B
        System.arraycopy(A, p, B, p + 1, n - p);

        // replacing the pth character from 0 to x
        B[p] = x;

        System.out.println(Arrays.toString(B));
    }
}