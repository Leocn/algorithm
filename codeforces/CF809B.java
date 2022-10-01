package com.example.demo.codeforces;

import java.util.*;

public class CF809B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] ans = new int[n];
            int[] save = new int[n+1];
            Arrays.fill(save,-1);
            for(int i=0; i<n; i++){
                int s = sc.nextInt();
                if(save[s]==-1){
                    ans[s-1] ++;
                    save[s] = i;
                }else{
                    if((i-save[s]-1)%2==0){
                        ans[s-1] ++;
                        save[s] = i;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int an : ans) {
                sb.append(an).append(" ");
            }
            System.out.println(sb);

        }
    }
}
