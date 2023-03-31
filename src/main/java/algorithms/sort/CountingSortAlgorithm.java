package algorithms.sort;

import java.util.Arrays;

public class CountingSortAlgorithm {

    void sort(int[] input, int valueRange) {
        if (input == null) return;
        if (valueRange == 0) return;
        if (input.length < 2) return;

        var histogram = new int[valueRange + 1];
        for (int value : input) histogram[value]++;

        calculateCumulativeSum(histogram);

        var output = arrange(input, histogram);
        Arrays.setAll(input, i -> output[i]);
    }

    private void calculateCumulativeSum(int[] histogram) {
        var cumulative = 0;
        for (int i = 0; i < histogram.length; i++) {

            var current = histogram[i];
            histogram[i] = cumulative;
            cumulative += current;

        }
    }

    private int[] arrange(int[] array, int[] histogram) {
        var output = new int[array.length];
        for (int value : array) {

            var index = histogram[value];
            output[index] = value;
            histogram[value]++;

        }

        return output;
    }
}
