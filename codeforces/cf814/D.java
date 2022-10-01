package com.example.demo.codeforces.cf814;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 找到 L -- R  区间里满足  al⊕al+1⊕…⊕ar=0 ， ans+= r-l
 * 再加上剩余的元素个数？
 * */
public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int xor=0, c=0;
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for(int a : arr){
                c++;
                xor ^= a;
                if(set.contains(xor)){
                    ans += c-1;
                    c=0;
                    xor=0;
                    set.clear();
                }
                set.add(xor);
            }
            ans += c;
            System.out.println(ans);
        }
    }
}
