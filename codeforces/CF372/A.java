package com.example.demo.codeforces.CF372;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int s = n/2, ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(vis[i]) continue;
            if(s==n){
                break;
            }
            while (s<n && nums[s]<2*nums[i]){

                s++;
            }
            while (s<n && vis[s]){
                s++;
            }
            if(s==n){
                break;
            }

            vis[i] = true;
            vis[s] = true;
            ans+=1;
        }
        out.println( n-ans);
        out.close();
    }

}
