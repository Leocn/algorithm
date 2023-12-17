package com.example.demo.leetcode;

import java.util.*;

public class Week355 {
    public static void main(String[] args) {

    }
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans  = new ArrayList<>();
        for(String w: words){
            StringBuilder sb = new StringBuilder();
            char[] cs = w.toCharArray();
            int loc = 0;
            while (loc<cs.length){
                if(cs[loc]!=separator){
                    sb.append(cs[loc]);
                }else {
                    if(sb.length()>0){
                        ans.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
                loc++;
            }
            if(sb.length()>0){
                ans.add(sb.toString());
            }

        }
        return ans;
    }

    public long maxArrayValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(b,a));
        for (int i = n-1; i >=0 ; i--) {
            if(pq.size()==0){

            }else {
                if(pq.peek()>=nums[i]){
                    long sum = pq.poll()+ nums[i];
                    pq.add(sum);
                }

            }
            pq.add((long)nums[i]);

        }
        return pq.peek();
    }
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = usageLimits.get(i);
        }
        Arrays.sort(arr);
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum>=(ans+2)*(ans+1)/2){
                ans++;
            }
        }
        return (int) ans;


    }
    ArrayList<Integer>[] g ;
    Map<Long,Long> map;
    char[] cs;
    long ans = 0;
    public long countPalindromePaths(List<Integer> parent, String s) {
        long ans = 0;
        int n = parent.size();
        g = new ArrayList[n];
        cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            g[parent.get(i)].add(i);
        }
        map = new HashMap<>();
        map.put(0L,1L);
        dfs(0,0);
        return ans;

    }

    private void dfs(int c, long r){
        List<Integer> list = g[c];
        for(int next:list){
            long a = r | (1L<<(cs[next]-'a'));
            ans += map.getOrDefault(a, 0L);
            for (int i = 0; i < 28; i++) {
                System.out.println(a^(1L<<i));
                ans += map.getOrDefault(a^(1L<<i),0L);
            }
            map.merge(a,1L, Long::sum );
            dfs(next, a);
        }
    }


}
