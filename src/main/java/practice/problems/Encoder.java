package practice.problems;

public class Encoder {

    public static void main(String[] args) {
        String input = "ab19zbk";
        String encodedString = encodeString(input);
        System.out.println("Encoded string: " + encodedString);
    }

    public static String encodeString(String input) {
        StringBuilder result = new StringBuilder();

        for(char ch: input.toCharArray()){
            if(Character.isLetter(ch)){
                char shiftedChar = (char) (ch + 3);
                // Handle wrapping from 'z' to 'a' or 'Z' to 'A'
                if (Character.isLowerCase(ch) && shiftedChar > 'z') {
                    shiftedChar = (char) (shiftedChar - 26);
                } else if (Character.isUpperCase(ch) && shiftedChar > 'Z') {
                    shiftedChar = (char) (shiftedChar - 26);
                }

                result.append(shiftedChar);
            }else if(Character.isDigit(ch)){
                int newShiftedDigit = ((ch - '0') + 3) % 10;
                result.append(newShiftedDigit);
            }else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
