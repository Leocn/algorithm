package com.example.demo.codeforces.cf833;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            char[] cs = str.toCharArray();
            long ans = 0;
            long ansC = 0;
            long ansZ = 0;
            for(int i=0; i<n;i++){
                if(cs[i]== '0'){
                    ansC++;
                }else{
                    ansZ++;
                }
            }
            if(ansC == 0 ){
                System.out.println(ansZ*ansZ);
                continue;
            }
            if(ansZ==0){
                System.out.println(ansC*ansC);
                continue;
            }

            long max = 0;
            ans = ansC*ansZ;
            for(int i=0; i<n-1 ;i++){
                int s = i;
                while (i+1<n &&cs[i] == cs[i+1]){
                    i++;
                }
                max = Math.max(max, i-s+1);
            }
            ans = Math.max(max*max, ans);
            System.out.println(ans);
        }
    }
}
