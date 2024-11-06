package practice.problems;

public class StringCompress {
    public static void main(String[] args) {

        String str = "aaaaabbbccccc";
        String compressedString = compressedLength(str);
        System.out.println("Compressed String : " + compressedString);
        System.out.println("Length of Compressed String : " + compressedString.length());

        char[] input = str.toCharArray();
        int len = compressStringInPlace(input);
        System.out.println(len);
    }


    // compressed String with using extra space as we are using string builder
    private static String compressedLength(String str){

        StringBuilder compressedString = new StringBuilder();
        int count = 1;
        for (int i=0;i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }else{
                compressedString.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        compressedString.append(str.charAt(str.length()-1)).append(count);
        return compressedString.toString();
    }

    // Compress the String without using String Builder or extraace means modify original String
    private static int compressStringInPlace(char[] st){
        int index = 0;
        int i = 0;
        while (i < st.length) {
            int count = 0;
            char currentChar = st[i];
            while (i < st.length && st[i] == currentChar) {
                count++;
                i++;
            }
            if (count > 1) {
                String countString = Integer.toString(count);
                for(char ch : countString.toCharArray()){
                    st[index] = currentChar;
                    index++;
                    st[index] = ch;
                    index++;
                }
            }
        }
       return index;
    }
}
