package algorithms.sort;

public class QuickSortAlgorithm {

    void sort(int[] input) {
        if (input == null) return;
        if (input.length < 2) return;

        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;

        var pivot = rearrangeAndGetPivotIndex(array, startIndex, endIndex);

        quickSort(array, startIndex, pivot - 1);
        quickSort(array, pivot + 1, endIndex);
    }

    private int rearrangeAndGetPivotIndex(int[] array, int startIndex, int endIndex) {
        var pivot = array[endIndex];

        var pivotIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {

            var current = array[i];
            if (current < pivot) {

                array[i] = array[pivotIndex];
                array[pivotIndex] = current;

                pivotIndex++;
            }
        }

        array[endIndex] = array[pivotIndex];
        array[pivotIndex] = pivot;

        return pivotIndex;
    }

}
