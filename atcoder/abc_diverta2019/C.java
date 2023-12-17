package com.example.demo.atcoder.abc_diverta2019;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0,b=0,c=0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char[] cs = sc.next().toCharArray();

            for (int j = 0; j < cs.length-1; j++) {
                if(cs[j]=='A'&& cs[j+1] =='B'){
                    ans++;
                }
            }
            if(cs[0]=='B' && cs[cs.length-1]=='A'){
                c++;
            }else if(cs[0]=='B'){
                a++;
            }else if(cs[cs.length-1]=='A'){
                b++;
            }
        }
        ans += Math.min(a,b)+c;
        if(a==0 && b==0&& c>0){
            ans--;
        }
        System.out.println(ans);

    }
}
