package com.example.demo.atcoder.abc302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {

    static boolean[] vis;
    static int n;
    static String[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        vis = new boolean[n];
         arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        boolean ans  = dfs(new ArrayList<>());
        if(ans){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


    }
    private static boolean dfs( List<Integer> list){
        if(list.size()==n){
            for (int i = 1; i <n ; i++) {
                char[] cs =arr[list.get(i)].toCharArray();
                char[] pre = arr[list.get(i-1)].toCharArray();
                int dif = 0;
                for (int j = 0; j < cs.length; j++) {
                    if(cs[j]!=pre[j]){
                        dif++;
                    }
                }
                if(dif!=1){
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < n; i++) {
            if(vis[i]){
                continue;
            }
            vis[i]= true;
            list.add(i);
            if(dfs(list)){
                return true;
            }

            vis[i]= false;
            list.remove(list.size()-1);
        }
        return false;

    }
}
