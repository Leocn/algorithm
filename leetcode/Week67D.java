package com.example.demo.leetcode;

import java.util.*;

public class Week67D {
    public static void main(String[] args) {
        System.out.println(maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            list.add(nums[i]);
            if(q.size()>k){list.remove(q.poll());}

        }

       return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int length = security.length;

        if(time==0) {
            for (int i = 0; i < length; i++) {
                res.add(i);
            }
            return res;
        }
        int[] big = new int[length];
        int[] small = new int[length];
        int b = 0;
        int s = 0;
        for (int i = 1; i < length; i++) {
            if(security[i]-security[i-1]<=0){
                s++;
            }else {
                s=0;
            }

            small[i]=s;
        }

        for (int i = length-2; i >=0 ; i--) {
            if(security[i+1]-security[i]>=0){
                b++;
            }else {
                b=0;
            }
            big[i]=b;
        }

        
        for (int i = 0; i < length-time; i++) {
            if(small[i]>=time && big[i]>=time){
                res.add(i);
            }
        }
        return res;
    }

    static int res = 0;
    static Map<Integer,List<Integer>> map;

    public static int maximumDetonation(int[][] bombs) {
        map =new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if( Math.pow(bombs[i][0]- bombs[j][0],2) + Math.pow(bombs[i][1]- bombs[j][1],2) <= Math.pow(bombs[i][2],2)){
                    List<Integer> a = map.getOrDefault(i, new ArrayList<>());
                    a.add(j);
                    map.put(i,a);
                }
            }
        }

        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
            res=  Math.max(res,dfs(entry.getKey(), entry.getValue()));
        }
        return res;

    }
    private static int dfs(Integer a , List<Integer> list){
        boolean[] uesEd = new boolean[120];
        Set<Integer> set = new HashSet<>();
        set.add(a);
        uesEd[a] = true;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            q.add(list.get(i));
        }
        while (!q.isEmpty()){
            int ppp = q.poll();
            set.add(ppp);
            List<Integer> temp = map.get(ppp);
            if(temp==null){continue;}
            for (int i = 0; i < temp.size(); i++) {
                if(!uesEd[temp.get(i)]){
                    q.add(temp.get(i));
                }
            }
        }
        return set.size();

    }


//    class SORTracker {
//        int now = 1;
//        int nowScore = -1;
//        TreeMap<Integer, PriorityQueue<String>> map;
//        int[] count = new int[10002];
//        public SORTracker() {
//            //queue = new PriorityQueue<>();
//            map = new TreeMap<>();
//        }
//
//        public void add(String name, int score) {
//
//            //queue.add(new Place(name,score));
//            count[score]++;
//            PriorityQueue<String> q = map.getOrDefault(score, new PriorityQueue<>() );
//            q.add(name);
//            map.put(score, q);
//            if(score> nowScore){
//                so
//            }
//            map.floorKey()
//        }
//
//        public String get() {
//
//            String res  = map.get(now).peek();
//            now++;
//            return res;
//        }
//
//        public class Place{
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            String name;
//
//            public Integer getScore() {
//                return score;
//            }
//
//            public void setScore(Integer score) {
//                this.score = score;
//            }
//
//            Integer score;
//            public Place(String name, Integer score){
//                this.name = name;
//                this.score = score;
//            }
//        }
//
//    }
}
