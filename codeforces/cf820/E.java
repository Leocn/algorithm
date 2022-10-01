package com.example.demo.codeforces.cf820;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        long lef = 1, right = (long) 1e18;
//        long ans = 0;
//        while(lef<=right){
//            long mid = lef+right>>1;
//            String que = "? "+1 + " "+ mid;
//            System.out.println(que);
//            System.out.flush();
//            long  n = sc.nextLong();
//            if(n==-1){
//                right = mid-1;
//                continue;
//            }
//            if(n>mid-1){
//                ans = n+mid-1;
//                break;
//            }
//            if(lef==right){
//                ans = lef;
//                break;
//            }
//            lef = mid;
//        }
//        System.out.println(ans);
        long min = -1;
        long count = 0;
        boolean tf = true;
        for (int i = 2; i < 50; i++) {
            if (tf) {
                for (int j = 1; j < i; j++) {
                    System.out.println("? " + j + " " + i);
                    System.out.flush();
                    long num1 = sc.nextLong();
                    System.out.println("? " + i + " " + j);
                    System.out.flush();
                    long num2 = sc.nextLong();
                    if (num2 == -1) {
                        min = Math.max(i, j) - 1;
                        tf = false;
                        break;
                    }
                    if (num1 != num2) {
                        min = num1 + num2;
                        tf = false;
                        break;
                    }
                    count++;
                    if (count == 50) {
                        min = num2;
                        tf = false;
                        break;
                    }
                }
            }
            else break;
        }
        System.out.println("! " + (min));

    }

}
