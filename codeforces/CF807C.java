package com.example.demo.codeforces;

import java.util.Scanner;
import java.util.TreeMap;

public class CF807C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int q = sc.nextInt();
            String str = sc.next();
            TreeMap<Long, long[]> treeSet = new TreeMap<>();
            long nowL = n;
            treeSet.put(nowL, new long[]{});
            while(c>0){
                long left = Long.parseLong(sc.next());
                long right = Long.parseLong(sc.next());
                nowL += right-left+1;
                treeSet.put(nowL, new long[]{left, right});
                c--;
            }
            while(q>0){
                long k = Long.parseLong(sc.next());
                long floor  = treeSet.ceilingKey(k);

                while (floor>n){
                    long[] value = treeSet.get(floor);
                    k = value[0]+ k-(floor- (value[1]- value[0]));
                    floor = treeSet.ceilingKey(k);
                }
                System.out.println(str.charAt((int)k-1));
                q--;
            }
        }
    }
}
