package com.example.demo.leetcode;

import java.util.*;

public class Week377 {
    public static void main(String[] args) {

    }

    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[n];
        for (int i = 0; i < n; i+=2) {
            ans[i+1] = nums[i];
            ans[i] = nums[i+1];
        }
        return ans;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        h.add(1);
        for(int f: hFences){
            h.add(f);
        }
        h.add(m);
        v.add(1);
        for(int f: vFences){
            v.add(f);
        }
        v.add(n);
        long ans = 0;
        int mod = (int)1e9+7;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i+1; j < h.size(); j++) {
                set.add(h.get(j)- h.get(i));
            }
        }

        for (int i = 0; i < v.size(); i++) {
            for (int j = i+1; j < v.size(); j++) {
                int a = v.get(j)-v.get(i);
                if(set.contains(a)){
                    ans = Math.max(ans, a);
                }
            }
        }
        if(ans == 0){
            return  -1;
        }
        return (int)(ans*ans%mod);
    }

    /**
     * floyd 算法
     * @param source
     * @param target
     * @param original
     * @param changed
     * @param cost
     * @return
     */
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dp = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if(i!=j){
                    dp[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }
        int m = original.length;
        for (int i = 0; i < m; i++) {
            int a = original[i]-'a';
            int b = changed[i]-'a';
            dp[a][b] = Math.min(dp[a][b], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        int n = source.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = source.charAt(i)-'a';
            int b = target.charAt(i)-'a';
            if(dp[a][b] == Integer.MAX_VALUE/10){
                return -1;
            }
            ans += dp[a][b];
        }
        return ans;
    }




    class Node {
        Node[] son = new Node[26];
        //标记他是哪个字符串的
        int sid = -1;
    }
    static int[][] dis;
    static int m;
    static Node root;
    static int sid;
    static char[] s;
    static char[] t;
    static long[] memo;

    /***
     * floyd + 记忆化搜索 + 字典树
     * @param source
     * @param target
     * @param original
     * @param changed
     * @param cost
     * @return
     */
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        m = cost.length;
        root = new Node();
        dis = new int[2*m][2*m];
        sid = 0;
        for(int[] d: dis){
            Arrays.fill(d, Integer.MAX_VALUE/2);
        }
        for (int i = 0; i < m; i++) {
            int x = put(original[i]);
            int y = put(changed[i]);
            dis[x][y] = Math.min(dis[x][y], cost[i]);
        }
        for (int k = 0; k < sid; k++) {
            for (int i = 0; i < sid; i++) {
                for (int j = 0; j < sid; j++) {
                    dis[i][j] = Math.min(dis[i][k] + dis[k][j], dis[i][j]);
                }
            }
        }
        s = source.toCharArray();
        t = target.toCharArray();
        int n = s.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            // 不修改 source[i]
            f[i] = s[i] == t[i] ? f[i + 1] : Long.MAX_VALUE / 2;
            Node p = root, q = root;
            for (int j = i; j < n; j++) {
                p = p.son[s[j] - 'a'];
                q = q.son[t[j] - 'a'];
                if (p == null || q == null) {
                    break;
                }
                if (p.sid < 0 || q.sid < 0) {
                    continue;
                }
                // 修改从 i 到 j 的这一段
                int d = dis[p.sid][q.sid];
                if (d < Integer.MAX_VALUE / 2) {
                    f[i] = Math.min(f[i], d + f[j + 1]);
                }
            }
        }
        return f[0] < Long.MAX_VALUE / 2 ? f[0] : -1;

    }

    public long dfs(int loc){
        if(loc>=s.length){
            return 0;
        }
        if (memo[loc] != -1) { // 之前算过
            return memo[loc];
        }
        long res = Long.MAX_VALUE / 2;
        if (s[loc] == t[loc]) {
            res = dfs(loc + 1); // 不修改 source[i]
        }
        Node p = root, q = root;
        for (int j = loc; j < s.length; j++) {
            p = p.son[s[j] - 'a'];
            q = q.son[t[j] - 'a'];
            if (p == null || q == null) {
                break;
            }
            if (p.sid < 0 || q.sid < 0) {
                continue;
            }
            // 修改从 i 到 j 的这一段
            int d = dis[p.sid][q.sid];
            if (d < Integer.MAX_VALUE / 2) {
                res = Math.min(res, d + dfs(j + 1));
            }
        }
        return memo[loc] = res; // 记忆化
    }

    public int put(String s){
        char[] cs = s.toCharArray();
        Node node = root;
        for(char c: cs){
            int w = c-'a';
            if(node.son[w] == null){
                node.son[w] = new Node();
            }
            node = node.son[w];
        }
        if(node.sid<0){
            node.sid = sid++;
        }
        return node.sid;
    }


}
