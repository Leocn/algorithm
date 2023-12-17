package com.example.demo.atcoder.arc156;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        out:while (t-->0){
            int n = scanner.nextInt();
            char[] arr = scanner.next().toCharArray();
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]=='1'){
                    cnt++;
                }

            }
            if(cnt%2!=0){
                System.out.println(-1);
                continue;
            }
            int sum =0 ;
            int loc = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]=='1'){
                    sum++;
                }
                if(sum==cnt/2){
                    loc = i+1;
                    break;
                }

            }
            for (int i = 0; i < n; i++) {
                if(arr[i]=='1'){
                    loc = Math.max(i+2, loc);
                    while (loc<n && arr[loc]=='0'){
                        loc++;
                    }
                    if(loc<n){
                        arr[i] = '0';
                        arr[loc] = '0';
                        ans++;
                    }
                }

            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]=='1'){
                    c++;
                }
            }
            if(c==2 && n==3){
                System.out.println(-1);
                continue;
            }
            if(c==2){
                ans+=2;
            }
            if(c==2 && n==4 && arr[1]=='1' && arr[2] =='1'){
                ans++;
            }
            System.out.println(ans);
        }
    }
}
