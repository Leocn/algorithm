package com.example.demo.atcoder.arc149;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = -1;
        int d = -1;
        boolean flag = false;
        for (int i = 1; i <=9 ; i++) {
            int now = 0;
            for (int j = 1; j <=n ; j++) {
                now = (10* now + i)%m;
                if(now==0){
                    if(ans<=j){
                        ans = j;
                        d= i;
                    }
                }
            }
        }
        if(ans==-1){
            System.out.println(-1);
        }else{
            System.out.println((d+"").repeat(ans));
        }

    }

}
