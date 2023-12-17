package com.example.demo.atcoder.arc161;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        oo:while (t-->0){
            long n = sc.nextLong();
            char[] cs = Long.toBinaryString(n).toCharArray();
            int cnt = 3;
            int l = cs.length;
            int[] sum = new int[l+1];
            for (int i = l-1; i >=0 ; i--) {
                sum[i] = sum[i+1] + (cs[i]=='1'?1:0);
            }
            if(sum[0]>=3){
                for (int i = 0; i < l; i++) {
                    if(cnt == 0){
                        cs[i] = '0';
                    }else {
                        if(cs[i]=='1'){
                            cnt--;
                        }
                    }
                }

            }else {
                boolean f = false;
                for (int i = l-1; i >=0 ; i--) {
                    if(cs[i]=='1' && i+3-(sum[0] - sum[i])<l){
                        cs[i] ='0';
                        for (int j = i+1; j <i+4-(sum[0] - sum[i]) ; j++) {
                            cs[j] = '1';
                        }
                        for (int j = i+i+4-(sum[0] - sum[i]); j <l; j++) {
                            cs[j] = '0';
                        }
                        f = true;
                        break ;
                    }

                }
                if(!f){
                    out.println(-1);
                    continue oo;
                }



            }
            out.println(Long.parseLong(new String(cs),2));

        }
        out.close();


    }

}
