package com.leetcode.problemset.medium.accepted;

public class ProblemNr12 {

    //https://leetcode.com/problems/integer-to-roman
    public static int build(StringBuilder sb, int current, int divider, String small, String mid, String large){
        int div = divider == 0? current : current / divider;
        if (div > 0) {
            switch (div) {
                case 1:
                case 2:
                case 3:
                    for (int i = 0; i < div; i++) {
                        sb.append(small);
                    }
                    break;
                case 4:
                    sb.append(small);
                    sb.append(mid);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    sb.append(mid);
                    for (int i = 0; i < div-5; i++) {
                        sb.append(small);
                    }
                    break;
                case 9:
                    sb.append(small);
                    sb.append(large);
                    break;
                default:
            }
            return current - (divider*div);
        }
        return current;
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int current = num;
        int div = current / 1000;
        if(div>0){
            for(int i=0; i<div; i++){
                sb.append("M");
            }
            current -= 1000*div;
        }

        current = build(sb, current, 100, "C", "D",  "M");
        current = build(sb, current, 10, "X", "L",  "C");
        build(sb, current, 0, "I", "V", "X");
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(intToRoman(58));
    }
}
