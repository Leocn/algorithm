package com.example.demo.leetcode;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Week309 {
    public static void main(String[] args) {
        System.out.println(checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(numberOfWays(989,1000,99));
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
    }

    public static boolean checkDistances(String s, int[] distance) {
        int[] ans = new int[26];
        char[] arr = s.toCharArray();
        Arrays.fill(ans,-1);
        for (int i = 0; i < arr.length; i++) {
            if(ans[arr[i]-'a']==-1){
                ans[arr[i]-'a'] = i;
            }else {
                ans[arr[i]-'a'] = i - ans[arr[i]-'a']-1 ;
            }

        }
        for (int i = 0; i < 26; i++) {
            if(ans[i]!=-1 &&ans[i]!=distance[i]){
                return false;
            }
        }
        return true;


    }


    public static int numberOfWays(int startPos, int endPos, int k) {

        long M = (long) (1e9+7);
        int d = Math.abs(endPos-startPos);
        if(k<d){
            return 0;
        }
        if((k-d)%2==1){
            return 0;
        }
//        long ans = 1;
        BigInteger ans = new BigInteger("1");
        for (int i = 0; i < (k-d)/2; i++) {
            ans = ans.multiply( new BigInteger(k-i +""));
            ans = ans.divide( new BigInteger(i+1 +""));


        }

        BigInteger[] an = ans.divideAndRemainder(new BigInteger(1000000007+""));


        return an[1].intValue() ;
    }


    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[] count = new int[32];

        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            String str = Integer.toBinaryString(nums[right]);
            for (int i =str.length()-1; i>=0  ; i--) {
                if(str.charAt(i)=='1'){
                    count[str.length()-i+1]++;
                }
            }
            boolean flag = false;

            while (!flag){
                boolean in = true;
                for (int j = 0; j < 32; j++) {
                    if (count[j] > 1) {
                        in = false;
                        String dd = Integer.toBinaryString(nums[left]);
                        for (int i = dd.length() - 1; i >= 0; i--) {
                            if (dd.charAt(i) == '1') {
                                count[dd.length()-i+1]--;
                            }
                        }
                        left++;
                        break ;
                    }
                }

                if(in){
                    flag =true;
                }

            }
            ans = Math.max(ans,right-left+1);



        }
        return ans;
    }


    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        // 记录会议室
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            que.add(i);
        }
        Arrays.sort(meetings, (a, b)->a[0] - b[0]);
        // 记录延期的meeting
        PriorityQueue<int[]> queWaitingMeeting = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //记录进行中的meeting
        PriorityQueue<int[]> queDoingMeeting = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        for(int[] m: meetings){
            //先解锁过期会议,并处理到等待队列
            while(queDoingMeeting.size()>0 && queWaitingMeeting.size()>0 && queDoingMeeting.peek()[0]<= m[0]){
                int[] poll = queDoingMeeting.poll();
                int loc = poll[1];
                int end = poll[0];
                int[] waitingTime = queWaitingMeeting.poll();
                queDoingMeeting.add(new int[]{end+ waitingTime[1]-waitingTime[0],loc});
                ans[loc]++;
            }
            // 解锁过期会议
            while(queDoingMeeting.size()>0 && queDoingMeeting.peek()[0]<= m[0]){
                que.add(queDoingMeeting.poll()[1]);
            }
            if(que.size()>0){
                int loc = que.poll();
                queDoingMeeting.add(new int[]{m[1],loc});
                ans[loc]++;
            }else{
                queWaitingMeeting.add(m);
            }

        }

        while(queWaitingMeeting.size()>0){
            int[] poll = queDoingMeeting.poll();
            int loc = poll[1];
            int end = poll[0];
            int[] waitingTime = queWaitingMeeting.poll();
            queDoingMeeting.add(new int[]{end+ waitingTime[1]-waitingTime[0],loc});
            ans[loc]++;
        }
        int res = 0;
        int max = 0;
        for(int i=0;i<n;i++){

            if(ans[i]>max){
                max = ans[i];
                res = i;
            }
        }
        return res;
    }


}
