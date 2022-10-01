package com.example.demo.leetcode;

import java.util.*;

public class Week63D {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("BBBBAAAA"));
        System.out.println(networkBecomesIdle(new int[][]{{0,1},{1,2}}, new int[]{0,2,1}));
    }
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);

        }
        return sum;
    }

    /**
     *
     * */
    public static boolean winnerOfGame(String colors) {
        int n = colors.length();
        if(n<3) return false;
        int[][] dp  = new int[n][2];
        if(colors.startsWith("AAA")){
            dp[2][0]= 1;
        }else if(colors.startsWith("BBB")){
            dp[2][1]= 1;
        }
        for (int i = 3; i < n; i++) {

            if(colors.startsWith("AAA", i-2)){
                dp[i][0]= dp[i-1][0]+1;
                dp[i][1]= dp[i-1][1];
            }else if(colors.startsWith("BBB", i-2)){
                dp[i][1]= dp[i-1][1]+1;
                dp[i][0]= dp[i-1][0];
            }else {
                dp[i][0]= dp[i-1][0];
                dp[i][1]= dp[i-1][1];
            }
        }
        return dp[n-1][0]>dp[n-1][1];
    }


    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int[] distance = new int[n];
        Arrays.fill(distance,100000);
        distance[0] = 0;
        List[] map = new List[n];
        for(int i = 0;i<n;i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            int u = edge[0],v = edge[1];
            map[u].add(v);
            map[v].add(u);
        }
        // 求各节点到0的最短距离
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        while(!queue.isEmpty()){
            int u = queue.poll();
            int current = distance[u]+1;
            List<Integer> next = map[u];
            for(int v : next){
                if(distance[v]>current){
                    queue.offer(v);
                    distance[v] = current;
                }

            }
        }
        int minTime = 0;
        for(int i = 1;i<n;i++){
            minTime = Math.max(minTime,distance[i]*2+(distance[i]*2-1)/patience[i]*patience[i]);
        }
        return minTime+1;
    }


}
