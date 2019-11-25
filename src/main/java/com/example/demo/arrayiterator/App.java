package com.example.demo.arrayiterator;


public class App {

    public static void main(String args[]) {
        int[][] array = {{1,2,3}, {4,5,6,7}, {8,9,10,11,12}, {13,14,15,16,17,18}};

        ArrayIterator<Integer> arrayIterator = new KlasaInteger(array);

        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }

}
