package com.example.demo.atcoder.abc291;

import java.util.*;

/**
 * 拓扑排序
 * */
public class E {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List[] arr = new List[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        int[] cnt = new int[n+1];
        while (m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[b].add(a);
            cnt[a]++;
        }
        int[] ans = new int[n+1];
        int s = n;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <=n ; i++) {
            if(cnt[i]==0){
                dq.add(i);
            }
        }
        while (dq.size()>0){
            int size = dq.size();
            if(size>1){
                System.out.println("No");
                return;
            }

            int p = dq.poll();
            ans[p] = s;

            List<Integer> list = arr[p];
            for(int l:list){
                cnt[l]--;
                if(cnt[l]==0){
                    dq.add(l);
                }
            }


            s--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n; i++) {
            if(ans[i]==0){
                System.out.println("No");
                return;
            }
            sb.append(ans[i]).append(" ");
        }
        System.out.println("Yes");
        System.out.println(sb);
    }
}
