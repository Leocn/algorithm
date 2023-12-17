package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[20];
        int[] b = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 20; i++) {
            b[i] = sc.nextInt();
        }
        int cur =1;
        int fir = 0, sec = 0;
        while (true){
            fir += a[cur-1];
            if(cur<=5){
                if(fir>5-cur+1 +sec){
                    break;
                }else if(sec> fir+5-cur){
                    break;
                }
            }
            sec += b[cur-1];

            if(cur<=5){
                if(fir>5-cur + sec){
                    break;
                }else if(sec> fir+5- cur){
                    break;
                }
            }
            if(cur>6){
                if(fir!=sec){
                    break;
                }
            }




            cur++;
        }
        System.out.println(cur);
        System.out.println(fir+":"+sec);


    }
}
