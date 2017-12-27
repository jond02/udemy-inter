package com.nwjon.udemy.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String... args) {

        System.out.println(15 % 10);


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        int[] digits1 = {1,2,7};

        int[] digits2 = {4,4};

        int[] arr = addTwoNumbers.addNumbers(digits1, digits2);


        System.out.println(Arrays.toString(arr));


    }

    private int[] addNumbers(int[] num1, int[] num2) {

        List<Integer> digitList = new ArrayList<>();
        int lastIndex1 = num1.length - 1;
        int lastIndex2 = num2.length - 1;

        int carry = 0;
        int total;
        int digit;

        while (lastIndex1 >= 0 && lastIndex2 >= 0) {

            total = num1[lastIndex1] + num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
            lastIndex2--;
        }

        while (lastIndex1 >= 0) {

            total = num1[lastIndex1] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
        }

        while (lastIndex2 >= 0) {

            total = num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex2--;
        }

        if (carry != 0) {
            digitList.add(0, carry);
        }

        return digitList.stream().mapToInt(x -> x).toArray();
    }





}
