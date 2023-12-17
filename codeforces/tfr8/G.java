package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

            int n = sc.nextInt();
            String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
            int[][] cnt = new int[3][n+1];
            int max = 0;
            for (int i = n-1; i >=0; i--) {
                char[] cs = arr[i].toCharArray();
                for (int j = 0; j < 3; j++) {
                    if(cs[j] == '#'){
                        if(j==0){
                            cnt[0][i] = Math.max(cnt[0][i+1], cnt[1][i+1]);
                        }else if(j==1){
                            cnt[1][i] = Math.max(Math.max(cnt[0][i+1], cnt[1][i+1]),cnt[2][i+1]);
                        }else {
                            cnt[2][i] = Math.max(cnt[1][i+1],cnt[2][i+1]);
                        }
                    }else if(cs[j]=='c'){
                        if(j==0){
                            cnt[0][i] = Math.max(cnt[0][i+1], cnt[1][i+1])+1;
                        }else if(j==1){
                            cnt[1][i] = Math.max(Math.max(cnt[0][i+1], cnt[1][i+1]),cnt[2][i+1])+1;
                        }else {
                            cnt[2][i] = Math.max(cnt[1][i+1],cnt[2][i+1])+1;
                        }
                    }else if(cs[j] == '*'){
                        cnt[j][i] = Integer.MIN_VALUE;
                    }
                    max = Math.max(max, cnt[j][i]);
                }
            }
            out.println(max);

        out.close();
    }
}
