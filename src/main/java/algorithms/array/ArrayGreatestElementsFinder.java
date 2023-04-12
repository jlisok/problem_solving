package algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/find-elements-array-greater-than-elements-right/">link</a>
 * <p>
 * <b>Find all elements in an array that are greater than all elements to their right</b>
 * <p>
 * Given an unsorted integer array, print all greater elements than all elements present to their right.
 * <p>
 * For example, consider the array [10, 4, 6, 3, 5]. The elements that are greater than all elements to their
 * right are 10, 6, and 5.
 */
public class ArrayGreatestElementsFinder {

    List<Integer> getLocalMaxes(List<Integer> elements) {
        if (elements == null || elements.isEmpty()) return Collections.emptyList();

        var result = new ArrayList<Integer>();
        var lastIndex = elements.size() - 1;
        var localMax = elements.get(lastIndex) - 1;

        for (int i = lastIndex; i > -1; i--) {
            var current = elements.get(i);

            if (current > localMax) {
                localMax = current;
                result.add(current);
            }
        }

        return result;
    }
}
