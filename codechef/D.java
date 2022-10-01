package com.example.demo.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[] ans = new int[3];
            ans[0] = x;
            ans[1] = y;
            ans[2] = z;
            Arrays.sort(ans);
            int res = 0;
            if(ans[0]==0){
                if(ans[1]==0){
                    if(ans[2]>0){
                        res++;
                    }
                }else if(ans[1] == 1){
                    res =2;
                }else {
                    res= 3;
                }
            }else if(ans[0] ==1){
                if(ans[1] == 1){
                    res = 3;
                }else {
                    res =4;
                }
            }else if(ans[0]==2){
                if(ans[1] ==2){
                    if(ans[2]==2){
                        res = 4;
                    }else{
                        res = 5;
                    }
                }else{
                    res= 5;
                }
            }else{
                res = 6;
            }
            System.out.println(res);
        }
    }
}
