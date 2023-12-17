package com.example.demo.atcoder.abc291;

import java.util.*;

public class F {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List[] arr = new List[n+1];
        List[] arrBack = new List[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
            arrBack[i] = new ArrayList<>();
        }
        for (int i = 1; i <=n ; i++) {
            char[] cs = sc.next().toCharArray();
            for (int j = 1; j <=m ; j++) {
                if(cs[j-1]=='1'){
                    arr[i].add(i+j);
                    arrBack[i+j].add(i);
                }
            }
        }
        int[] dp = bfs(arr,1,n);
        int[] dpBack = bfs(arrBack, n,n);

        int[] ans = new int[n+1];
        Arrays.fill(ans, -1);
        for (int i = 1; i <=n ; i++) {
            List<Integer> list = arr[i];
            for(int l: list){
                if(dp[i]!=-1 && dpBack[l]!=-1){
                    int res  = dp[i] + dpBack[l] + 1;
                    for(int j = i+1; j<l ; j++){
                        if(ans[j]==-1|| ans[j]>res){
                            ans[j] = res;
                        }
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <=n-1 ; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
    private static int[] bfs(List[] arr, int s, int n){
        int[] ans = new int[n+1];
        Arrays.fill(ans,-1);
        ans[s] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        int dis = 0;
        while (dq.size()>0){
            int  size = dq.size();
            dis++;
            while (size-->0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                for(int l:list){
                    if(ans[l]==-1){
                        ans[l] = dis;
                        dq.add(l);
                    }
                }
            }
        }
        return ans;
    }
}
