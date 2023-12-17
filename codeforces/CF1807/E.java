package com.example.demo.codeforces.CF1807;

import java.util.Scanner;

public class E {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long[] sum = new long[n+1];
            for (int i = 0; i < n; i++) {
                sum[i+1] = sum[i] + arr[i];
            }
            int l = 1, r = n;
            while (true){
                StringBuilder sb = new StringBuilder();
                sb.append("?").append(" ");
                int mid = l+r>>1;
                sb.append(mid-l+1).append(" ");
                for (int i = l; i <= mid; i++) {
                    sb.append(i).append(" ");
                }
                System.out.println(sb);
                System.out.flush();
                long s = sc.nextLong();
                if(s!=sum[mid]- sum[l-1]){
                    if(l==mid){
                        System.out.println("! "+ l);
                        System.out.flush();
                        continue out;
                    }
                    r = mid;
                }else {

                    l = mid+1;
                }
            }

        }

    }


}
