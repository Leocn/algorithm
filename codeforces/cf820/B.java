package com.example.demo.codeforces.cf820;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            var n = sc.nextInt();
            String s = sc.next();
            StringBuilder ans = new StringBuilder();
            int index = n-1;
            while(index>=0){
                if(s.charAt(index)=='0'){
                    String c = s.substring(index -2 ,index);
                    int d = Integer.parseInt(c);
                    ans.insert(0, (char)((d-1)+'a'));
                    index-=3;
                }else {
                    String c = s.substring(index  ,index+1);
                    int d = Integer.parseInt(c);
                    ans.insert(0,  (char)((d-1)+'a'));
                    index--;
                }
            }
            System.out.println(ans);
        }
    }
}
