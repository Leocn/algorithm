package com.example.demo.leetcode;

import java.awt.font.LineMetrics;
import java.util.*;
public class Week304 {
    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{4,4,4,5,1,2,2}, 1 , 1));
        System.out.println(longestCycle(new int[]{4,3,3,4,7,2,3,3}));
    }
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(n>0){
                set.add(n);
            }
        }
        return set.size();

    }
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int ans = 1;
        int n = grades.length;
        while(ans *(ans+1)/2<n){
            ans ++;
        }

        if(ans* (ans+1)/2 == n){
            return ans;
        }else {
            return ans -1;
        }
    }


    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] v = new boolean[n];
        Deque<Integer> que = new ArrayDeque<>();
        if(edges[node1]!=-1){
            que.offer(edges[node1]);
        }
        v[node1] = true;
        int[] len1 = new int[n];
        int last = node1;
        while (que.size()>0){
            int p = que.poll();
            if(v[p]){continue;}
            v[p] = true;
            len1[p] = len1[last]+1;
            if(edges[p]!=-1){
                que.offer(edges[p]);
                last = p;
            }
        }
        v = new boolean[n];
        int[] len2 = new int[n];
        last = node2;

        que = new ArrayDeque<>();
        if(edges[node2]!=-1){
            que.offer(edges[node2]);
        }
        v[node2] = true;
        while (que.size()>0){
            int p = que.poll();
            if(v[p]){continue;}
            v[p] = true;
            len2[p] = len2[last]+1;
            if(edges[p]!=-1){
                que.offer(edges[p]);
                last = p;
            }
        }

        for(int i=0;i<n;i++){
            if(node1!=i && len1[i]==0){
                len1[i] = -1;
            }

            if(node2!=i && len2[i]==0){
                len2[i] = -1;
            }
        }
        int max = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(len1[i]!=-1 && len2[i]!=-1){
               int m = Math.max(len1[i], len2[i]);
               if(m<max){
                   ans = i;
                   max = m;
               }
            }
        }
        return max==Integer.MAX_VALUE? -1:ans;

    }


    public static int longestCycle(int[] edges) {
        int n = edges.length;
        //入度
        int[] degree = new int[n];
        for(int e: edges){
            if(e!=-1){
                degree[e]++;
            }

        }
        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0;i <n; i++){
            if(degree[i]==0){
                que.offer(i);
            }
        }
        while (que.size()>0){
            int q = que.poll();
            if(edges[q]==-1){
                continue;
            }
            degree[edges[q]]--;
            if(degree[edges[q]] == 0){
                que.offer(edges[q]);
            }
        }
        int ans = 0;
        boolean[] v = new boolean[n];

        for(int i=0;i<n;i++){
            boolean flag = true;
            int an = 0;
            que = new ArrayDeque<>();
            if(degree[i]>0 && !v[i] && edges[i]!=-1){
                que.offer(i);
            }
            while (que.size()>0){
                int p = que.poll();
                an ++;
                v[p] = true;
                if(edges[p]==-1){
                    flag = false;
                    break;
                }
                if(!v[edges[p]]){
                    que.offer(edges[p]);
                }
            }
            if(flag){
                ans = Math.max(ans, an);
            }


        }
        return ans==0?-1:ans;


    }
}
