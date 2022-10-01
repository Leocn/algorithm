package com.example.demo.codeforces.cgr22;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        out :while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] arr = new long[n+1];
            for (int i = n-k+1; i < n+1; i++) {
                arr[i] = sc.nextLong();
            }
            long[] ans = new long[n+1];
            ans[n] = Long.MAX_VALUE;
            for (int i = n-1; i >n-1-k ; i--) {
                ans[i] = arr[i+1]-arr[i];
                if(i!=n-k && ans[i]>ans[i+1] ){
                    System.out.println("NO");
                    continue out;
                }
            }
            boolean flag = true;
            if(k<n){
                long an = ans[n-k] /(n-k+1);
                long l = ans[n-k] %(n-k+1);
                if(an>ans[n-k+1] || (an ==ans[n-k+1] &&l>0)){
                    System.out.println("NO");
                    flag = false;
                }



            }else{
                for (int i = 0; i <n ; i++) {
                    if(ans[i]>ans[i+1]){
                        flag = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }


        }
    }
}
