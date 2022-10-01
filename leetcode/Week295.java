package com.example.demo.leetcode;

import java.util.*;

public class Week295 {
    public int rearrangeCharacters(String s, String target) {
        int ans = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> mapCount = new HashMap<>();
        for(char c: target.toCharArray()){
            map.put(c,0);
            mapCount.put(c, mapCount.getOrDefault(c,0)+1);
        }

        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
        }

        for(Map.Entry<Character, Integer> characterIntegerEntry: mapCount.entrySet()){
            ans = Math.min(map.get(characterIntegerEntry.getKey())/characterIntegerEntry.getValue(), ans);
        }
        return ans;
    }

    public String discountPrices(String sentence, int discount) {
        String[] strArray = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String s: strArray){
            if(s.length()>1 && s.lastIndexOf("$") ==0 && !s.matches(".*[a-z].*")){

                double in = Double.parseDouble(s.replace("$",""));
                System.out.println(in);
                in *= (double) (100 - discount) /100;
                s = "$" + String.format("%.2f", in);
            }
            ans.append(s).append(" ");
        }
        return new String(ans.substring(0,ans.length()-1));
    }

    public int totalSteps(int[] nums) {
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<nums.length; i++){
            int max = 0;
            while(!stack.isEmpty() && stack.peek()[0]<= nums[i]){
                max = Math.max(max,stack.pop()[1]);
            }
            if(!stack.isEmpty()){
                max ++;
            }
            ans = Math.max(ans, max);
            stack.push(new int[]{ nums[i], max});
        }
        return ans;
    }

    int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] record = new int [m][n];
        for(int[] r: record){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        record[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0});
        while (!deque.isEmpty()){
            int[] p = deque.poll();
            for(int[] dir: dirs){
                int x = p[0]+dir[0], y = p[1]+dir[1];
                if(x<0 || x>=n || y<0 || y>=m){ continue;}
                if(record[p[0]][p[1]]+ grid[x][y]< record[x][y]){
                    record[x][y]  = record[p[0]][p[1]]+ grid[x][y];
                    deque.add(new int[]{x,y});
                }
            }
        }

        return record[m-1][n-1];
    }
}
