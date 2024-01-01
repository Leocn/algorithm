package com.example.demo.codeforces.CF1711;

import java.util.Scanner;

public class C {
    /** 只能按照示例这种方式排, 最少每种颜色两排, 可以从上倒下,可以从左到右*/
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n =  scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[] record = new int[k];
            for (int i = 0; i < k; i++) {
                record[i] = scanner.nextInt();
            }
            //按行算
            long row = 0;
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if(record[i]/m>=2){
                    row += record[i]/m;
                    if(record[i]/m>2){
                        flag = true;
                    }
                }
            }
            if( row>=n &&(flag || n%2==0)){
                System.out.println("Yes");
                continue;
            }
            long col = 0;
            flag = false;
            for (int i = 0; i < k; i++) {
                if(record[i]/n>=2){
                    col += record[i]/n;
                    if(record[i]/n>2){
                        flag = true;
                    }
                }
            }
            if( col>=m &&(flag || m%2==0)){
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");

        }
    }
}
