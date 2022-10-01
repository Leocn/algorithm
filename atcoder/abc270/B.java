package com.example.demo.atcoder.abc270;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        if(x>0){
            if(y<0){
                System.out.println(x);
            }else{
                if(y>x){
                    System.out.println(x);
                }else {
                    if(z<0){
                        System.out.println(-2*z + x);
                    }else if(z<y){
                        System.out.println(x);
                    }else {
                        System.out.println(-1);
                    }
                }
            }

        }else{
            if(y>0){
                System.out.println(-x);
            }else{
                if(y<x){
                    System.out.println(-x);
                }else {
                    if(z>0){
                        System.out.println(2*z-x);
                    }else if(z>y){
                        System.out.println(-x);
                    }else {
                        System.out.println(-1);
                    }
                }


            }





        }
        
    }
}
