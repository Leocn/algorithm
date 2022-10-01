package com.example.demo.atcoder.arc147;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer>  priorityQueue= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min,arr[i]);
            priorityQueue.add(arr[i]);
        }
        int ans = 0;
        while(priorityQueue.size()>1){
            int max = priorityQueue.poll();
            ans ++;
            if(max%min==0){
                continue;
            }
            min = max%min;
            priorityQueue.add(min);

        }
        System.out.println(ans);

    }
}
