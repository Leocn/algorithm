package com.example.demo.atcoder.abc295;


import java.util.Scanner;

public class G {
    static int[] par;
    static int[] min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        par = new int[n+1];
        min = new int[n+1];
        for (int i = 0; i <=n; i++) {
            par[i] = i;
            min[i] = i;
        }
        for (int i = 0; i < n-1; i++) {
            int from = sc.nextInt();
            int to = i+1;
            par[from] = par[to];
            join(from, to);
        }
        int q = sc.nextInt();
        while (q-->0){
            int type = sc.nextInt();
            if(type==1){
                int from = sc.nextInt(), to = sc.nextInt();
                par[from] = par[to];
                join(from, to);
            }else {
                int f = sc.nextInt();
                System.out.println(query(f));
            }
        }


    }

    private static void  join(int from , int to){
        min[from] = Math.min(min[from], min[to]);
        while (min[to]!=to){
            to = par[to];
        }
        min[from]= par[to];

    }
    private static int query(int q){
        while (min[q] <= min[par[q]]){
            q= par[q];
        }
        return q;

    }

}
