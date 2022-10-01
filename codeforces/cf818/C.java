package com.example.demo.codeforces.cf818;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n =sc.nextInt();
            int[] a = new int[n];
            int[] b= new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                b[i] =sc.nextInt();
                min = Math.min(min, b[i]);
                if(b[i]-a[i]<0){
                    flag =false;

                }
            }
            if(!flag){
                System.out.println("No");
                continue;
            }



            List<Integer> list = new ArrayList<>();
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if(b[i] == min){
                    list.add(i);
                    ans[i] = min;
                }
            }

            out:
            for(int in: list){
                int right = ans[in];
                for (int i = 0; i < n+in; i++) {
                    int target  = (n + in - i - 1) % n;

                   if(ans[target]==min){
                       break;
                   }
                   if(b[target] != a[target] && b[target]>right+1){
                       flag = false;
                       break out;
                   }else{
                       right = b[target];


                   }


                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }


        }
    }

}
