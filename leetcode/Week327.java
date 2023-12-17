package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Week327 {

    public int maximumCount(int[] nums) {
        int ans1 = 0, ans2 = 0;
        for(int n: nums){
            if(n>0){
                ans1++;
            }
            if(n<0){
                ans2++;
            }
        }
        return Math.max(ans1, ans2);
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        long ans = 0;
        while (k-->0){
            int p = pq.poll();
            ans += p;
            pq.add( (p+2)/3);
        }
        return ans;

    }

    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(char c: word1.toCharArray()){
            cnt1[c-'a']++;
        }
        for(char c: word2.toCharArray()){
            cnt2[c-'a']++;
        }

        for(int i=0; i<26; i++){
            if(cnt1[i]>0){
                cnt1[i]--;
                cnt2[i]++;
                for (int j = 0; j < 26; j++) {
                    if(j!=i && cnt2[j]>0){
                        cnt2[j]--;
                        cnt1[j]++;
                        boolean f = check(cnt1, cnt2);
                        if(f){return true;}
                        cnt2[j]++;
                        cnt1[j]--;

                    }else if(j==i && cnt2[j]>1){
                        cnt2[j]--;
                        cnt1[j]++;
                        boolean f = check(cnt1, cnt2);
                        if(f){
                            return true;
                        }
                        cnt2[j]++;
                        cnt1[j]--;
                    }

                }
                cnt1[i]++;
                cnt2[i]--;


            }
        }
        return false;

    }

    private boolean check(int[] arr1, int[] arr2){
        int cnt1 = 0, cnt2 =0;
        for(int a: arr1){
            if(a>0){
                cnt1++;
            }

        }
        for (int a : arr2){
            if(a>0){
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }


    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[3]== b[3]){
                if(a[0]+a[1] == b[0]+b[1]){
                    return b[2] - a[2];
                }else{
                    return b[0]+b[1] - a[0]-a[1];
                }
            }else{
                return a[3]-b[3];
            }

        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)->{

            if(a[3]== b[3]){
                if(a[0]+a[1] == b[0]+b[1]){
                    return b[2] - a[2];
                }else{
                    return b[0]+b[1] - a[0]-a[1];
                }
            }else{
                return a[3]-b[3];
            }


        });



        for(int i=0; i<k; i++ ){
            pq.add(new int[]{time[i][0], time[i][1], i, 0});
        }

        for (int i = 0; i < 1e8; ) {
            PriorityQueue<int[]> tem = new PriorityQueue<>((a,b)->{

                if(a[0]+a[1] == b[0]+b[1]){
                    return b[2] - a[2];
                }else{
                    return b[0]+b[1] - a[0]-a[1];
                }
            });
            while (pq2.size()>0 || tem.size()>0){

                while(pq2.size()>0&& pq2.peek()[3]<=i){
                    tem.add(pq2.poll());
                }
                tem.add(pq2.poll());
                if (tem.size()>0){
                    int[] p = tem.poll();
                    i+= time[p[2]][2];
                    pq.add(new int[]{p[0], p[1], p[2], i+ time[p[2]][3]});
                }
                n--;
                if(n==0){
                    return i;
                }
            }

            PriorityQueue<int[]> temTem = new PriorityQueue<>((a,b)->{

                if(a[0]+a[1] == b[0]+b[1]){
                    return b[2] - a[2];
                }else{
                    return b[0]+b[1] - a[0]-a[1];
                }
            });

            while (pq.size()>0 && pq.peek()[3]<=i){
                temTem.add(pq.poll());
            }
            if(temTem.size()>0){
                int[] p = temTem.poll();
                i+= time[p[2]][0];
                pq2.add(new int[]{p[0],p[1],p[2], i+time[p[2]][1]});
            }
            pq.addAll(temTem);
        }
        return 0;


    }
}
