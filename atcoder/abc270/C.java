package com.example.demo.atcoder.abc270;

import java.util.*;

public class C {
    static ArrayList[] arr;
    static  boolean[] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        arr =  new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList();
        }
        for (int i = 0; i <n-1 ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }


        vis= new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        dfs(x, y, list);
        StringBuilder sb = new StringBuilder();

        for (int a: list) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);

    }
    private static boolean dfs(int x, int y, List<Integer> list){
        if(x==y){
            list.add(x);
            return true;
        }
        vis[x] = true;
        List<Integer> res = arr[x];
        if(res.size()==0){
            return false;
        }
        list.add(x);
        for (int t : res) {
            if (vis[t]) {
                continue;
            }

            if(dfs(t, y, list)){
                return true;
            }else{
                list.remove(list.size()-1);
            }



        }
        return false;
    }




}
