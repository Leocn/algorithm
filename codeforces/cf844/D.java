package com.example.demo.codeforces.cf844;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int max = 0;
            Map<Long, Integer> map  = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    int dis = arr[j]- arr[i];
                    for (int k = 1; k*k <=dis ; k++) {
                        if(dis%k!=0) continue;
                        int another = dis/k;
                        if((another-k)%2!=0) continue;
                        long x = (another + k)/2, y = (another -k)/2;
                        if(x*x>=arr[j]){
                            int cnt = map.getOrDefault(x*x-arr[j],0);
                            map.put(x*x-arr[j], cnt+1);
                            max = Math.max(max, cnt+1);
                        }
                    }
                }
            }
            if(map.size()==0){
                System.out.println(1);
                continue;
            }
            System.out.println((int)Math.pow(2*max, 0.5)  +1);

        }
    }
}
