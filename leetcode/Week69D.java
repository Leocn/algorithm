package com.example.demo.leetcode;

import java.util.*;

public class Week69D {
    public static void main(String[] args) {

    }

    public String capitalizeTitle(String title) {
        String[] strs = title.split(" ");

        for(int i=0;i<strs.length;i++){
            strs[i] = strs[i].toLowerCase();
            if(strs[i].length()>2){
                strs[i] = strs[i].substring(0,1).toUpperCase() + strs[i].substring(1);
            }
        }
        return String.join(" ", strs);
    }

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        List<Integer> destList = new ArrayList<Integer>(list);
        Collections.reverse(destList);
        int res =0;
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, list.get(i) + destList.get(i));
        }
        return res;
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(String word: words){
            String r = new String(new char[]{word.charAt(1), word.charAt(0)});
            if(!map.containsKey(word) && !map.containsKey(r)){
                map.put(word,1);
                continue;
            }
            int d = map.getOrDefault(r,0);
            if(d >0){
                res +=2;
                map.put(r, d-1);
                continue;
            }
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for (String key : map.keySet()) {
            Integer value = map.get(key);
            if (value > 0 && key.charAt(0) == key.charAt(1)) {
                res += 2;
            }
        }
        return res;
    }

    /**
     * 判断每个格子是否周围长度是否超出 height width
     * */
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sums = new int[m+1][n+1];
        int[][] diffs = new int[m+2][n+2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + grid[i-1][j-1];
            }
        }
        //二维差分数组，最后他们的前缀和用于还原格子是否能被贴
        for (int i = stampHeight; i <= m ; i++) {
            for (int j = stampWidth; j <=n ; j++) {
                int x = sums[i][j] - sums[i - stampHeight][j] - sums[i][j - stampWidth] + sums[i - stampHeight][j - stampWidth];
                if(x==0){
                    diffs[i - stampHeight + 1][j - stampWidth + 1]++;
                    diffs[i - stampHeight + 1][j + 1]--;
                    diffs[i + 1][j - stampWidth + 1]--;
                    diffs[i + 1][j + 1]++;
                }
            }
        }

        //还原
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                diffs[i][j] += diffs[i - 1][j] + diffs[i][j - 1] - diffs[i - 1][j - 1];
                if(grid[i-1][j-1] == 1) continue;
                if(diffs[i][j]==0){
                    return false;
                }
            }
        }

        return true;
    }
}
