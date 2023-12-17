package com.example.demo.codeforces.cf849;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            int[] cs = new int[26];
            int[] es = new int[26];
            int ans = 1;

            for (int i = 0; i <n ; i++) {
                cs[str.charAt(i)-'a']++;
            }
            for (int i = n-1; i >=0 ; i--) {
                int m = 0;
                es[str.charAt(i)-'a']++;
                cs[str.charAt(i)-'a']--;
                for (int j = 0; j < 26; j++) {
                    if(cs[j]>0){
                        m++;
                    }
                    if(es[j]>0){
                        m++;
                    }
                }
                ans = Math.max(m, ans);
            }
            System.out.println(ans);

        }
    }

}
