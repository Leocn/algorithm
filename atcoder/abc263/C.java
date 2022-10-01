package com.example.demo.atcoder.abc263;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    static int m ,n;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        dfs(1, list);
    }
    public static void dfs(int s, List<Integer> list){
        if(list.size()== n){
            StringBuilder sb = new StringBuilder();
            for(int d: list){
                sb.append(d).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=s; i<=m;i++) {
            list.add(i);
            dfs(i+1,list);
            list.remove(list.size()-1);
        }
    }
}
