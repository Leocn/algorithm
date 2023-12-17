package com.example.demo.codeforces.CF1256;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long k= sc.nextLong();
            char[] cs = sc.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(k==0){
                    sb.append(cs[i]);
                    continue;
                }
                if(cs[i] == '0'){
                    if(k>=cnt){
                        sb.append('0');
                        k-=cnt;
                    }else {
                        while (k<cnt){
                            sb.append('1');
                            cnt--;
                        }
                        sb.append('0');
                        k-=cnt;
                    }
                    if(k==0){
                        while (cnt>0){
                            sb.append('1');
                            cnt--;
                        }
                    }

                }else {
                    cnt++;
                }
            }
            while (cnt>0){
                sb.append('1');
                cnt--;
            }
            System.out.println(sb);
        }
    }
}
