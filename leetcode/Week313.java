package com.example.demo.leetcode;

public class Week313 {
    public static void main(String[] args) {
        //System.out.println(minimizeXor(1,2));
        System.out.println(minimizeXor(1,12));
    }

    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a,b); i++) {
            if(a%i==0 && b%i==0){
                ans++;
            }
        }
        return ans;
    }


    public int maxSum(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                int sum = g[i][j] + g[i-1][j-1]+ g[i-1][j] + g[i-1][j+1] +g[i+1][j-1]+ g[i+1][j] + g[i+1][j+1];
                ans = Math.max(ans, sum);

            }
        }
        return ans;
    }


    static public int minimizeXor(int num1, int num2) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if(((num2>>i)&1)==1){
                count++;
            }
        }
        int countA = 0;
        for (int i = 0; i < 32; i++) {
            if(((num1>>i)&1)==1){
                countA++;
            }
        }
        if(count==countA){
            return  0;
        }

        if(count<countA){
            int ans = 0;
            for (int i = 31; i >=0; i--) {
                if(((num1>>i)&1)==1 && count>0){
                    num1 &= ~(1 << i);
                    ans = ans |(1<<i);
                    count--;
                }
            }
            return ans;
        }


        int ans = 0;
        for (int i = 31; i >=0; i--) {
            if(((num1>>i)&1)==1 && count>0){
                //ans &= ~(1 << i);
                ans = ans | (1<<i);
                count--;
            }
        }
        for (int i = 0; i <=31 ; i++) {
            if(((num1>>i)&1)==0 && count>0){
                ans = ans|(1<<i);
                count--;
            }
        }
        return ans;


    }

    /**
     *     Q2430
     *     f[i] i到n可执行的最大删除数量，直接比较会超时，需要预处理
     *      (s.substring(i,i+j).equals(s.substring(i+j, 2*j+i)
     *      dp[i][j] 最长公共前缀
     *      i到j的字符串和j到n 两个字符串的最长公共前缀长度
     * */


    public int deleteString(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] dp = new int[n+1][n+1];
        //dp[i][j] = d[i+1][j+1] + (cs[i]==cs[j]?1:0)
        for(int i=n-1; i>=0; i--){
            for(int j = i-1; j>=0; j-- ){
                if(cs[i]== cs[j]){
                    dp[j][i] = dp[j+1][i+1]+1;
                }
            }
        }
        var f = new int[n];
        for (var i = n - 1; i >= 0; --i) {
            for (var j = 1; i + j * 2 <= n; ++j){
                //等价于(s.substring(i,i+j).equals(s.substring(i+j, 2*j+i)
                if(dp[i][i+j]>=j){
                    f[i] = Math.max(f[i], f[i + j]);
                }
            }
            ++f[i];
        }
        return f[0];
    }
}
