package com.example.demo.codeforces.ecf134;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] target = new int[n];
            int[] ansMax = new int[n];
            int[] ansMin = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                target[i] =sc.nextInt();
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->{ return b-a;});
            priorityQueue.add(target[n-1]);
            int loc = n-2;
            for (int i = n-1; i >=0 ; i--) {
                if(loc == i){
                    while (priorityQueue.size()>0){
                        priorityQueue.poll();
                    }
                }
                while(loc>=0 &&target[loc]>= arr[i]){
                    priorityQueue.add(target[loc]);
                    loc--;
                }
                ansMax[i] = priorityQueue.peek()- arr[i];
                ansMin[i] = target[loc+1] - arr[i];
            }
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb1.append(ansMin[i]).append(" ");
                sb2.append(ansMax[i]).append(" ");
            }
            System.out.println(sb1);
            System.out.println(sb2);

        }
    }
}
