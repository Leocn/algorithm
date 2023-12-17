package com.example.demo.codeforces.CF1907;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n>0){
            int len= sc.nextInt();
            int[][] nums=new int[len][2];
            for(int i=0;i<len;i++){
                nums[i][0]=sc.nextInt();
                nums[i][1]=sc.nextInt();
            }
            long l=0;
            long r=1000000000;
            long ans=1000000000;
            while(l<=r){
                long mid=l+(r-l)/2;
                if(check(mid,nums)){
                    ans=mid;
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            System.out.println(ans);
            n--;
        }
    }
    public static boolean check(long k,int[][] nums){
        long l=0;
        long r=0;
        for(int i=0;i<nums.length;i++){
            l=Math.max(l-k,nums[i][0]);
            r=Math.min(r+k,nums[i][1]);
            if(l>r){
                return false;
            }
        }
        return true;
    }
}
