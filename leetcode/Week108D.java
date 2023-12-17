package com.example.demo.leetcode;

import java.util.*;

public class Week108D {
    public static void main(String[] args) {

    }
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length-1; i++) {
            int loc = i;
            if(nums[i+1]-nums[i]==1){
                int c = -1;
                loc = i+1;
                while (loc+1<nums.length && nums[loc+1]-nums[loc] == c){
                    loc++;
                    c*=-1;
                }
                ans = Math.max(ans,loc-i);
            }
        }
        return ans;
    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<Integer>();

        for(int n: nums){
            set.add(n);
        }
        for(int i=0; i<moveFrom.length; i++){
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;

    }
    Set<String> set = new HashSet<>();
    int ans = Integer.MAX_VALUE;
    String s ;
    public int minimumBeautifulSubstrings(String s) {
        this.s = s;
        int a = 1;
        for (int i = 1; i < 10; i++) {
            set.add(Integer.toBinaryString(a));
            a*=5;
            System.out.println(Integer.toBinaryString(a));
        }
        dfs(0,0);

        return  ans ==Integer.MAX_VALUE?-1:ans;

    }
    private void dfs(int x, int y){
        if(x==s.length()){
            ans = Math.min(y, ans);
            return;
        }
        for (int i = x; i < s.length(); i++) {
            if(set.contains(s.substring(x,i+1))){
                dfs(i+1, y+1);
            }
        }
    }
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] ans = new long[5];
        ans[0] = (long)(m-1)*(n-1);
        Set<String> set = new HashSet<>();
        for(int[] c: coordinates){
            set.add(c[0] +"_"+c[1]);
        }

        HashSet<String>[] arr  = new HashSet[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new HashSet<>();
        }
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] c: coordinates){

            out:for (int i = 0,x=0; i < 4; i++,x++) {
                int cnt = 1;
                int sx = c[0], sy = c[1];
                if(arr[x].contains(c[0] +"_" + c[1] )){
                    continue;
                }
                arr[x].add(c[0] +"_" + c[1] );
                for (int j = x; j <x+3 ; j++) {
                    int mod = j%4;
                    int nx = sx+dirs[mod][0];
                    int ny  = sy +dirs[mod][1];
                    if(nx<0 || nx>=m  || ny<0 || ny>=n){
                        continue out;
                    }
                    if(arr[(j+1)%4].contains(nx + "_"+ ny)){
                        continue out;
                    }
                    arr[(j+1)%4].add(nx + "_"+ ny);
                    if(set.contains(nx + "_"+ ny)){
                        cnt++;
                    }
                    sx = nx;
                    sy = ny;
                }
                ans[0]--;
                ans[cnt]++;


            }

        }
        return ans;
    }

}
