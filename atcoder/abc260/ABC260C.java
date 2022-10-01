package com.example.demo.atcoder.abc260;

import java.util.Scanner;

public class ABC260C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long ans = 0;
        long xCount = 1;
        while(n>1){
            long tem = ans;
            ans = y*(xCount*x+ans);
            xCount = (x+1)* xCount+tem;
            n--;
        }
        System.out.println(ans);
    }
}
