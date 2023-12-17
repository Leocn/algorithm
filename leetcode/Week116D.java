package com.example.demo.leetcode;

import java.util.*;

public class Week116D {
    public static void main(String[] args) {

    }
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                int c = set.size();
                ans += c*c;
            }

        }
        return ans;
    }

    public int minChanges(String s) {
        int n = s.length();
        int ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i+=2) {
            if(cs[i]!=cs[i+1]){
                ans++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] dp = new int[target+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = nums.get(i);
            int[] d = new int[target+1];
            System.arraycopy(dp, 0, d, 0,target+1);
            for (int j = 0; j <= target-c ; j++) {
                if(dp[j] == -1){
                    continue;
                }
                d[j+c] = Math.max(dp[j] +1, d[j+c]);
            }
            for (int j = 0; j <=target; j++) {
                System.out.println(dp[j]);
            }
            dp = d;
        }

        return  dp[target];
    }

    public int sumCounts(int[] nums) {
        int mod = (int)1e9+7;
        int n = nums.length;
        Set<Integer> map = new HashSet<>();
        long s = 0;
        root = new Node();
        int[] record = new int[(int)1e5+1];
        Arrays.fill(record, n);
        Map<Integer, Integer> loc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.add(nums[i]);
            s += (long)map.size()*map.size();
            update(root, 1, N, i+1, i+1, map.size());
            int a = record[nums[n-i-1]];
            loc.put(n-i-1, a);
            record[nums[n-i-1]] =  n-i-1;
        }

        long ans = s;
        for (int i =1; i < n; i++) {
            int next = loc.getOrDefault(i-1, n);
            long q = query(root, 1, N, i, next);
            s = (s - 2L * q + next-i+1 + mod)%mod;
            ans =  (ans + s)%mod;
            update(root, 1, N, i, next, -1);

        }
        return (int)(ans+mod)%mod;
    }        /**
     线段树模板,区间新增求和查询
     */
    class Node {
        Node left, right;
        long val, add;
    }
    private int N = (int) 1e9;
    private Node root;
    public void update(Node node, int start, int end, int l, int r, long val) {
        if (l <= start && end <= r) {
            node.val += (long)(end - start + 1) * val;
            node.add += val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public long query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        int mid = (start + end) >> 1;
        long ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) ans += query(node.left, start, mid, l, r);
        if (r > mid) ans += query(node.right, mid + 1, end, l, r);
        return ans;
    }
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

}
