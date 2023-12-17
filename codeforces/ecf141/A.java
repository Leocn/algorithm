package com.example.demo.codeforces.ecf141;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n  = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

            }
            Arrays.sort(arr,(a,b)->b-a);
            int diff = 0;
            for(int i=0;i<n-1; i++){
                diff += arr[i+1]- arr[i];
            }
            if(diff==0){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]).append(" ");
            StringBuilder last = new StringBuilder();
            int loc = 1;
            while (loc<n && arr[loc].equals(arr[0])){
                last.append(arr[loc]).append(" ");
                loc++;
            }
            for(int i=loc; i<n; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append(last);
            System.out.println(sb);

        }
    }
}
