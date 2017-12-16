package com.nwjon.udemy;

public class Bits {

    public static void main(String... args) {

        System.out.println(getNthBit(16, 3));

        System.out.println(setNthBitTo1(120, 2));

        System.out.println(Integer.BYTES);
        System.out.println(Integer.MAX_VALUE);

    }

    public static int getNthBit(int num, int n) {

        //shift 1 bit left to the position to check
        int checkBit = 1 << n;

        //andBit will be all 0s expect for checkBit if bit is 1
        int andBit = num & checkBit;

        if (andBit == checkBit) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int setNthBitTo1(int num, int n) {

        //shift 1 bit left to the position to set to 1
        int setBit = 1 << n;

        //if position is 1 for either bit then changed to 1, other
        //positions will remain as they are because they are 0s
        return num | setBit;
    }

}
