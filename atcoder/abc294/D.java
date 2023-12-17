package com.example.demo.atcoder.abc294;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt(), q = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        TreeSet<Integer> set = new TreeSet<>();
        int start = 1;
        while (q-->0){
            int s = sc.nextInt();
            if(s== 1){
                set.add(start);
                start++;
            }else if(s==2){
                int x = sc.nextInt();
                set.remove(x);
            }else {
                out.println(set.first());
            }
        }
        out.close();

    }
}
