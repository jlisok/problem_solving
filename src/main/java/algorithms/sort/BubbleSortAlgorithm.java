package algorithms.sort;

public class BubbleSortAlgorithm {

    void sort(int[] input) {
        if (input == null) return;
        if (input.length < 2) return;

        var unsorted = true;
        while (unsorted) {

            unsorted = false;

            for (int i = 0; i < input.length - 1; i++) {

                var current = input[i];
                var next = input[i + 1];

                if (next < current) {
                    input[i] = next;
                    input[i + 1] = current;
                    unsorted = true;
                }
            }
        }
    }
}
