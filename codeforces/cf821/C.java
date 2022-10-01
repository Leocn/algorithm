package com.example.demo.codeforces.cf821;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i <n; i++) {
                arr[i] = sc.nextInt();
            }
            if(n==1){
                out.println(0);
                continue;
            }
            List<Integer> ansA = new ArrayList<>();
            List<Integer> ansB = new ArrayList<>();
            int sum = arr[0] + arr[n-1];
            ansA.add(1);
            ansB.add(n);
            if(sum%2==0){
                arr[0] = arr[n-1];
            }else{
                arr[n-1] = arr[0];
            }
            for (int i = 1; i <n-1 ; i++) {
                if((arr[i]+arr[0])%2==0){
                    ansA.add(i+1);
                    ansB.add(n);
                }else{
                    ansA.add(1);
                    ansB.add(i+1);
                }
            }
            out.println(ansA.size());
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<ansA.size();i++) {
                sb.append(ansA.get(i)).append(" ").append(ansB.get(i)).append(" ");
            }

            out.println(sb);



        }
        out.close();
    }
}
