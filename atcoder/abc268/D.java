package com.example.demo.atcoder.abc268;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {
    static Set<String> set = new HashSet<>();
    static boolean[] vis;
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        var m = sc.nextInt();
        String[] arr = new String[n+1];
        vis = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        arr[n] = "_";
        for (int i = 0; i < m; i++) {
            set.add(sc.next());
        }
        String ans = dfs( "", arr, 0);
        System.out.println(ans);
        
    }
    private static String dfs(String str, String[] arr, int count){
        if(str.length()>16){
            return "-1";
        }

        if(str.length()>=3 && !str.endsWith("_") && !set.contains(str) && count==n){
           return str;
        }

        if(str.length()>0 && !str.endsWith("_")){
            String next = str + "_";
            String res = dfs(next, arr, count);
            if(!res.equals("-1")){
                return res;
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                if(i==arr.length-1 && str.length()==0){
                    continue;
                }
                if(i!=arr.length-1 &&vis[i]){
                    continue;
                }
                String next = str +  arr[i];
                vis[i] = true;
                String res = "-1";
                if(i==arr.length-1){
                    res = dfs(next, arr, count);
                }else{
                    res = dfs(next, arr, count+1);
                }
                if(!res.equals("-1")){
                    return res;
                }
                vis[i] = false;

            }
        }
        return "-1";



    }

}
