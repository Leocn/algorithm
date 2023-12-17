package com.example.demo.leetcode;

import java.util.*;

public class Week344 {
    public static void main(String[] args) {
        int a = notand(2,3);
        System.out.println(a);
        System.out.println(notand(a,2));
        System.out.println(qufan(2));
    }

   static int qufan(int x){
        int i = 0, res = 0;
        while((x >> i)>0){
            if(((x >> i) & 1) == 0)
                res += 1 << i;
            i ++;
        }
        return res;
    }
    static int notand(int x, int y){
        return qufan(x&y);
    }

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            set  = new HashSet<>();
            for (int j = 0; j <=i; j++) {
                set.add(nums[j]);
            }
            set2 = new HashSet<>();
            for(int j = i+1; j<n; j++){
                set2 .add(nums[j]);
            }
            ans[i] = set.size()-set2.size();
        }
        return ans;
    }


    class FrequencyTracker{
        Map<Integer, Integer> cnt;
        Map<Integer, Integer> map;
    public FrequencyTracker() {
            cnt = new HashMap<>();
            map = new HashMap<>();
        }

        public void add(int number) {
            int c = map.getOrDefault(number, 0);
            if(c==0){
                map.put(number, 1);
                cnt.put(1, cnt.getOrDefault(1,0)+1);
            }else {
                map.put(number, c+1);
                cnt.put(c, cnt.getOrDefault(c,0)-1);
                cnt.put(c+1, cnt.getOrDefault(c+1, 0) + 1);
            }
        }

        public void deleteOne(int number) {
            int c = map.getOrDefault(number, 0);
            if(c==0){
                return;
            }
            map.put(number, c-1);
            cnt.put(c, cnt.getOrDefault(c,0)-1);
            cnt.put(c-1, cnt.getOrDefault(c-1, 0) + 1);
        }

        public boolean hasFrequency(int frequency) {
            int c = cnt.getOrDefault(frequency,0);
            return c>0;
        }
    }

    public int[] colorTheArray(int n, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y= query[1];
            if(x<n-1){
                if(arr[x]!=0){
                    if(arr[x]==arr[x+1]){
                        sum--;
                    }
                }
                if(arr[x+1] == y){
                    sum++;
                }
            }
            if(x>0){
                if(arr[x]!=0){
                    if(arr[x]==arr[x-1]){
                        sum--;
                    }
                }
                if(arr[x-1] == y){
                    sum++;
                }
            }
            arr[x] = y;
            ans[i] = sum;
        }
        return ans;
    }
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        while (n>1){
            for (int i = n/2; i < n; i+=2) {
                cost[i/2]+= Math.max(cost[i], cost[i+1]);
                ans += Math.abs(cost[i] -cost[i+1]);
            }
            n/=2;
        }
        return ans;
    }


    public int extractMantra(String[] matrix, String mantra) {

        char[] cs = mantra.toCharArray();
        int n = cs.length;
        int h = matrix.length;
        int w = matrix[0].length();
        int[][][] dp = new int[h][w][n+1];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j <w; j++) {
                Arrays.fill(dp[i][j], 0x3f3f3f3f);
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j <w; j++) {
                if(matrix[i].charAt(j)==cs[n-1]){
                    dp[i][j][n-1] = 0;
                    dq.add(new int[]{i,j});
                }
            }
        }
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int c = 0;
        while (dq.size()>0){
            int s = dq.size();
            c++;
            while (s-->0){
                int[] p = dq.poll();
                for(int[] d: dirs){
                    int x = d[0] + p[0];
                    int y = d[1] + p[1];
                    if(x< 0|| x>=w || y<0 || y>=h || dp[x][y][n-1]!=0x3f3f3f3f){
                        continue;
                    }
                    dp[x][y][n-1] = c;
                    dq.add(new int[]{x,y});
                }
            }
        }
        for (int i = n-1; i>=0 ; i--) {
            dq = new ArrayDeque<>();
            for (int j = 0; j <h ; j++) {
                for (int k = 0; k <w ; k++) {
                    if(matrix[j].charAt(k)==cs[i]){
                        dp[j][k][i] = dp[j][k][i+1];
                        dq.add(new int[]{j,k, dp[j][k][i]});
                    }
                }
            }
            while (dq.size()>0){
                int s = dq.size();
                while (s-->0){
                    int[] p = dq.poll();
                    for(int[] d: dirs){
                        int x = d[0] + p[0];
                        int y = d[1] + p[1];
                        int t = p[2];
                        if(x< 0|| x>=w || y<0 || y>=h ){
                            continue;
                        }
                        if(dp[x][y][i]>t+1){
                            dp[x][y][i] = t+1;
                            dq.add(new int[]{x,y,t+1});
                        }

                    }
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(dp[i][j][0]>=ans){
                    continue;
                }else {
                    ans = Math.min(i+j+dp[i][j][0], ans);
                }
            }
        }
        return ans== 0x3f3f3f3f ?-1:ans+n;
    }

    public int getNandResult(int k, int[] arr, int[][] operations) {
        int n = arr.length;
        int ans = 0;
        int[][] record = new int[n][k];
        int sum = 0;
        int[] cnt = new int[k];
        for (int i = 0; i < n; i++) {
            int d = ~arr[i];
            int loc = k-1;
            while (d>0){
                if(d%2==1){
                    sum |= (1<<(31-loc));
                    cnt[loc]++;
                }
                record[i][loc--] = d%2;
                d/=2;
            }
        }
        for(int[] op: operations){
            if(op[0]==1){
                System.out.println((~op[2]) | sum);
                ans ^= (~op[2]) | sum;
            }else {
                int r = ~arr[op[1]];
                int loc = k-1;
                while (r>0){
                    if(r%2==1){
                        sum |= (1>>(k-1-loc));
                        cnt[loc]--;
                        if(cnt[loc]==0){
                            sum ^= (1<<(k-1-loc));
                        }
                    }
                    record[op[1]][loc] = 0;
                    loc--;
                    r/=2;
                }

                int d = ~op[2];
                loc = k-1;
                while (d>0){
                    if(d%2==1){
                        sum |= (1<<(31-loc));
                        cnt[loc]++;
                    }
                    record[op[1]][loc--] = d%2;
                    d/=2;
                }


            }
        }
        return ans;



    }

}
