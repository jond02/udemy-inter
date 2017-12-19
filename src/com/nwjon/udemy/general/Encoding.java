package com.nwjon.udemy.general;

public class Encoding {

    public static void main(String[] args) {

        Encoding encoding = new Encoding();

        final String s = "aaaabbbbbbcccdeeeef";

        final String en = encoding.encode(s);

        System.out.println(en);

        final String de = encoding.decode(en);

        System.out.println(s);
        System.out.println(de);

    }

    public String encode(String s) {

        //run length encoding

        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int currIndex = 0;

        while (currIndex < s.length()) {

            char currChar = s.charAt(currIndex);

            //num calculates how many times char appears
            int num = 0;
            int compareIndex = currIndex;

            while (compareIndex < s.length() && currChar == s.charAt(compareIndex)) {
                compareIndex++;
                num++;
            }

            sb.append(num).append(currChar);

            //advance the index to skip over chars
            currIndex = compareIndex;
        }
        return sb.toString();
    }

    public String decode(String s) {

        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        int startIndex = 0;
        int endIndex = 1;

        while (endIndex < s.length()) {

            while(Character.isDigit(s.charAt(endIndex))) {
                endIndex++;
            }

            int charIndex = endIndex;

            String numString = s.substring(startIndex, endIndex);
            int num = Integer.valueOf(numString);

            for (int i = 0; i < num; i++) {
                sb.append(s.charAt(charIndex));
            }
            startIndex = charIndex + 1;
            endIndex = startIndex + 1;
        }

        return sb.toString();
    }


}
