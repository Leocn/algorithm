package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Week289 {
    public static void main(String[] args) {
        System.out.println(digitSum("1234",2));
    }
    public static String digitSum(String s, int k) {
        String ans = s;
        while(ans.length()>k){
            int l = ans.length();
            String tem ="";
            for(int i=0; i<=l/k-(l%k==0?1:0); i++){
                String sb = ans.substring(k*(i),Math.min(l, k*(i+1)));
                char[] cs = sb.toCharArray();
                int sum =0;
                for(char c: cs){
                    sum += c-'0';

                }
                tem +=  sum+"";

            }
            ans = tem;
        }

        return ans;
    }


    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t: tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int v = e.getValue();
            if(v ==1){
                return  -1;
            }
            while(v>3){
                ans ++;
                v -=3;
            }
            if(v==1 || v==2){
                ans ++;
            }
        }
        return ans;
    }

    public int maxTrailingZeros(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][][] rec1 = new  int[m][n][2];
        int[][][] rec2 = new  int[m][n][2];
        int[][][] rec3 = new  int[m][n][2];
        int[][][] rec4 = new  int[m][n][2];
        for(int i =0;i<m; i++){
            for(int j =0; j<n;j++){
                int count2 =0;
                int count5 =0;
                int data = grid[i][j];
                while (data%2==0){
                    data /= 2;
                    count2++;
                }
                while (data%5==0){
                    data /= 5;
                    count5++;
                }
                rec1[i][j][0] = count2 + (j>0? rec1[i][j-1][0]:0);
                rec1[i][j][1] = count5 + (j>0? rec1[i][j-1][1]:0);
                ans = Math.max(ans, Math.min(rec1[i][j][0], rec1[i][j][1]));

                rec3[i][j][0] = count2 + (i>0? rec3[i-1][j][0]:0);
                rec3[i][j][1] = count5 + (i>0? rec3[i-1][j][1]:0);
                ans = Math.max(ans, Math.min(rec3[i][j][0], rec3[i][j][1]));
            }
        }

        for(int i =0;i<m; i++) {
            for (int j = 0; j < n; j++) {
                rec2[i][j][0] = rec1[i][n-1][0]- (j==0?0:rec1[i][j-1][0]);
                rec2[i][j][1] = rec1[i][n-1][1]- (j==0?0:rec1[i][j-1][1]);

                rec4[i][j][0] = rec3[m-1][j][0]- (i==0?0:rec3[i-1][j][0]);
                rec4[i][j][1] = rec3[m-1][j][1]- (i==0?0:rec3[i-1][j][1]);
            }
        }


        for(int i =0;i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(j>0){
                    if(i>0){
                        ans = Math.max(ans, Math.min(rec1[i][j-1][0] +  rec3[i][j][0], rec1[i][j-1][1] +  rec3[i][j][1]));
                    }
                    if(i<m-1){
                        ans = Math.max(ans, Math.min(rec1[i][j-1][0] +  rec4[i][j][0], rec1[i][j-1][1] +  rec4[i][j][1]));
                    }

                }
                if(j<n-1){
                    if(i>0){
                        ans = Math.max(ans, Math.min(rec2[i][j+1][0] +  rec3[i][j][0], rec2[i][j+1][1] +  rec3[i][j][1]));
                    }
                    if(i<m-1){
                        ans = Math.max(ans, Math.min(rec2[i][j+1][0] +  rec4[i][j][0], rec2[i][j+1][1] +  rec4[i][j][1]));
                    }

                }

            }
        }





        return ans;
    }
}
