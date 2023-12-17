package com.example.demo.nowcode;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        double d = 0.6;
        double dis = 0.5;
        int cnt = 1;
        double ans = 0.6;
        for (int i = 0; i < str.length; i++) {
            if(str[i]=='L'){
                cnt = 1;
                dis = 0.5;
                d = 0.6;
                ans = d * dis;
                continue;
            }
            if(str[i]=='3' || str[i] == '4'){
                cnt++;
                if(cnt==90){
                    d = 1;
                }else if(cnt>=74){
                    d += 6;
                }
                ans = d*dis;

                continue;
            }
            if(str[i] == 'K'||str[i] == 'D'||str[i] =='7'||str[i] =='T'||str[i] =='Q'||str[i] =='M' ){
                dis = 1;
                cnt = 1;
                d = 0.6;
                ans = d * dis;
            }

        }
        System.out.println(String.format("%.1f",ans)+"%");
    }
}
