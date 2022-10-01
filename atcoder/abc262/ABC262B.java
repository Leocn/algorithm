package com.example.demo.atcoder.abc262;

import java.util.Scanner;

public class ABC262B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int m =scanner.nextInt();

        int[] sum = new int[n+1];
        int[] right = new int[n+1];
        int[][] s = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            s[x][y] =1;
        }
        long ans = 0;
        for(int i=1; i<=n; i++){

            for (int j = 1; j <=n; j++) {
                if(s[i][j]==1){
                    for (int k = 1; k <=n ; k++) {
                        if(s[j][k]==1 && s[i][k]==1){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
