package com.example.demo.nowcode;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 0, b=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if(arr[i]==1 && i!=0){
                sum = 3;
            }else{
                while (arr[i]!=1){
                    if(arr[i]%2==0){
                        arr[i] /=2;
                    }else{
                        arr[i] =arr[i] *3+1;
                    }
                    sum++;
                }
            }

            if(i==0){
                a= sum;
            }else{
                b = Math.min(b, sum);
            }
        }
        if(a<b){
            System.out.println("HowarLi");
        }else {
            System.out.println("Elo");
        }

    }

}
