package algorithms.sort;

import java.util.List;
import java.util.Map;

public class SelectionSort {

    public void sort(List<Integer> list) {
        if (list == null) return;

        var size = list.size();
        if (size < 2) return;

        for (int i = 0; i < list.size(); i++) {
            var unsorted = list.subList(i, size);
            var minIndex = getMinIndex(unsorted);
            rearrange(minIndex, unsorted);
        }
    }

    private int getMinIndex(List<Integer> list) {
        var minByIndex = Map.entry(0, list.getFirst());

        for (int i = 0; i < list.size(); i++) {
            var current = list.get(i);
            if (current < minByIndex.getValue()) minByIndex = Map.entry(i, current);
        }

        return minByIndex.getKey();
    }

    private void rearrange(int index, List<Integer> list) {
        if (index == 0) return;

        var minValue = list.get(index);
        list.set(index, list.getFirst());
        list.set(0, minValue);
    }
}
