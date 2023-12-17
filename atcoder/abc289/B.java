package com.example.demo.atcoder.abc289;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        if(m==0){
            for (int i = 1; i <= n; i++) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        int loc = 1;
        int st = 1;
        for (int i = 0; i <m; i++) {
            if(arr[i]>st){
                sb.append(st).append(" ");
                st++;
                i--;
                continue;

            }
            List<Integer> list = new ArrayList<>();
            while (i<m && arr[i]==st){
                list.add(st);
                i++;
                st++;
            }
            if(st<=n){
                list.add(st);
                st++;
            }
            Collections.reverse(list);
            for(int l:list){
                sb.append(l).append(" ");
            }
            i--;
        }
        while (st<=n){
            sb.append(st).append(" ");
            st++;
        }
        System.out.println(sb);
    }
}
