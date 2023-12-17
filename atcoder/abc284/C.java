package com.example.demo.atcoder.abc284;

import java.util.Scanner;

public class C {
    static Integer[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new Integer[n+1];
        for (int i = 0; i <n+1 ; i++) {
            arr[i] = i;
        }
        while (m-->0){
            int from = findRoot(sc.nextInt());
            int to = findRoot(sc.nextInt());
            if(from!=to){
                arr[from] = to;
            }
        }
        int ans = 0;

        for(int i=1; i<=n; i++){
            if(arr[i]==i){
                ans++;
            }
        }
        System.out.println(ans);
    }
    private static int findRoot(int x){
        if(x==arr[x]){
            return x;
        }
        return findRoot(arr[x]);
    }
}
