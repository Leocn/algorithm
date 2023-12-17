package com.example.demo.aoc2023;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D2 {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void solve() {
        long ans = 0;

        while (sc.hasNextLine()){

            String s = sc.nextLine();
            if(s.equals("ex")){
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)==':'){
                    s = s.substring(i+2);
                    break;
                }
            }
            Map<String, Integer> map = new HashMap<>();
            map.put("red", 0);
            map.put("green", 0);
            map.put("blue", 0);
            String[] arr = s.split(";");
            for(String a: arr){
                String[] words = a.split(",");
                for(String w: words){
                    if(w.startsWith(" ")){
                        w = w.substring(1);
                    }
                    String[] colour = w.split(" ");
                    int cnt = Integer.parseInt(colour[0]);
                    map.put(colour[1], Math.max(cnt,map.get(colour[1])));
                }

            }
            ans +=  (long)map.get("red")*map.get("blue")*map.get("green");

        }
        out.println(ans);
    }

}
