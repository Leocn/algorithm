package com.example.demo.codeforces.ecf135;

import java.util.Scanner;

public class D {
    /**
     *  dp[i][j] A是否能获胜
     *  dp[i][j] 和
     * */
    public static void main(String[] args) {
        var scanner=new Scanner(System.in);
        var t=scanner.nextInt();
        while(t-->0){
            var cs = scanner.next().toCharArray();
            var n = cs.length;
            var dp = new int[n+2][n+2];
            //长度遍历
            for (int i = 2; i <=n ; i+=2) {
                if(i==2){
                    for (int j = 1; j+1<=n ; j++) {
                        if(cs[j]!=cs[j-1]){
                            dp[j][j+1] = 1;
                        }
                    }

                    continue;
                }
                for (int j = 1; j+i-1<=n ; j++) {
                    int right =  j+i-1;
                    dp[j][right] = 0;

                    if(dp[j+1][right-1]==1 &&  dp[j+2][right] ==1 ){
                        dp[j][right] =1;
                        continue;
                    }

                    if(dp[j+1][right-1]==1 &&dp[j][right-2] ==1){
                        dp[j][right] =1;
                        continue;
                    }


                    if(dp[j+1][right-1]==1 &&dp[j+2][right] ==0 ){
                        if(cs[j]> cs[j-1]){
                            dp[j][right] =1;
                            continue;
                        }
                    }


                    if(dp[j+1][right-1]==0 &&dp[j+2][right] ==1 ){
                        if(cs[j-1]< cs[right-1]){
                            dp[j][right] =1;
                            continue;
                        }
                    }

                    if(dp[j+1][right-1]==0 &&dp[j+2][right] ==0 ){
                        if(cs[j-1]< cs[right-1] && cs[j-1]< cs[j] ){
                            dp[j][right] =1;
                            continue;
                        }
                    }


                    if(dp[j+1][right-1]==1 &&dp[j][right-2] ==0){
                        if(cs[right-2]> cs[right-1]){
                            dp[j][right] =1;
                            continue;
                        }
                    }
                    if(dp[j+1][right-1]==0 &&dp[j][right-2] ==1){
                        if(cs[j-1]> cs[right-1]){
                            dp[j][right] =1;
                            continue;
                        }
                    }

                    if(dp[j+1][right-1]==0 &&dp[j][right-2] ==0){
                        if(cs[right-2]> cs[right-1] && cs[j-1]> cs[right-1]){
                            dp[j][right] =1;
                            continue;
                        }
                    }

                }
            }
            System.out.println(dp[1][n]==0?"Draw":"Alice");

        }
    }
}
