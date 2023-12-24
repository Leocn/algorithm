package com.example.demo.leetcode;

import java.util.*;

public class Week120D {
    public static void main(String[] args) {

    }
    public long incremovableSubarrayCount(int[] nums) {
        long ans = 1;
        int max = (int) 1e9+1;
        int n = nums.length;
        int f = n-1;
        Stack<Integer> stack = new Stack<>();
        stack.push(max);
        while (f>=0){
            if(nums[f]<stack.peek()){
                stack.push(nums[f--]);
                ans++;
            }else {
                break;
            }
        }
        if(stack.size() ==n+1){
            ans -= n+1;
        }
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if(nums[i]<=pre){
                break;
            }
            while (stack.size() > 0 && stack.peek() <= nums[i]) {
                stack.pop();
            }

            ans += stack.size();
            pre = nums[i];
        }
        return ans;


    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = n-1; i >=0; i--) {
            if(nums[i]<sum[i]){
                return sum[i] + nums[i];
            }
        }
        return  -1;
    }
    static long[] ans;
    static int[] costA;
    Map<Integer,List<Integer>> map;
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = edges.length+1;
        ans =  new long[n];
        costA = cost;

        map = new HashMap<>();
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(g, -1, 0);
        dfs1(g, -1, 0);
        return ans;
    }
    private List<Integer> dfs (ArrayList<Integer>[] g, int p, int cur){
        List<Integer> list = new ArrayList<>();
        for(int w:g[cur]){
            if(w!=p){
                List<Integer> res = dfs(g, cur, w);
                if(res.size()>0){
                    for(int r: res){
                        if(list.size()<3){

                            list.add(r);
                            Collections.sort(list);
                        }else {
                            for (int i = 0; i < list.size(); i++) {
                                if(list.get(i)>r){
                                    list.add(i, r);
                                    if(list.size()>3){
                                        list.remove(3);
                                    }
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }
        if(costA[cur]<0){
            if(list.size()<=2){
                list.add(costA[cur]);
                Collections.sort(list);
            }else {
                for (int i = 0; i < 3; i++) {
                    if(list.get(i)>costA[cur]){
                        list.add(i,costA[cur]);
                        list.remove(3);
                        break;
                    }
                }
            }
        }

        map.put(cur, list);

        return list;
    }




    private List<Integer> dfs1(ArrayList<Integer>[] g, int p, int cur){

        List<Integer> list = new ArrayList<>();
        for(int w:g[cur]){
            if(w!=p){
                List<Integer> res = dfs1(g, cur, w);
                if(res.size()>0){
                    for(int r: res){
                        if(list.size()<3){
                            list.add(r);
                            list.sort((a, b) -> b - a);
                        }else {
                            for (int i = 0; i < list.size(); i++) {
                                if(list.get(i)<r){
                                    list.add(i, r);
                                    if(list.size()>3){
                                        list.remove(3);
                                    }
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }
        if(costA[cur]>0){
            if(list.size()<=2){
                list.add(costA[cur]);
                list.sort((a, b) -> b - a);
            }else {
                for (int i = 0; i < 3; i++) {
                    if(list.get(i)<costA[cur]){
                        list.add(i,costA[cur]);
                        list.remove(3);
                        break;
                    }
                }
            }
        }

        List<Integer> pre = map.get(cur);
        if(pre.size() + list.size()<=2){
            ans[cur] = 1;
        }else {
            if((pre.size() == 1 && list.size() == 2) || (list.size()==0)){
                ans[cur] = 0;
            }else {
                long m = 0;
                if(pre.size()>=2){
                    m = (long)pre.get(0) * pre.get(1);
                }
                if(list.size()==1 || list.size()==2){
                    ans[cur] = m *(list.get(0));
                }else {
                    m = Math.max(m, (long)list.get(1)*list.get(2));
                    ans[cur] = m*list.get(0);
                }
            }
        }
        return list;

    }
}
