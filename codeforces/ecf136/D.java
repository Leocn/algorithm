package com.example.demo.codeforces.ecf136;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            List[] arr = new List[n+1];
            for (int i = 1; i <=n ; i++) {
                arr[i] = new ArrayList();
            }
            for (int i = 0; i < n-1; i++) {
                arr[sc.nextInt()].add(i+1);
            }
            int[] h = new int[n+1];
            int height = 0;
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(1);
            while (dq.size()>0){
                int sz = dq.size();
                boolean flag = false;
                while (sz-->0){
                    int p = dq.poll();
                    h[p] = height;
                    List<Integer> list =arr[p];
                    if(list.size()>0){
                        dq.addAll(list);
                        flag = true;
                    }
                }
                if(flag){
                    height++;
                }
            }
            if(height==1){
                System.out.println(1);
                continue;
            }
            while (k-->0 && height>1){
                for (int i = 2; i <=n; i++) {

                }
            }


        }
    }
}
