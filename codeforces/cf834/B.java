package com.example.demo.codeforces.cf834;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int s = sc.nextInt();
            int[] arr = new int[m];
            int tot = 0;
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
                tot+= arr[i];
            }
            Arrays.sort(arr);
            int sum = arr[m-1] * (arr[m-1]+1)/2;
            int lef = sum -tot;
            if(lef == s){
                System.out.println("Yes");
                continue;
            }
            int next = arr[m-1];
            boolean flag = false;
            while (lef<s){
                next ++;
                lef += next;
                if(lef == s){
                    flag = true;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }

    }
}
