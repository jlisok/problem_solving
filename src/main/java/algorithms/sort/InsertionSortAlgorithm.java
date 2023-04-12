package algorithms.sort;

public class InsertionSortAlgorithm {

    void sort(int[] input) {
        if (input == null) return;
        if (input.length < 2) return;

        swapAndInsert(input, 0);
    }

    void swapAndInsert(int[] array, int unsortedStart) {
        if (unsortedStart >= array.length) return;

        var minimumIndex = unsortedStart;
        var minimum = array[unsortedStart];
        for (int i = unsortedStart; i < array.length; i++) {

            var current = array[i];
            if (current < minimum) {
                minimumIndex = i;
                minimum = array[i];
            }
        }

        array[minimumIndex] = array[unsortedStart];
        array[unsortedStart] = minimum;

        swapAndInsert(array, unsortedStart + 1);
    }

}
