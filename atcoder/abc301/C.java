package com.example.demo.atcoder.abc301;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(cs[i]=='@'){
                sum++;
                continue;
            }
            cnt[cs[i]-'a']++;

        }
        cs = sc.next().toCharArray();
        for(char c: cs){
            if(c=='@'){
                sum++;
                continue;
            }
            cnt[c-'a']--;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('t');
        set.add('c');
        set.add('o');
        set.add('d');
        set.add('e');
        set.add('r');
        for (int i = 0; i < 26; i++) {
            if(cnt[i]!=0){
                if(!set.contains((char)(i+'a'))){
                    System.out.println("No");
                    return;
                }
                sum -= Math.abs(cnt[i]);
            }
        }
        if(sum>=0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


    }
}
