package com.example.demo.codeforces.CF1804;

import java.io.PrintWriter;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans1 = 0, ans2 = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                char[] cs = s.toCharArray();
                int  b = 0, cnt0 = 0;
                for (int j = 0; j < m; j++) {
                    if(cs[j]=='1' && j+1<m && cs[j+1]=='1'){
                        b ++;
                        j++;
                        continue;
                    }
                    if(cs[j]=='0'){
                        cnt0++;
                    }
                }
                ans1 += m-cnt0 - Math.min(b, m/4);

                int a = 0;
                for (int j = 0; j < m; j++) {
                    if((cs[j]=='1' && j+1<m  &&  cs[j+1]=='0') || (cs[j]=='0' && j+1<m  &&  cs[j+1]=='1') ||
                            (cs[j]=='0' && j+1<m  &&  cs[j+1]=='0')){
                        a++;
                        j++;
                    }
                }
                ans2 += m-cnt0 - Math.max(0,m/4-a);

            }

        out.println(ans1 + " " + ans2);
        out.close();


    }
}
