package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Week87D {
    public static void main(String[] args) {
        smallestSubarrays(new int[]{76,57,77,64,41,82,34,57,94,33,87,24,17,54,11,10,18,70,80,37,18,5,11,71,0,29,90,45,25,64,64,32,3,67,78,4,98,2,50,100,9,97,48,47,23,28,25,45,56,37,30,72,57,58,39,89,78,13,76,40,44,79,41,99,24,7,86,23,42,58,34,14,11,26});
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] a = arriveAlice.split("-");
        String[] b = leaveAlice.split("-");
        String[] c = arriveBob.split("-");
        String[] d = leaveBob.split("-");
        int[] mon = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int a1 = Integer.parseInt(a[0]);
        int a2 = Integer.parseInt(a[1]);
        int startA = 0;
        for (int i = 1; i < a1; i++) {
            startA += mon[i-1];
        }
        startA +=a2;

        int endA = 0;
        int b1 = Integer.parseInt(b[0]);
        int b2 = Integer.parseInt(b[1]);
        for (int i = 1; i < b1; i++) {
            endA += mon[i-1];
        }
        endA +=b2;


        int startAAAAAAAA = 0;
        int endAAAAAAAA = 0;

        int c1 = Integer.parseInt(c[0]);
        int c2 = Integer.parseInt(c[1]);

        for (int i = 1; i < c1; i++) {
            startAAAAAAAA += mon[i-1];
        }
        startAAAAAAAA +=c2;



        int d1 = Integer.parseInt(c[0]);
        int d2 = Integer.parseInt(c[1]);

        for (int i = 1; i < d1; i++) {
            endAAAAAAAA += mon[i-1];
        }
        endAAAAAAAA +=d2;

        System.out.println(endA-startA);
        System.out.println(endAAAAAAAA-startAAAAAAAA);
        if(endA<startAAAAAAAA ||  endAAAAAAAA<startA){
            return 0;
        }



        return Math.min(endAAAAAAAA, endA) - Math.max(startA, startAAAAAAAA) +1;


    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> player = new PriorityQueue<>();
        PriorityQueue<Integer> trainer = new PriorityQueue<>();
        for (int j : players) {
            player.add(j);
        }

        for (int j : trainers) {
            trainer.add(j);
        }
        int ans = 0;
        while (player.size()!=0 && trainer.size()!=0){
            int p = player.poll();
            if(p<=trainer.peek()){
                ans++;
                trainer.poll();
            }else{
                while (trainer.size()!=0 && p>trainer.peek()){
                    trainer.poll();
                }
                if(trainer.size()!=0){
                    ans ++;
                    trainer.poll();
                }
            }
        }
        return ans;
    }


    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        char[][] arr = new char[n][32];
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder(Integer.toBinaryString(nums[i]));
            while(str.length() < 32){
                str.insert(0, "0");
            }
            arr[i] = str.toString().toCharArray();
        }
        int[] loc = new int[32];
        Arrays.fill(loc,-1);
        for (int i = 0; i < n; i++) {
            int max = 1;

            for (int j = 0; j < 32; j++) {
                if(((nums[i] >> j) & 1) == 0){
                    if(loc[j]==-2){
                        continue;
                    }
                    if(loc[j]==-1 || i>loc[j]){
                        int k = i+1;
                        while (k<n){
                            if(((nums[k] >> j) & 1)==1){
                                loc[j] = k;
                                break;
                            }
                            k++;
                        }
                        if(k==n){
                            loc[j]=-2;
                        }
                    }
                    if(loc[j]!=-2){
                        max = Math.max(max, loc[j]-i+1);
                    }

                }
            }
            ans[i] = max;
        }
        return ans;

    }

    public long minimumMoney(int[][] transactions) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->(a[1]-b[1]));

        int n = transactions.length;

        priorityQueue.addAll(Arrays.asList(transactions));

        long ans = priorityQueue.peek()[0];
        long now = priorityQueue.peek()[0];
        while(priorityQueue.size()>0){
            int[] p = priorityQueue.poll();
            if(now<p[0]){
                ans += p[0]-now;
                now = 0;
            }else{
                now -= p[0];
            }
            now  += p[1];
        }


        return ans;
    }
}
