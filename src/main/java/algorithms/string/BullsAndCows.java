package algorithms.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * <strong>Link:</strong> <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * <strong>Problem:</strong> 299. Bulls and Cows<br>
 * <strong>Level:</strong> Medium<br>
 * <p>
 * You are playing the Bulls and Cows game with your friend.
 * </p>
 * <p>
 * You write down a secret number and ask your friend to guess what the number is.
 * When your friend makes a guess, you provide a hint with the following information:
 * </p>
 * <ul>
 *   <li>The number of "bulls" - digits in the guess that are in the correct position.</li>
 *   <li>The number of "cows" - digits in the guess that are in the secret number but are located in the wrong position.
 *       Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.</li>
 * </ul>
 * <p>
 * Given the secret number {@code secret} and your friend's guess {@code guess},
 * return the hint for your friend's guess.
 * </p>
 * <p>
 * The hint should be formatted as "<code>xAyB</code>", where <code>x</code> is the number of bulls
 * and <code>y</code> is the number of cows. Note that both {@code secret} and {@code guess}
 * may contain duplicate digits.
 * </p>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <pre>
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow
 * since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 * </pre>
 *
 * <p><strong>Constraints:</strong></p>
 * <ul>
 *   <li>1 <= secret.length, guess.length <= 1000</li>
 *   <li>secret.length == guess.length</li>
 *   <li>secret and guess consist of digits only.</li>
 * </ul>
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return "";
        if (secret.length() != guess.length()) return "";

        var secrets = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var guesses = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            var secretInteger = Character.getNumericValue(secret.charAt(i));
            var guessInteger = Character.getNumericValue(guess.charAt(i));

            if (secretInteger == guessInteger) {
                bulls++;
                continue;
            }

            secrets.set(secretInteger, secrets.get(secretInteger) + 1);
            guesses.set(guessInteger, guesses.get(guessInteger) + 1);
        }

        int cows = 0;
        for (int i = 0; i < secrets.size(); i++) {
            var secretCount = secrets.get(i);
            var guessCount = guesses.get(i);

            cows = cows + Math.min(secretCount, guessCount);
        }

        return bulls + "A" + cows + "B";
    }


    ///  First attempt, which is valid but slower
    public String getHintFirstAttempt(String secret, String guess) {
        if (secret == null || guess == null) return "";
        if (secret.length() != guess.length()) return "";

        var queue = secret.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayDeque::new));
        var map = new HashMap<Character, Integer>();

        var bulls = getBulls(secret, guess, queue, map);
        var cows = getCows(queue, map);

        return bulls + "A" + cows + "B";
    }

    private int getBulls(String secret, String guess, Queue<Character> queue, Map<Character, Integer> map) {
        var bulls = 0;

        for (int i = 0; i < secret.length(); i++) {
            var guessChar = guess.charAt(i);
            var secretChar = queue.poll();

            if (guessChar == secretChar) {
                bulls++;
                continue;
            }

            queue.offer(secretChar);
            var count = map.getOrDefault(guessChar, 0) + 1;
            map.put(guessChar, count);
        }
        return bulls;
    }

    private int getCows(Queue<Character> queue, Map<Character, Integer> map) {
        var cows = 0;
        while (!queue.isEmpty()) {
            var secretChar = queue.poll();
            if (!map.containsKey(secretChar)) continue;

            var count = map.get(secretChar) - 1;
            if (count == 0) map.remove(secretChar);
            else map.put(secretChar, count);
            cows++;
        }

        return cows;
    }
}
