package com.example.demo.codeforces.CF1711;

import java.util.*;

public class B {
    /**
     *  去除一个偶数的数 或者 相邻奇数的数
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] record = new int[n+1];
            for (int i = 1; i <=n; i++) {
                record[i] = scanner.nextInt();

            }
            int[] sum = new int[n+1];
            int pairs = 0;
            Set<Integer>[] list = new Set[n+1];
            for (int i = 1; i <=n ; i++) {
                list[i] = new HashSet<>();
            }
            while(m>0){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                sum[x]++;
                sum[y]++;
                list[x].add(y);
                list[y].add(x);
                m--;
                pairs++;
            }
            if(pairs%2==0){
                System.out.println(0);
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <=n ; i++) {
                if(sum[i]==0){
                   continue;
                }
                if(sum[i]%2==1){
                    ans = Math.min(ans, record[i]);
                }else{
                    for(int x: list[i]){
                        if(sum[x]%2==0){
                            ans = Math.min(ans, record[i] + record[x]);
                        }
                    }
                }
            }

            System.out.println(ans);

        }
    }
}
