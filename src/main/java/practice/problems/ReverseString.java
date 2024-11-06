package practice.problems;

/**
 * A class that provides various methods to reverse a string in Java.
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "Harsh";

        // Using Two Pointer Approach
        System.out.println("Two Pointer Reversal: " + usingTwoPointer(str));

        // Using Simple for-loop
        System.out.println("For-loop Reversal: " + reverseString(str));

        // Using StringBuilder built-in reverse method
        System.out.println("StringBuilder Reversal: " + reverseWithStringBuilder(str));
    }

    /**
     * Reverses a string using a simple for-loop.
     *
     * @param str the input string
     * @return the reversed string
     *
     * Complexity: O(n) time and O(n) space
     */
    private static String reverseString(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString = reversedString + str.charAt(i); // Appending each character in reverse order
        }
        return reversedString;
    }

    /**
     * Reverses a string using Java's StringBuilder reverse method.
     *
     * @param str the input string
     * @return the reversed string
     *
     * Complexity: O(n) time and O(n) space (for StringBuilder storage)
     */
    private static String reverseWithStringBuilder(String str) {
        StringBuilder s = new StringBuilder(str);
        return s.reverse().toString(); // StringBuilder's built-in reverse method
    }

    /**
     * Reverses a string in-place using the two-pointer technique.
     *
     * @param str the input string
     * @return the reversed string
     *
     * Complexity: O(n) time and O(n) space (to store the character array)
     */
    private static String usingTwoPointer(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] ch = str.toCharArray(); // Converting string to character array

        while (i < j) {
            // Swapping characters at i and j
            char temp = ch[j];
            ch[j] = ch[i];
            ch[i] = temp;

            // Moving pointers towards each other
            i++;
            j--;
        }
        return new String(ch); // Converting char array back to a string
    }
}
