package algorithms.sort;

import java.util.Arrays;

public class MergeSortAlgorithm {

    void sort(int[] input) {
        if (input == null) return;
        if (input.length <= 1) return;

        var lastIndex = input.length - 1;
        divideAndMerge(input, 0, lastIndex);
    }

    private void divideAndMerge(int[] input, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;

        var midpoint = getMidPoint(startIndex, endIndex);
        divideAndMerge(input, startIndex, midpoint);
        divideAndMerge(input, midpoint + 1, endIndex);

        merge(input, startIndex, midpoint + 1, endIndex);
    }


    private void merge(int[] input, int startIndex, int midpoint, int endIndex) {
        if (endIndex == startIndex) return;

        var left = Arrays.copyOfRange(input, startIndex, midpoint);
        var leftSize = left.length;

        var right = Arrays.copyOfRange(input, midpoint, endIndex + 1);
        var rightSize = right.length;

        var leftIndex = 0;
        var rightIndex = 0;
        var index = startIndex;

        while (leftIndex < leftSize && rightIndex < rightSize) {

            var currentLeft = left[leftIndex];
            var currentRight = right[rightIndex];

            if (currentLeft < currentRight) {

                input[index] = currentLeft;
                leftIndex++;

            } else {

                input[index] = currentRight;
                rightIndex++;

            }

            index++;
        }

        addRemaining(input, left, index, leftIndex, leftSize);
        addRemaining(input, right, index, rightIndex, rightSize);
    }

    private int getMidPoint(int start, int stop) {
        return start + (stop - start) / 2;
    }

    private void addRemaining(int[] input, int[] subarray, int index, int subarrayIndex, int subarraySize) {
        while (subarrayIndex < subarraySize) {

            input[index] = subarray[subarrayIndex];
            subarrayIndex++;
            index++;

        }
    }
}
