package algorithms.string;

/**
 * https://www.techiedelight.com/run-length-encoding-rle-data-compression-algorithm/
 * <p>
 * <b>Run Length Encoding (RLE) Data Compression Algorithm</b>
 * <p>
 * Run–length encoding (RLE) is a simple form of lossless data compression that runs on sequences with the same value occurring many consecutive times. It encodes the sequence to store only a single value and its count.
 * <p>
 * example:
 * <p>
 * input: WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW
 * <p>
 * output: 12W1B12W3B24W1B14W
 **/
public class DataCompressionAlgorithm {

    public String compress(String text) {
        if (text == null) return null;
        if (text.isEmpty()) return null;

        var compressedTextBuilder = new StringBuilder();
        char compressed = text.charAt(0);
        int count = 1;

        // O(n)
        for (int i = 1; i < text.length(); i++) {

            var current = text.charAt(i);

            if (compressed == current) {
                count++;
            } else {
                compressedTextBuilder.append(count).append(compressed);
                compressed = current;
                count = 1;
            }
        }

        return compressedTextBuilder.append(count).append(compressed).toString();
    }
}
