package com.nwjon.jon;

public class StringManip {

    public static void main(String[] args) {

        final String s = "backwards";

        System.out.println(reverse(s));
        System.out.println(reverse1(s));
        System.out.println(reverse2(s));
        System.out.println(reverse3(s));

        String b = new StringBuilder(s).reverse().toString();
        System.out.println(b);

        char bb = 70;
        System.out.println(bb);
    }

    private static String reverse(String s) {

        //30 millis, loop over entire string
        final StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String reverse1(String s) {

        //60% faster, 11 millis
        final char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        //loop over half the string
        while (start < end) {

            //swap the values
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    private static String reverse2(String s) {

        char[] arr = s.toCharArray();

        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            //swap the values
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
        }
        return String.valueOf(arr);
    }

    private static String reverse3(String s) {

        // getBytes() method to convert string into bytes[]
        byte[] bytes = s.getBytes();

        byte[] result = new byte[bytes.length];

        // Store result in reverse order into the result byte[]
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[bytes.length - i - 1];
        }

        return new String(result);
    }

}
