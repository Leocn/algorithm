package com.example.demo.atcoder.abc271;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        List[] arr = new List[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = new ArrayList();
            int l = sc.nextInt();
            for (int j = 0; j < l; j++) {
                arr[i].add(sc.nextInt());
            }
        }
        while (q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            out.println(arr[a].get(b-1));

        }
        out.close();
    }
}
