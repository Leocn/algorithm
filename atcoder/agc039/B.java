package com.example.demo.atcoder.agc039;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        ArrayList[] arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < n; j++) {
                if(str.charAt(j) == '1'){
                    arr[i].add(j);
                }
            }
        }


        Deque<Integer> dq = new ArrayDeque<>();
        int ans = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <n ; i++) {
            if( dis[i] ==Integer.MAX_VALUE ){
                List<Integer> record = new ArrayList<>();
                int res =0;
                dq.add(i);
                record.add(i);
                dis[i] = 0;
                while (dq.size()>0){
                    int size = dq.size();
                    res++;
                    while(size-->0){
                        int p = dq.poll();
                        List<Integer> list = arr[p];
                        for(int t : list){
                            if(dis[t] == dis[p]){

                                System.out.println(-1);
                                return;
                            }
                            if(dis[t]==Integer.MAX_VALUE){
                                dis[t] = res%2;
                                dq.add(t);
                                record.add(t);
                            }


                        }
                    }

                }

                int max = 0;
                for (int j = 1; j < record.size(); j++) {
                    max = 0;
                    boolean[] vis = new boolean[n];
                    vis[record.get(j)] = true;
                    dq.add(record.get(j));
                    while (dq.size()>0){
                        int size = dq.size();
                        max++;
                        while(size-->0){
                            int p = dq.poll();
                            List<Integer> list = arr[p];
                            for(int t : list){
                                if(vis[t]){
                                    continue;
                                }
                                dq.add(t);
                                vis[t] = true;
                            }
                        }
                    }

                    res = Math.max(max, res);
                }

                ans +=res;
            }


        }
        System.out.println(ans);

    }
}
