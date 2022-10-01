package com.example.demo.leetcode;

import java.util.*;
public class Week73D {
    public static void main(String[] args) {
        System.out.println(sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{9,99,999,9999,999999999}));
        System.out.println(halveArray(new int[]{4,9}));
        System.out.println(maximumBobPoints(3, new int[]{0,0,1,0,0,0,0,0,0,0,0,2}));
    }

    public int mostFrequent(int[] nums, int key) {
        int ans =0;
        int max =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] ==key){
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
            }

        }
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue()>max){
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;

    }


    public static int[] sortJumbled(int[] mapping, int[] nums) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]-o2[1]==0){
                    return o1[2]-o2[2];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        int count=0;
        for(int num: nums){
            int record = 0;
            int tem = num;
            int f = 1;
            while(num>10){

                record += mapping[num%10] * f;
                num = num/10;
                f *=10;
            }
            record += mapping[num]*f;
            queue.add(new int[]{tem, record,count});
            count++;

        }
        int[] ans = new int[nums.length];
        int f = 0;
        while (!queue.isEmpty()){
            ans[f] = queue.poll()[0];
            f++;
        }
        return ans;


    }


    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inc = new int[n];
        Set[] res = new Set[n];
        for(int i = 0; i<res.length; i++){
            res[i] = new TreeSet() ;
        }
        //出度
        List[] ou = new List[n];
        for(int i = 0; i<ou.length; i++){
            ou[i] = new ArrayList();
        }
        for(int[] ed: edges){
            inc[ed[1]] ++;
            ou[ed[0]].add(ed[1]);
        }
        Queue<Integer> queue =new LinkedList<>();
        for(int i=0; i< n; i++){
            if(inc[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int pp = queue.poll();
            List<Integer> list = ou[pp];
            for(int ll : list){
                res[ll].add(pp);
                res[ll].addAll(res[pp]);
                inc[ll]--;
                if(inc[ll]==0){
                    queue.add(ll);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<res.length; i++){
            List<Integer> l = new ArrayList<>(res[i]);
            ans.add(l);
        }
        return ans;
    }


    public int minMovesToMakePalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1)) {
                return i + minMovesToMakePalindrome(s.substring(0, i) + s.substring(i + 1, s.length() - 1));
            } else if (s.charAt(s.length() - 1 - i) == s.charAt(0)) {
                return i + minMovesToMakePalindrome(s.substring(1, s.length() - 1 - i) + s.substring(s.length() - i));
            }
        }
        return 0;

    }

    static int N = 100010, M = N * 2;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] f = new int[N];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(he, -1);
        int n = parents.length;
        for (int i = 1; i < n; i++) add(parents[i], i);
        dfs(0);
        long max = 0;
        int ans = 0;
        for (int x = 0; x < n; x++) {
            long cur = 1;
            for (int i = he[x]; i != -1; i = ne[i]) cur *= f[e[i]];
            if (x != 0) cur *= n - f[x];
            if (cur > max) {
                max = cur; ans = 1;
            } else if (cur == max) {
                ans++;
            }
        }
        return ans;
    }
    int dfs(int u) {
        int ans = 1;
        for (int i = he[u]; i != -1; i = ne[i]) ans += dfs(e[i]);
        f[u] = ans;
        return ans;
    }



    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
            }else {
                set.remove(num);
            }
        }
        return  set.size()==0;
    }


    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);
        int n = text.length();
        long[] re = new long[n+1];
        long[] re2= new long[n+1];

        long sumA = 0;
        long sumB = 0;
        int count  = 1;
        for(char c: text.toCharArray()){
            if(c==a){
                sumA++;
            }else if(c ==b){
                sumB++;
            }
            re[count] = sumA;
            re2[count] = sumB;
            count++;
        }
        long ans =0;
        for(int i=1; i<=n; i++){
            ans += re[i] * (re2[n]-re2[i]);
        }
        long s = 0;
        for (int i = 0; i <=n ; i++) {
            s = Math.max(s, re2[n]-re2[i]);
            s = Math.max(s, re[i]);
        }
        return  ans +s;

    }


    public static int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<Double>(
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2>=o1?1:-1;
                    }
                }
        );
        long sum = 0;
        for(int num: nums){
            queue.add((double)num);
            sum += num;
        }
        double l = 0;
        int count = 0;
        double d = (double)sum/2;
        while (l<d){
            double p = queue.poll();
            l += p/2;
            queue.add(p/2);
            count++;
        }

        return count;


    }


    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int ans = 0;
        int max = 4096-1;
        int[] res = new int[12];
        for(int i=max; i>=1;i--){
            String ss = Integer.toBinaryString(i);
            int sum = 0;
            int[] temp = new int[12];
            int points = 0;
            char[] ch = ss.toCharArray();
            for(int j=12-ch.length; j<=11; j++){
                if(ch[j-(12-ch.length)]-'0'>0){
                    sum += aliceArrows[j]+1;
                    temp[j] = aliceArrows[j]+1;
                    points += j;
                }
            }
            if(sum<=numArrows){
                if(points>ans) {
                    ans = points;
                    res = temp;
                }

            }
        }
        return res;
    }
}
