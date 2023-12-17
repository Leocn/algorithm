package com.example.demo.atcoder.abc302;

import java.io.PrintWriter;
import java.util.*;

public class E {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] cnt = new int[n+1];
        int sum = n;
        List<Integer>[] arr = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new LinkedList<Integer>();
        }

        while (q-->0){
            int type = sc.nextInt();
            if(type==1){
                int x = sc.nextInt(), y = sc.nextInt();
                if(cnt[x]==0){
                    sum--;

                }
                if(cnt[y]==0){
                    sum--;
                }
                cnt[x]++;
                cnt[y]++;
                arr[x].add(y);
                arr[y].add(x);
            }else {
                int x = sc.nextInt();
                if(cnt[x]==0){
                    out.println(sum);
                    continue;
                }
                Set<Integer> set = new HashSet<>(arr[x]);
                for(int s: set){
                    arr[x].remove((Integer) s);
                    arr[s].remove((Integer)x);
                    cnt[s]--;
                    if(cnt[s]==0){
                        sum++;
                    }
                }
                sum++;
                cnt[x] = 0;

            }
            out.println(sum);

        }
        out.close();
    }
}
