package com.example.demo.leetcode;

import com.example.demo.codeforces.ctr2.A;

import java.util.*;

public class Week308 {
    public static void main(String[] args) {

    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] sum  = new int[n+1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = 1;
            while (sum[start]<=queries[i]){
                start++;
            }
            ans[i] = start-1;
        }
        return ans;

    }

    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: arr){
            if(c=='*'){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size()>0){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        int[] loc = new int[3];

        for (int i = 0; i < n; i++) {
            String str = garbage[i];
            for(char c: str.toCharArray()){
                if(c=='M'){
                    while(loc[0]<i){
                        ans += travel[loc[0]];
                        loc[0]++;
                    }
                }else if(c=='P'){
                    while(loc[1]<i){
                        ans += travel[loc[1]];
                        loc[1]++;
                    }

                }else if(c=='G'){
                    while(loc[2]<i){
                        ans += travel[loc[2]];
                        loc[2]++;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        Map<Integer,Integer> map1=  new HashMap<>();

        List[] arr=  new List[k+1];
        for (int i = 1; i <= k; i++) {
            arr[i] = new ArrayList();
        }
        int[] sum = new int[k+1];
        for(int[] row: rowConditions){
            int a = row[0], b = row[1];
            arr[a].add(b);
            sum[b]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if(sum[i]==0){
                deque.add(i);
            }
        }
        int count = 0;
        while (deque.size()>0){
            int p = deque.poll();
            map1.put(p, count);
            count++;
            List<Integer> list = arr[p];
            for(int next : list){
                sum[next]--;
                if(sum[next]==0){
                    deque.add(next);
                }
            }

        }
        for (int i = 1; i <=k; i++) {
            if(sum[k]>0){
                return new int[0][0];
            }
        }


        Map<Integer,Integer> map2=  new HashMap<>();
        arr=  new List[k+1];
        for (int i = 1; i <= k; i++) {
            arr[i] = new ArrayList();
        }
        sum = new int[k+1];
        for(int[] row: colConditions){
            int a = row[0], b = row[1];
            arr[a].add(b);
            sum[b]++;
        }
        deque = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if(sum[i]==0){
                deque.add(i);
            }
        }
        count = 0;
        while (deque.size()>0){
            int p = deque.poll();
            map2.put(p, count);
            count++;
            List<Integer> list = arr[p];
            for(int next : list){
                sum[next]--;
                if(sum[next]==0){
                    deque.add(next);
                }
            }

        }
        for (int i = 1; i <=k; i++) {
            if(sum[k]>0){
                return new int[0][0];
            }
        }
        for (int i = 1; i <= k; i++) {
            ans[map1.get(i)][map2.get(i)] = i;
        }
        return ans;
    }
}
