package algorithms.string;

import java.util.HashMap;

/**
 * https://www.techiedelight.com/determine-if-two-strings-are-anagram-or-not/
 * <p>
 * <b>Determine whether two strings are anagram or not</b>
 * <p>
 * Given two strings, determine whether they are anagrams.
 * <p>
 * Any word that exactly reproduces the letters in another order is an anagram. In other words, X and Y are anagrams
 * if by rearranging the letters of X, we can get Y using all the original letters of X exactly once.
 *
 * <p>
 * example:
 * <p>
 * silent = listen
 * <p>
 * incest = insect
 **/
public class AnagramAlgorithm {


    public boolean isAnagram(String left, String right) {
        if (left == null || right == null) return false;
        if (left.length() != right.length()) return false;

        var size = left.length();
        var letterFrequencies = new HashMap<Character, Integer>(size * 2);

        for (int i = 0; i < size; i++) {
            var leftChar = left.charAt(i);
            var leftFrequency = letterFrequencies.getOrDefault(leftChar, 0);
            letterFrequencies.put(leftChar, leftFrequency + 1);

            var rightChar = right.charAt(i);
            var rightFrequency = letterFrequencies.getOrDefault(rightChar, 0);
            letterFrequencies.put(rightChar, rightFrequency - 1);
        }

        return letterFrequencies.values()
                .stream()
                .noneMatch(frequency -> frequency != 0);
    }
}
