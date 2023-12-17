package com.example.demo.codeforces.CF1771;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List[]arr = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[Math.min(a,b)].add(Math.max(a,b));
            }
            long ans = 0;
            int max = n+1;
            for (int i = n; i >=1; i--) {
                List<Integer> list = arr[i];
                Collections.sort(list);
                if(list.size()!=0 && list.get(0)< max){

                    max = list.get(0);
                }
                ans += max -i;

            }
            System.out.println(ans);


        }
    }
}
