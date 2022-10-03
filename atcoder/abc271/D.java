package com.example.demo.atcoder.abc271;

import java.util.Scanner;

public class D {
    static Integer[][] arr;
    static StringBuilder str;
    static int n ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int s = sc.nextInt();
         arr = new Integer[n][2];
        int sum =0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            sum += arr[i][0] + arr[i][1];
            max+= Math.max( arr[i][0] , arr[i][1] );
            min += Math.min( arr[i][0] , arr[i][1] );
        }
        if(max<s){
            System.out.println("No");
            return;
        }
        if(min>s){
            System.out.println("No");
            return;
        }

        int count = sum - s;
        str = new StringBuilder();
        if(count<=0){
            System.out.println("No");
            return;
        }
        if(dfs(0, s, count)){
            System.out.println("Yes");
            System.out.println(str);
        }else {
            System.out.println("No");
        }

    }
    private static boolean dfs(int loc, int s, int count){
        if(s==0 && count==0 && loc==n){
            return true;
        }
        if(s<=0|| count<=0||loc==n ){
            return false;
        }
        str.append("H");
        if(!dfs(loc+1, s-arr[loc][0], count-arr[loc][1])){
            str.deleteCharAt(str.length()-1);
            if(arr[loc][0].intValue() ==  arr[loc][1].intValue()){
                return false;
            }
            str.append("T");

            if(!dfs(loc + 1, s - arr[loc][1], count - arr[loc][0])){
                str.deleteCharAt(str.length()-1);
                return false;
            }else {
                return true;
            }
        }else {
            return true;
        }
    }
}
