package practice.problems;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        String input = "ab19zbk";
        StringBuilder st = new StringBuilder();
        for(char ch: input.toCharArray()){
            if(Character.isLetter(ch)){
                char shiftedChar = (char) (ch + 3);
                // Handle wrapping from 'z' to 'a' or 'Z' to 'A'
                if (Character.isLowerCase(ch) && shiftedChar > 'z') {
                    shiftedChar = (char) (shiftedChar - 26);
                } else if (Character.isUpperCase(ch) && shiftedChar > 'Z') {
                    shiftedChar = (char) (shiftedChar - 26);
                }

                st.append(shiftedChar);
            }else if(Character.isDigit(ch)){
                int newShiftedDigit = ((ch - '0') + 3) % 10;
                st.append(newShiftedDigit);
            }else {
                st.append(ch);
            }
        }
        System.out.println(st);
    }
}