package com.example.demo.atcoder.abc260;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC260A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s =scanner.next();
        print(s);
    }

    public static void print(String s){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            map.put(chars[i], map.getOrDefault(chars[i],0)+1);
        }
        boolean flag = true;
        for(Map.Entry<Character, Integer> m: map.entrySet()){
            if(m.getValue()==1){
                flag =false;
                System.out.println(m.getKey());
                break;
            }
        }
        if(flag){
            System.out.println("-1");
        }
    }

}
