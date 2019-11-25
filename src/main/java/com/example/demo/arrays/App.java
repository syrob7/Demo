package com.example.demo.arrays;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5};

        int[] output = product(arr);

        Arrays.stream(output)
                .forEach(System.out::println);
    }

    public static int[] product(int[] input) {
        int product = 1;
        int numZeros = 0;
        int[] output = new int[input.length];

        for (int ii = 0; ii < input.length; ii++) {
            if (input[ii] == 0) {
                numZeros++;
            } else {
                product = product * input[ii];
            }
        }

        if (numZeros == 1) {
            for (int ii = 0; ii < input.length; ii++) {
                if (input[ii] == 0) {
                    output[ii] = product;
                }
            }
        } else if (numZeros == 0) {
            for (int ii = 0; ii < input.length; ii++) {
                output[ii] = product / input[ii];
            }
        }

        return output;
    }
}
