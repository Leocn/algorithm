package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Week303 {
    public static void main(String[] args) {

    }
    public char repeatedCharacter(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: cs){
            map.put(c, map.getOrDefault(c, 0) +1);
            int dd = map.get(c);
            if(dd==2){
                return c;
            }
        }
        return 'a';
    }


    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        for(int i=0;i<n; i++ ){

            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if(grid[i][k]!= grid[k][j]){
                        break;
                    }
                }
                if(flag){
                    ans++;
                }
            }
        }
        return ans;
    }


}
