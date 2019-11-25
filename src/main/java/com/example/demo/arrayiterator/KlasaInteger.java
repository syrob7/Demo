package com.example.demo.arrayiterator;

public class KlasaInteger implements ArrayIterator<Integer> {

    private int[][] array;
    private int rowIndex;
    private int columnIndex;

    public KlasaInteger(int[][] arr) {
        this.array = arr;
    }

    @Override
    public boolean hasNext() {
        if (rowIndex >= array.length)
            return false;
        if (columnIndex >= array[rowIndex].length &&
                (rowIndex >= array.length || rowIndex == array.length - 1))
            return false;
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new IllegalStateException("Iterator out of bounds");
        if (columnIndex >= array[rowIndex].length) {
            rowIndex++;
            columnIndex = 0;
        }
        return array[rowIndex][columnIndex++];
    }
}
