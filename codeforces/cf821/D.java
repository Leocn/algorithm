package com.example.demo.codeforces.cf821;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Leon
 * @Date 2022/9/20
 */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            char[] csA = sc.next().toCharArray();
            char[] csB = sc.next().toCharArray();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(csA[i]!=csB[i]){
                    count++;
                }
            }
            if(count%2!=0){
                System.out.println(-1);
                continue;
            }
            long ans = 0;

            if(n==count && count==2){
                ans = x;
            }else if(count==2){
                for (int i = 0; i < n; i++) {
                    if(csA[i]!=csB[i] && i<n-1&& csA[i+1]!= csB[i+1] ){
                        count-=2;
                    }
                }
                if(count==2){
                    ans = y;
                }else{
                    ans = Math.min(x,2*y);
                }


            } else{
                if(x>=y){
                    ans = count*y/2;
                }else{
                    for (int i = 0; i < n; i++) {
                        if(csA[i]!=csB[i] && i<n-1&& csA[i+1]!= csB[i+1] ){
                            count-=2;
                            ans+=x;
                            i++;
                        }
                    }
                    ans += count*y/2;
                }

            }


            System.out.println(ans);
        }
    }
}
