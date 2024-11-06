package practice.problems;

import java.util.Stack;

public class BalanceParanthesis {
    public static void main(String[] args) {
        String str = "{([{}])}}}}}"; // Input string containing parentheses
        boolean isValidString = isValid(str); // Call the isValid method to check if the string is balanced

        // Print the result based on the returned value
        if (isValidString) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is not valid");
        }
    }

    // Method to check if parentheses in the string are balanced
    private static boolean isValid(String str) {

        Stack<Character> st = new Stack<>(); // Stack to store opening brackets

        // Loop through each character in the string
        for (char ch : str.toCharArray()) {
            // If character is an opening bracket, push it to the stack
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            }
            // If character is a closing bracket, check for a matching opening bracket
            else if (ch == ']') {
                // If stack is empty or top is not matching opening bracket, return false
                if (st.isEmpty() || st.peek() != '[') {
                    return false;
                } else {
                    st.pop(); // Pop the matching opening bracket
                }
            }
            else if (ch == '}') {
                // If stack is empty or top is not matching opening bracket, return false
                if (st.isEmpty() || st.peek() != '{') {
                    return false;
                } else {
                    st.pop(); // Pop the matching opening bracket
                }
            }
            else if (ch == ')') {
                // If stack is empty or top is not matching opening bracket, return false
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                } else {
                    st.pop(); // Pop the matching opening bracket
                }
            }
        }

        // If stack is empty after processing all characters, parentheses are balanced
        return st.isEmpty();
    }
}
