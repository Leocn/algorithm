package com.example.demo.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF805B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            String str = scanner.next();
            Set<Character> set = new HashSet<>();
            int ans = 0;
            for(char c: str.toCharArray()){
                if(set.size()<3){
                    set.add(c);
                }
                if(set.size()==3 && !set.contains(c)){
                    ans ++;
                    set = new HashSet<>();
                    set.add(c);
                }
            }
            if(set.size()!=0) ans ++;
            System.out.println(ans);

        }
    }
}
