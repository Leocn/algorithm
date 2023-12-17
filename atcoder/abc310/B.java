package com.example.demo.atcoder.abc310;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr =  new int[n];
        HashSet<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            int c = sc.nextInt();
            for (int j = 0; j < c; j++) {
                sets[i].add(sc.nextInt());
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                if(arr[i]<arr[j]){
                    if(sets[i].containsAll(sets[j])){
                        System.out.println("Yes");
                        return;
                    }
                }else if(arr[j]<arr[i]){
                    if(sets[j].containsAll(sets[i])){

                        System.out.println("Yes");
                        return;
                    }
                }else {
                    if((sets[j].containsAll(sets[i]) && sets[j].size()>sets[i].size() )||
                            (sets[i].containsAll(sets[j]) && sets[i].size()>sets[j].size())){
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");


    }
}
