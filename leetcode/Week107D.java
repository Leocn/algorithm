package com.example.demo.leetcode;

import java.util.*;

public class Week107D {
    public static void main(String[] args) {
        System.out.println(minimizeConcatenatedLength(new String[]{"aa","ab","bc"}));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(words[i].equals(new String(new StringBuilder(words[j]).reverse()))){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int longestString(int x, int y, int z) {


        int ans = 2*z;
        ans += (x==y?x*4 : Math.min(x,y)*2+2);
        return ans;

    }

    public static int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j],0x3f3f3f3f);
            }
        }

        dp[0][words[0].charAt(0)-'a'][words[0].charAt(words[0].length()-1)-'a'] = words[0].length();
        int sum = words[0].length();
        for (int i = 1; i < n; i++) {
            int m = words[i].length();
            char[] cs = words[i].toCharArray();
            sum += m;


            for (int k = 0; k < 26; k++) {
                for (int j = 0; j < 26; j++) {
                    if(cs[m-1]-'a' == j){
                        dp[i][cs[0]-'a'][k] = Math.min(dp[i][cs[0]-'a'][k], m+ dp[i-1][j][k]-1);
                    }else {
                        dp[i][cs[0]-'a'][k] = Math.min(dp[i][cs[0]-'a'][k], m+ dp[i-1][j][k]);
                    }
                }

            }
            for (int k = 0; k < 26; k++) {
                for (int j = 0; j < 26; j++) {
                    if (cs[0] - 'a' == j) {
                        dp[i][k][cs[m - 1] - 'a'] = Math.min(dp[i][k][cs[m - 1] - 'a'], m + dp[i - 1][k][j] - 1);
                    } else {
                        dp[i][k][cs[m - 1] - 'a'] = Math.min(dp[i][k][cs[m - 1] - 'a'], m + dp[i - 1][k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                sum = Math.min(sum, dp[n-1][i][j]);
            }
        }
        return sum;
    }


    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        int[][] arr  = new int[q][2];
        for (int i = 0; i < q; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }
        Arrays.sort(logs, (a,b)->a[1]-b[1]);

        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int loc = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < q; i++) {
            int a = arr[i][0];

            while (loc<logs.length && logs[loc][1]<=a){
                pq.add(new int[]{logs[loc][1], logs[loc][0]});
                int cnt = map.getOrDefault(logs[loc][0],0);
                cnt++;
                map.put(logs[loc][0],cnt);
                loc++;
            }
            while (pq.size()>0 && pq.peek()[0]<a-x ){
                int[] p = pq.poll();
                int cnt = map.getOrDefault(p[1],0);
                cnt--;
                if(cnt==0){
                    map.remove(p[1]);
                }else {
                    map.put(p[1],cnt);
                }
            }
            System.out.println(arr[i][1]);
            ans[arr[i][1]] = n- map.size();

        }
        return ans;


    }

}
