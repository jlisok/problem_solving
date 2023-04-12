package algorithms.string;

import java.util.HashMap;
import java.util.List;

/**
 * https://www.techiedelight.com/find-maximum-occurring-word-given-set-strings/
 * <p>
 * <b>Find the maximum occurring word in a given set of strings</b>
 * <p>
 * Given a huge set of words with duplicates present, find the maximum occurring word in it. If two words have the same count, return any one of them.
 * <p>
 * example:
 * <p>
 * input: keys = [code, coder, coding, codable, codec, codecs, coded, codeless, codec, codecs, codependence, codex, codify, codependents, codes, code, coder, codesign, codec, codeveloper, codrive, codec, codecs, codiscovered]
 * <p>
 * output: codec
 **/
public class WordModeProvider {

    public String find(List<String> wordSalad) {
        if (wordSalad == null) return null;
        if (wordSalad.isEmpty()) return null;
        if (wordSalad.size() == 1) return wordSalad.get(0);

        String candidate = null;
        int candidateCount = 0;

        var wordCountMap = new HashMap<String, Integer>(Math.multiplyExact(wordSalad.size(), 2)); // re-assure capacity is never reached

        // O(n)
        for (String current : wordSalad) {

            var currentCount = wordCountMap.getOrDefault(current, 0) + 1; // O(1) due to magic of hashMap
            if (currentCount > candidateCount) {

                candidate = current;
                candidateCount = currentCount;

            }

            wordCountMap.put(current, currentCount); // O(1) due to magic of hashMap
        }

        return candidate;
    }
}
