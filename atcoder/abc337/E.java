package com.example.demo.atcoder.abc337;


import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        while ((1<<m)<n){
            m++;
        }
        ArrayList<Integer>[] g = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <n ; i++) {
            int loc = 0;
            int tem = i;
            while (tem>0){
                if(tem%2==1){
                    g[loc].add(i);
                }
                tem/=2;
                loc++;
            }
        }
        System.out.println(m);
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(g[i].size()).append(" ");
            for(int a: g[i]){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
        }
        System.out.flush();
        char[] cs = sc.next().toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] == '0') continue;
            ans += (1<<i);
        }
        if(ans == 0){
            ans = n;
        }
        System.out.println(ans);

    }
}
