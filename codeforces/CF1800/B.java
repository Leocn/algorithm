package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            char[] cs = str.toCharArray();
            int ans = 0;
            int[] cnt = new int['z'+1];
            for(char c: cs){
                if(Character.isUpperCase(c)){
                    if(cnt[c+32]>0){
                        ans++;
                        cnt[c+32]--;
                    }else {
                        cnt[c]++;
                    }
                }else {
                    if(cnt[c-32]>0){
                        ans++;
                        cnt[c-32]--;
                    }else {
                        cnt[c]++;
                    }
                }
            }
            for (int i = 0; i < 'z'+1; i++) {
                if(cnt[i]>0){
                    ans += Math.min(cnt[i]/2,k);
                    k-= cnt[i]/2;
                }
                if(k<=0){
                    break;
                }

            }
            out.println(ans);


        }
        out.close();
    }
}
