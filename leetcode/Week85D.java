package com.example.demo.leetcode;

import java.util.*;

public class Week85D {
    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences("0110101"));
        System.out.println(shiftingLetters( "abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
        System.out.println(Arrays.toString(maximumSegmentSum(new int[]{1, 2, 5, 6, 1}, new int[]{0, 3, 2, 4, 1})));
    }
    public int minimumRecolors(String blocks, int k) {
        char[] cs = blocks.toCharArray();
        int n = cs.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            if(cs[i-1]=='B'){
                sum[i] = sum[i-1]+1;
            }else {
                sum[i] = sum[i-1];
            }
        }
        int ans = 0;
        for (int i = 0; i <= n-k; i++) {
            ans = Math.max(ans, sum[i+k]-sum[i]);
        }
        return k-ans;
    }


    public static int secondsToRemoveOccurrences(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        boolean flag = false;
        while(true){
            flag = false;
            for (int i = 0; i <n-1 ; i++) {
                if(cs[i]=='0'  && cs[i+1]== '1'){
                    cs[i]='1';
                    cs[i+1]='0';
                    flag = true;
                    i++;
                }
            }
            if(flag){
                ans++;
            }else {
                break;
            }
        }

        return ans;

    }
    static Map<Integer,Character> map;
    static {
        map = new HashMap<>();
        map.put(0,'a');
        map.put(1,'b');
        map.put(2,'c');
        map.put(3,'d');
        map.put(4,'e');
        map.put(5,'f');
        map.put(6,'g');
        map.put(7,'h');
        map.put(8,'i');
        map.put(9,'j');
        map.put(10,'k');
        map.put(11,'l');
        map.put(12,'m');
        map.put(13,'n');
        map.put(14,'o');
        map.put(15,'p');
        map.put(16,'q');
        map.put(17,'r');
        map.put(18,'s');
        map.put(19,'t');
        map.put(20,'u');
        map.put(21,'v');
        map.put(22,'w');
        map.put(23,'x');
        map.put(24,'y');
        map.put(25,'z');
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] ans = new int[n+1];
        for(int[] b: shifts){
            if(b[2]==0){
                b[2]=-1;
            }

            ans[b[0]] += b[2];
            ans[b[1]+1] -= b[2];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = cs[i]-'a';
        }
        StringBuilder sb = new StringBuilder();
        res[0] += ans[0];
        sb.append(map.get((res[0]+260000)%26));
        for(int i=1; i<n; i++){
            ans[i] += ans[i-1];
            res[i] += ans[i];
            sb.append(map.get((res[i]+260000)%26));
        }

        return sb.toString();

    }



    static int[] nums;
    static int n;

    /**
     * 解法1 堆
     * */
    public static long[] maximumSegmentSum(int[] _nums, int[] removeQueries) {
        nums = _nums;
        n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] += sum[i] + nums[i];
        }
        set.add(-1);
        set.add(n);
        long[] ans = new long[removeQueries.length];
        Map<Long, Integer> mm = new HashMap<>();
        mm.put( sum[n],1);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((a,b)-> Long.compare(b, a));
        priorityQueue.add(sum[n]);
        for (int i = 0; i < removeQueries.length; i++) {
            int index  = removeQueries[i];

            int l = set.lower(index), r = set.higher(index);
            // 新的左边子段和[l+1,idx-1]
            if (l + 1 <= index - 1) {
                long before = sum[index] - sum[l + 1];
                priorityQueue.add(before);
                mm.put(before,mm.getOrDefault(before ,0)+1);

            }
            if (index + 1 <= r - 1) {
                long last = sum[r] - sum[index + 1];
                priorityQueue.add(last);
                mm.put(last,mm.getOrDefault(last ,0)+1);

            } // 新的右边子段和[idx+1,r-1]


            set.add(index);
            long aa = sum[r]-sum[l+1];
            mm.put(aa, mm.get(aa)-1);
            set.add(index);
            while(mm.containsKey( priorityQueue.peek()) && mm.get(priorityQueue.peek())==0){
                priorityQueue.poll();
            }
            ans[i] = priorityQueue.size()>0?priorityQueue.peek():0;

        }
        return ans;
    }


    /**
     * 解法2
     * TODO
     * */
    static int[] fa;
    public static long[] maximumSegmentSum2(int[] nums, int[] removeQueries) {
//        int m = removeQueries.length;
//        int n = nums.length;
//        long[] ans = new long[m];
//        int[] copy = Arrays.copyOf(removeQueries,removeQueries.length);
//        for (int i = 0; i < n; i++) {
//            fa[i] = i;
//        }
//        Arrays.sort(copy);
//        int s = 0;
//        for (int i = 0; i < m; i++) {
//            while (removeQuerie)
//        }
        return null;



    }



}
