package com.example.demo.codeforces.cf822;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            char[] target = sc.next().toCharArray();
            long ans = 0;
            boolean[] vis = new boolean[n+1];
            for(int i=0; i<n; i++){
                if(target[i]=='0'){
                    long st = i+1;
                    long count =1;
                    while (st<=n){
                        if(target[(int)st-1] == '1'){
                            break;
                        }
                        if(!vis[(int)st] && target[(int)st-1] == '0'){
                            vis[(int)st] = true;
                            ans += i+1;

                        }
                        count++;
                        st = (long) (i + 1) * count;
                    }
                }
            }
            out.println(ans);
        }
        out.close();
    }
}
