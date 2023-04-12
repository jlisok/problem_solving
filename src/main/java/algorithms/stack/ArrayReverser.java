package algorithms.stack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://www.techiedelight.com/reverse-an-array-cpp/">link</a>
 * <p>
 * <b>Reverse an array</b>
 */
public class ArrayReverser {

    List<Integer> reverse(List<Integer> elements) {
        if (elements == null || elements.isEmpty()) return Collections.emptyList();

        var result = new LinkedList<Integer>();

        for (Integer element : elements) {
            result.push(element);
        }

        return result;
    }
}
