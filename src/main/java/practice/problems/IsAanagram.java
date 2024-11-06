package practice.problems;

import java.util.Arrays;

public class IsAanagram {

    /**
     * Main method to check if two given strings are anagrams.
     * Two strings are anagrams if they contain the same characters in the same frequency.
     * Example: "listen" and "silent" are anagrams.
     */
    public static void main(String[] args) {
        // Input strings to check for anagram
        String str1 = "listen";
        String str2 = "silent";

        // Call method to check if the strings are anagrams
        boolean isAanagram = isAanagramWithoutSorting(str1, str2);

        // Output result based on whether the strings are anagrams
        if (isAanagram) {
            System.out.println("Strings are Anagram");
        } else {
            System.out.println("Strings are not Anagram");
        }
    }

    /**
     * Checks if two strings are anagrams of each other.
     * An anagram is when two strings contain the same characters with the same frequency.
     *
     * Algorithm:
     * 1. If the lengths of the two strings are not equal, return false.
     * 2. Convert both strings to character arrays using `toCharArray()`.
     * 3. Sort both character arrays.
     * 4. Compare the sorted arrays using `Arrays.equals()`. If they are equal, the strings are anagrams.
     *
     * @param str1 First string to check
     * @param str2 Second string to check
     * @return true if the strings are anagrams, false otherwise
     *
     * Time Complexity: O(n log n), where `n` is the length of the input strings. The time complexity
     * is dominated by the sorting step which is O(n log n).
     *
     * Space Complexity: O(n), where `n` is the length of the input strings. Space is used to store
     * the character arrays.
     */
    private static boolean isAanagram(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) return false;

        // Convert both strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays for equality
        return Arrays.equals(arr1, arr2);
    }
    private static boolean isAanagramWithoutSorting(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) return false;
        int [] freq = new int[26];
        for(char ch: str1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch: str2.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a'] < 0) return false;
        }
        return true;
    }
}
