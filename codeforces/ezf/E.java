package com.example.demo.codeforces.ezf;

import java.io.PrintWriter;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-->0){
            long n = sc.nextLong();
            long sum = 0;
            for (int i = 1; i <= 9 ; i++) {
                long cnt = n/10 + (n%10>=i?1:0);
                long s = 0;

                if(i==4){
                    s = cnt *6;
                }else if(i==2){
                    s = (cnt +1)/2 *4 + cnt/2*6;
                }else if(i==3){
                    s = (cnt +1)/2 *7 + cnt/2*3;
                }else if(i==7){
                    s = (cnt +1)/2 *3 + cnt/2*7;
                }else if(i==8){
                    s = (cnt +1)/2 *6 + cnt/2*4;
                }else {
                    s = cnt * i;
                }

                sum += s%10;
            }
            out.println(sum%10);
        }
        out.close();
    }
}
