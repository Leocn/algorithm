package com.example.demo.atcoder.abc303;


import java.util.*;

public class E {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] cnt  = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt(), y= sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
            cnt[x] ++;
            cnt[y]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <=n ; i++) {
            if(cnt[i]==1){
                dq.add(i);
            }
        }
        boolean[] vis = new boolean[n+1];
        Map<Integer,Integer> map = new HashMap<>();
        while (dq.size()>0){
            int s = dq.size();

            while (s-->0){
                int p = dq.poll();
                vis[p] = true;

                cnt[p]--;
                for(int next: arr[p]){
                    if(vis[next]){
                        continue;
                    }
                    map.put(next, 2);
                    vis[next] = true;
                    cnt[next]--;
                    for(int nn: arr[next]){
                        if(vis[nn]){
                            continue;
                        }
                        cnt[next]--;
                        cnt[nn]--;
                        vis[nn] = true;
                        map.put(next, map.get(next)+1);
                        if(cnt[nn]==1){
                            for(int nnn: arr[nn]){
                                if(!vis[nnn] ){
                                    cnt[nnn]--;
                                    if(cnt[nnn]==1){
                                        dq.add(nnn);
                                    }
                                }
                            }
                        }
                    }

                }

            }

        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            list.add(e.getValue()-1);
        }
        Collections.sort(list);
        for(int l: list){
            sb.append(l).append(" ");
        }
        System.out.println(sb);

    }
}
