package com.example.demo.atcoder.arc155;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        TreeSet<Integer> tree1 = new TreeSet<>();
        TreeSet<Integer> tree2 = new TreeSet<>();
        tree1.add(A+B);
        tree2.add(B-A);
        while (q-->0){
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = Integer.MAX_VALUE;
            if(t==1){
                tree1.add(-a-b);
                tree2.add(-a+b);
            }else{
                Integer h1 = tree1.higher(a);
                if(a+h1<=b){
                    ans  =0;
                }
                ans = Math.min(h1+ a, ans);


            }

        }
    }

}
