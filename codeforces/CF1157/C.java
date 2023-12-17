package com.example.demo.codeforces.CF1157;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = n-1;
        int before = -1;
        StringBuilder sb = new StringBuilder();
        while (left!=right){
            if(arr[left]<= before  && arr[right]<=before){
                break;
            }
            if(arr[left]>arr[right]){
                if(arr[right]<=before){
                    sb.append("L");
                    before = arr[left++];
                }else {
                    sb.append("R");
                    before = arr[right--];

                }
            }else if(arr[left]<arr[right]){
                if(arr[left]<= before){
                    sb.append("R");
                    before = arr[right--];
                }else {
                    sb.append("L");
                    before = arr[left++];
                }
            }else {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int before1 = before;
                int before2 = before;
                while (left<n &&  arr[left]>before1 ){
                    sb1.append("L");
                    before1 = arr[left++];
                }
                while (right>=0 && arr[right]>before2){
                    sb2.append("R");
                    before2 = arr[right--];
                }
                if(sb1.length()>sb2.length()){
                    sb.append(sb1);
                }else {
                    sb.append(sb2);
                }
                before = Math.max(before1, before2);

                break;
            }
        }
        if(left==right && arr[left]>before){
            sb.append("L");
        }
        System.out.println(sb.length());
        System.out.println(sb);

    }
}
