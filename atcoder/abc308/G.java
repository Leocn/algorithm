package com.example.demo.atcoder.abc308;

import cn.hutool.core.lang.tree.Tree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        int cnt =0;
        while (Q-->0){
            int type = sc.nextInt();
            if(type==1){
                int s = sc.nextInt();

                Integer floor = treeMap.ceilingKey(s);
                if(floor!=null){
                    int b = floor^s;
                    int t = tree.getOrDefault(b,0);
                    tree.put(b, t+1);

                }
                Integer low = treeMap.floorKey(s);
                if(low!=null){
                    int b = low^s;
                    int t = tree.getOrDefault(b,0);
                    tree.put(b, t+1);

                }


                treeMap.put(s, treeMap.getOrDefault(s,0)+1);
                cnt++;
            }else if(type == 2){
                int s = sc.nextInt();
                int c = treeMap.getOrDefault(s,0);
                if(c==1){
                    treeMap.remove(s);
                }else{
                    treeMap.put(s, c-1);
                }
                Integer floor = treeMap.ceilingKey(s);
                if(floor!=null){
                    int b = floor^s;
                    int t = tree.getOrDefault(b,0);
                    if(t==1){
                        tree.remove(b);
                    }else {
                        tree.put(b, t-1);
                    }


                }
                Integer low = treeMap.floorKey(s);
                if(low!=null){
                    int b = low^s;
                    int t = tree.getOrDefault(b,0);
                    if(t==1){
                        tree.remove(b);
                    }else {
                        tree.put(b, t-1);
                    }

                }

                cnt--;
            }else {
                System.out.println(tree.firstKey());
            }
        }


    }
}
