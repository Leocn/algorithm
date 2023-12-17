package com.example.demo.leetcode;

public class Week92D {
    public static void main(String[] args) {

    }
    public int numberOfCuts(int n) {
        if(n%2==0){
            return n/2;
        }else{
            return n;
        }
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] arr = new int[m][2];
        int[][] arr1 = new int[n][2];
        for(int i = 0; i<m; i++){
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0) {
                    arr[i][0]++;
                }else{
                    arr[i][1]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[j][i]==0){
                    arr1[i][0]++;
                }else {
                    arr1[i][1]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arr[i][1]+arr1[j][1] - arr[i][0] - arr1[j][0];
            }
        }
        return ans;

    }


    public int bestClosingTime(String customers) {
        int n = customers.length();
        char[] cs = customers.toCharArray();
        int[] arr = new int [n+1];
        int[] arr1 = new int[n+1];

        int sum = 0;
        for(int i=1; i<=n;i++){
            if(cs[i-1]=='N'){
               sum++;
            }
            arr[i] = sum;
        }
        sum = 0;
        for(int i=n-1; i>=0; i--){
            if(cs[i]=='Y'){
                sum++;
            }
            arr1[i] = sum;
        }
        int ans = -1;
        int max = Integer.MAX_VALUE;
        for(int i =0; i<=n; i++){
            if(arr[i]+arr1[i]<max){
                ans = i;
                max = arr[i]+arr1[i];
            }
        }
        return  ans;
    }


    int MOD = (int)1e9+7;
    public int countPalindromes(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] pre = new int[10], suf = new int[10];
        int[][] pre1 = new int[10][10], suf1 = new int[10][10];
        long ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            int t = cs[i]-'0';
            for(int j=0; j<n; j++){
                suf1[t][j] += suf[j];
            }
            suf[t]++;
        }
        for (int i = 0; i < n; i++) {
            int t = cs[i] - '0';
            suf[t]--;
            for (int j = 0; j < 10; j++) {
                suf1[t][j] -= suf[j];
            }
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans += (long) pre1[j][k] * suf1[j][k];
                }
            }
            for(int j=0; j<n; j++){
                pre1[t][j] += pre[j];
            }
            pre[t]++;


        }
        return  (int)(ans%MOD);
    }
}
