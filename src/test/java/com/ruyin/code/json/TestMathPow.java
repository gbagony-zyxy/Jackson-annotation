package com.ruyin.code.json;

/**
 * Created by gbagony on 2017/1/21.
 */
public class TestMathPow {
    public static void main(String[] args) {
        double result = 0;
        for(int i=0;i<30;i++){
            result += Math.pow(0.985,i);
        }
        System.out.println(result);
        //System.out.println(Math.pow(2,3));
    }
}
