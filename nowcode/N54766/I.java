package com.example.demo.nowcode.N54766;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int d =  sc.nextInt()-1;
                arr[i] = d;
                map.put(d, i);
            }
            int[] min = new int[n];
            for (int i = 0; i < n; i++) {
                int cnt = 1, tar = map.get(i);
                while (cs[tar]!=cs[i]){
                    cnt++;
                    tar = map.get(tar);;
                }
                min[i] =cnt;
            }
            long gcd = -1;
            long s = -1;
            for (int i = 0; i < n; i++) {
                if(min[i]==1){
                    continue;
                }
                if(gcd == -1){
                    gcd = min[i];
                    s = min[i];
                    continue;
                }
                if(s%min[i] == 0){
                    continue;
                }
                gcd = gcd(s, min[i]);
                s = s* min[i]/ gcd;
            }

            System.out.println(s==-1?1:s);

        }
    }
    public static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

}
