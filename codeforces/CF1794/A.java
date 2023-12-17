package com.example.demo.codeforces.CF1794;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            String[] arr = new String[2*n-2];
            for (int i = 0; i < 2*n-2; i++) {
                arr[i] = sc.next();
            }
            Arrays.sort(arr, (a,b)->{
                if(a.length()==b.length()){
                    return a.compareTo(b);
                }else{
                    return a.length()-b.length();
                }
            });
            for (int i = 0; i < 2*n-2; i+=2) {
                if(!arr[i].equals(new StringBuilder(arr[i+1]).reverse().toString())){
                    System.out.println("NO");
                    continue out;
                }
            }


           System.out.println("YES");

        }
    }

}
