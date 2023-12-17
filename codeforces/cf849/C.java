package com.example.demo.codeforces.cf849;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            int left = 0, right = n-1;
            while (left<right){
                char c = str.charAt(left);
                char e = str.charAt(right);
                if(c==e){
                    break;
                }else{
                    left++;
                    right--;
                }
            }
            System.out.println(right-left+1);
        }
    }

}
