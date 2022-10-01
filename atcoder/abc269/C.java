package com.example.demo.atcoder.abc269;

import java.io.PrintWriter;
import java.util.*;

public class C {
    static Set<Long> list = new TreeSet<>();

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc=new Scanner(System.in);
       long x = sc.nextLong();
       String str = Long.toBinaryString(x);
       dfs(0, str);
        StringBuilder sb = new StringBuilder();
        list.add(0l);
        list.add(x);
        for (long s: list) {
            sb.append(s).append(" ");
        }

        out.println(sb);
        out.close();
//        System.out.println(Long.parseLong("100000000000000000001000000000000000000010000000000000000000".parint));
//        System.out.println(str);
    }
    private static void dfs(int loc, String str){
        for (int i = loc; i <str.length() ; i++) {
            if(str.charAt(i)=='1'){
//                list.add(Long.parseLong(str, 2));
//                dfs(i+1, str);

                String ne = str.substring(0,i) + "0"+ str.substring(i+1);
                list.add(Long.parseLong(ne, 2));
                dfs(i+1, ne);
            }
        }
    }
}
