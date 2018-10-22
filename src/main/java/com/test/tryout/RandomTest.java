package com.test.tryout;

import java.math.BigDecimal;

public class RandomTest {
    public static void main(String[] args){/*
        double a = 1.10;

        System.out.println(2.00 - 1.10);
        System.out.println(Double.toString(1.1));
        //System.out.println(Double.toString(2.00));
        System.out.println(new BigDecimal(2.02));
        System.out.println(new BigDecimal(1.11));

        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        System.out.println(MICROS_PER_DAY);
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        System.out.println(12345 + 54321);
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
        System.out.println((char)(byte) -1);

        short x = 0;
        int i = 123456;
        System.out.println( x += i);*/

        String a = null;
        try{
            System.out.println("Running try");
        }catch (Exception e){

        }finally {
            if(a.equals("test")){
                System.out.println("Executing finally");
            }
        }


    }

}
