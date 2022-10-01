package com.example.demo.codeforces;

import java.util.Scanner;

/**
 * int[] light 记录 lights 位置i和位置i+1异或后1的个数
 * int[] target 记录targets 位置i和位置i+1异或后1的个数
 * 1的位置差的和就是最后结果
 * */
public class CF807D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String lights = sc.next();
            String targets = sc.next();
            if(lights.charAt(0) !=targets.charAt(0)  || lights.charAt(n-1) != targets.charAt(n-1)){
                System.out.println("-1");
                continue;
            }
            int[] light = new int[n-1];
            int[] target = new int[n-1];
            int a = 0, b = 0;
            for(int i=0;i<n-1;i++){
                if(lights.charAt(i)!=lights.charAt(i+1)){
                    light[a++] = i;
                }
                if(targets.charAt(i)!=targets.charAt(i+1)){
                    target[b++] = i;
                }
            }
            if(a!=b){
                System.out.println("-1");
                continue;
            }
            long ans = 0;
            for(int i=0; i<n-1; i++){
                ans += Math.abs(light[i]-target[i]);
            }
            System.out.println(ans);
        }
    }
}
