package com.example.demo.codeforces.ctr2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] s = new int[m];
            for (int i = 0; i < m ; i++) {
                s[i] = sc.nextInt();
            }

            Arrays.sort(s);
            int[] dis = new int[m];
            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
            for (int i = 0; i < m-1; i++) {
                dis[i] = s[i+1]-s[i]-1;
                queue.add(dis[i]);
            }
            dis[m-1] = s[0]+n - s[m-1]-1;
            queue.add(dis[m-1]);
            int sum = 0;
            int times = 0;
            while (queue.size()>0){
                int p = queue.poll();
                if(p<=times*4 ){
                    while (queue.size()>0 && queue.peek()<= times*4){
                        queue.poll();
                    }
                }else{
                    sum += p - times*4-1 ;
                }
                times +=1 ;
            }


            int ans = n-sum;
            System.out.println(ans);
        }
    }
}
