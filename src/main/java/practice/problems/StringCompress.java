package practice.problems;

public class StringCompress {

    public static void main(String[] args) {
        // Input string for compression
        String str = "aaaaaaaaaaaabbbccccc";

        // Compress the string using extra space (StringBuilder) and print the result
        String compressedString = compressedLength(str);
        System.out.println("Compressed String : " + compressedString);
        System.out.println("Length of Compressed String : " + compressedString.length());

        // Compress the string in place (without extra space) using a character array
        char[] input = str.toCharArray();
        int len = compressStringInPlace(input);
        System.out.println("Length of In-Place Compressed String : " + len);

        // Display the compressed in-place result as a substring of the original array
        System.out.println("In-Place Compressed String : " + new String(input, 0, len));
    }

    /**
     * Compresses a string using StringBuilder for extra space.
     * Each character and its consecutive frequency are added to the result.
     * Example: "aaabb" -> "a3b2"
     *
     * @param str the input string to compress
     * @return the compressed string
     *
     * Time Complexity: O(n), where n is the length of the string `str`, as we iterate through the string once.
     * Space Complexity: O(n), because we use a StringBuilder to store the compressed version of the string.
     */
    private static String compressedLength(String str) {
        // StringBuilder used to build the compressed result
        StringBuilder compressedString = new StringBuilder();
        int count = 1; // Track consecutive character count

        // Loop through the string, comparing each character to the next
        for (int i = 0; i < str.length() - 1; i++) {
            // If the current and next character are the same, increment the count
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                // Append current character and count, reset count
                compressedString.append(str.charAt(i)).append(count);
                count = 1;
            }
        }

        // Append last character and count after loop ends
        compressedString.append(str.charAt(str.length() - 1)).append(count);
        return compressedString.toString();
    }

    /**
     * Compresses a character array in place, modifying the original array.
     * No additional data structures (e.g., StringBuilder) are used.
     * Example: "aaabb" -> "a3b2" (stored in place within the input array)
     *
     * @param st the character array representation of the input string
     * @return the new length of the compressed character array
     *
     * Time Complexity: O(n), where n is the length of the character array `st`, as we iterate through the array once.
     * Space Complexity: O(1), because we are modifying the input array in place without using additional space.
     */
    private static int compressStringInPlace(char[] st) {
        int index = 0; // Track position in `st` to write compressed characters
        int i = 0;     // Track the current read position in `st`

        // Process each unique character in the array
        while (i < st.length) {
            int count = 0;
            char currentChar = st[i];

            // Count consecutive occurrences of `currentChar`
            while (i < st.length && st[i] == currentChar) {
                count++;
                i++;
            }

            // Place the character at the compressed array's current index
            st[index++] = currentChar;

            // If count > 1, convert count to characters and append each to `st`
            if (count > 1) {
                for (char ch : Integer.toString(count).toCharArray()) {
                    st[index++] = ch;
                }
            }
        }

        // Return the length of the compressed portion of the array
        return index;
    }
}
