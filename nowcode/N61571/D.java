package com.example.demo.nowcode.N61571;


import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Set<Long> set =get(a);
        Set<Long> setB = get(b);

        TreeSet<Long> ans = new TreeSet<>();
        for(long f: set){
            for(long t: setB){
                ans.add(f*t);
            }
        }


        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for(long s: ans){
            sb.append(s).append(" ");
        }
        System.out.println(sb);

    }
    private static Set get(long a){
        Set<Long> ans = new HashSet<>();
        for (long i = 1; i*i <=a ; i++) {
            if(a%i==0){
                ans.add(a/i);
                ans.add(i);
            }
        }
        return ans;
    }
}
