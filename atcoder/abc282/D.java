package com.example.demo.atcoder.abc282;

import java.util.*;

public class D {
    static int[] par;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m  = sc.nextInt();
        ArrayList[] arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dis = new int[n+1];
        par = new int[n+1];
        int[][] record =new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
        }
        int cnt = 0;
        long tt = 0;
        for (int i = 1; i <=n ; i++) {
            if(dis[i]!=0){
                continue;
            }
            dq.add(i);
            dis[i] = 1;
            int an = 1;
            int an2 = 0;
            int cnn = 1;
            while (dq.size()>0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                int next = -dis[p];
                for(int t: list){
                    if(dis[t]!=0 && dis[t]!=next){
                        System.out.println(0);
                        return;
                    }
                    if(dis[t]!=0){
                        continue;
                    }
                    dis[t] = next;
                    par[t] = i;
                    dq.add(t);
                    cnn++;
                    if(next==-1){
                        an2++;
                    }else {
                        an++;
                    }

                }
            }
            tt += (long) cnn * cnt;
            cnt += cnn;
            record[i][0] = an;
            record[i][1] = an2;
        }

        long ans  = 0;
        for (int i = 1; i <= n; i++) {
            int p = getP(i);
            if(dis[i]==1){
                ans += record[p][1] - arr[i].size();
            }else{
                ans += record[p][0] - arr[i].size();
            }
        }
        System.out.println(ans/2 + tt);

    }
    private static int getP(int x){
        if(par[x]!=x){
            return getP(par[x]);
        }
        return x;
    }
}
