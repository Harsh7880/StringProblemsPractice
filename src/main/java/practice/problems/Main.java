package practice.problems;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String str = "aaaaabbbccccc";
        int n = str.length();
        int index = 0;
        int i = 0;
        while(i < n){
            char ch = str.charAt(i);
            int count = 0;
            while (i <n && str.charAt(i) == ch){
                count++;
                i++;
            }
            if(count > 1){
                String charCount = Integer.toString(count);
                for(char c : charCount.toCharArray()){
                   str.toCharArray()[index] = ch;
                   index++;
                   str.toCharArray()[index] = c;
                }
            }
        }
        System.out.println(str);
    }
}