package com.example.demo.codeforces.cf814;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n+1];
            int maxL = 0, max = Integer.MIN_VALUE;
            // 右侧比他大的在哪里
            int[] locs = new int[n+1];
            for (int i = 1; i <=n ; i++) {
                arr[i]=sc.nextInt();
                if(arr[i]>max) {
                    locs[maxL] = i;
                    maxL = i;
                    max = arr[i];
                }

            }
            while (q-->0){
                int loc = sc.nextInt();
                int round = sc.nextInt();
                int ans = 0;
                if(loc!=maxL){


                    if(locs[loc]!=0){
                        int target = locs[loc];
                        loc = (loc ==1? 1: loc-1);
                        if(loc-1>round){
                            ans =0;
                        }else if(loc-1<=round && round<= target-2){
                            ans = round-loc+1;
                        }else{
                            ans = target-1-loc;
                        }
                    }
                }else{
                    loc = (loc ==1? 1: loc-1);
                    if(loc<=round+1){
                        ans = round+1-loc;
                    }

                }
                System.out.println(ans);

            }

        }
    }
}
