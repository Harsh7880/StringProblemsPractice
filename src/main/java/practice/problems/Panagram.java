package practice.problems;

public class Panagram {

    /**
     * Main method to check if a given string is a panagram.
     * A pangram is a sentence that contains every letter of the alphabet at least once.
     * Example of a pangram: "thequickbrownfoxjumpsoverthelazydog"
     */
    public static void main(String[] args) {
        // Input string to be checked
        String str = "thequickbrownfoxjumpsoverthelazydog";

        // Call method to check if the string is a panagram
        boolean isPanagram = isPanagram(str);

        // Output result based on whether the string is a panagram
        if (isPanagram) {
            System.out.println(str + " : is a Panagram String");
        } else {
            System.out.println(str + " : is not a Panagram String");
        }
    }

    /**
     * Checks if a given string contains every letter of the alphabet at least once.
     * This function assumes all characters are lowercase and ignores case sensitivity.
     *
     * Algorithm:
     * 1. Initialize an integer array `frequency` of size 26 to store the count of each letter (for 'a' to 'z').
     * 2. Iterate through each character `ch` in the string:
     *    - Calculate the index of `ch` in the alphabet as `index = ch - 'a'`.
     *    - Increment the count of `frequency[index]`.
     * 3. Check the `frequency` array:
     *    - For each value in `frequency`, if any count is 0 (meaning a letter is missing), return `false`.
     * 4. Return `true` if every letter has at least one occurrence (no zeros in `frequency`).
     *
     * @param str The input string to check
     * @return true if the string is a pangram, false otherwise
     *
     * Time Complexity: O(n), where n is the length of the input string `str`,
     * as we iterate through each character once.
     *
     * Space Complexity: O(1), as we use a fixed-size array (frequency array of size 26).
     */
    private static boolean isPanagram(String str) {
        // Array to track occurrences of each letter ('a' to 'z')
        int[] frequency = new int[26];
        int count = 0;
        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';// Map character to corresponding index (0 to 25)
            if(frequency[index] == 0){
                frequency[index]++;    // Increment frequency count for that character
                count++;
            }
        }


        // Check that each letter has been encountered at least once
//        for (int count : frequency) {
//            if (count == 0) {
//                return false;  // Return false if any letter's count is zero
//            }
//        }

        // If every letter has at least one occurrence, the string is a pangram

        return count == 26 ? true : false;
    }
}
