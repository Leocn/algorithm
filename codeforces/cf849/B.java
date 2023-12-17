package com.example.demo.codeforces.cf849;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            int a = 0, b =0;
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if(c=='U'){
                    b++;
                }else if(c=='D'){
                    b--;
                }else if(c=='L'){
                    a--;
                }else {
                    a++;
                }
                if(a==1 && b==1){
                    System.out.println("YES");
                    continue out;
                }
            }
            System.out.println("NO");
        }
    }

}
