package com.example.demo.fillingslots;

// Java program to print all combination of size slots in an array
// of size n with repetitions allowed

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FillSlotsWithRepetitions {

    /**
     *
     * @param chosen - Temporary array to store indices of current combination
     * @param arr    - Input Array
     * @param output - output list with ordered permutation
     * @param index  - index
     * @param slot      - size of a slot
     * @param start  - Staring indexes in arr[]
     * @param end    - Ending indexes in arr[]
     */
    static void permutationsOfFilledSlotsUtil(int chosen[], int arr[], List<List<Integer>> output,
                                          int index, int slot, int start, int end) {
        if (index == slot) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < slot; i++) {
                list.add(arr[chosen[i]]);
            }
            output.add(list);

            return;
        }

        // One by one choose all elements (without considering
        // the fact whether element is already chosen or not)
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            permutationsOfFilledSlotsUtil(chosen, arr, output,index + 1,
                    slot, i, end);
        }
        return;
    }

    /**
     *
     * @param values - Given a set of integer values
     * @param noSlot - size of a slot
     * @return output list with ordered permutation with repetitions
     */
    static List<List<Integer>> permutationsOfFilledSlots(Set<Integer> values, int noSlot) {
        int arr[] = new int[values.size()];
        int chosen[] = new int[noSlot];
        List<List<Integer>> output = new ArrayList<>();
        int inx = 0;

        //initialize array
        Iterator<Integer> itr = values.iterator();
        while(itr.hasNext()) {
            arr[inx++] = itr.next();
        }

        permutationsOfFilledSlotsUtil(chosen, arr, output,0, noSlot, 0, arr.length - 1);

        return output;
    }

    public static void main(String[] args) {
        Set<Integer> set = Stream.of(1, 2, 3).collect(Collectors.toCollection(TreeSet::new));
        int noSlot = 5;

        List<List<Integer>> output = permutationsOfFilledSlots(set, noSlot);

        output
                .stream()
                .forEach(a -> {
                                System.out.print("[");
                                a.stream()
                                .forEach(b -> {
                                    System.out.print(b);
                                });
                                System.out.print("]");
                                System.out.println();
                        }
                );
    }
}

