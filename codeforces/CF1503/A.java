package com.example.demo.codeforces.CF1503;


import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += cs[i]-'0';
            }
            if(cnt%2==1 || cs[0]=='0' || cs[n-1] == '0'){
                System.out.println("NO");
                continue;
            }
            int k = cnt/2;
            boolean v = true;
            for (int i = 0; i < n; i++) {
                if(cs[i]=='1'){
                    if(k>0){
                        sb1.append("(");
                        sb2.append("(");
                    }else {
                        sb1.append(")");
                        sb2.append(")");
                    }
                    k--;
                }else {
                    if(v){
                        sb1.append("(");
                        sb2.append(")");
                    }else {
                        sb1.append(")");
                        sb2.append("(");
                    }
                    v =!v;
                }
            }
            System.out.println("YES");
            System.out.println(sb1);
            System.out.println(sb2);


        }
    }
}
