package com.example.demo.leetcode;

import java.util.*;

public class Week343 {
    public static void main(String[] args) {

    }
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += player1[i];
            if((i>0 && player1[i-1]==10) ||  (i>1 && player1[i-2]==10)){
                sum += player1[i];
            }
        }
        for (int i = 0; i < n; i++) {
            sum -= player2[i];
            if((i>0 && player2[i-1]==10) ||  (i>1 && player2[i-2]==10)){
                sum -= player2[i];
            }
        }
        if(sum>0){
            return 1;
        }else if(sum==0){
            return 0;
        }else {
            return 2;
        }
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] cntR = new int[n];
        int[] cntC =new int[m];
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i,j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] p = map.get(arr[i]);
            cntR[p[0]]++;
            cntC[p[1]] ++;
            if(cntR[p[0]]==m){
                return i;
            }
            if(cntC[p[1]]==n){
                return i;
            }
        }
        return -1;

    }


    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = Math.abs(target[0]-start[0]) + target[1] - start[1];
        List<int[]> list = new ArrayList<>();
        for(int[] s: specialRoads){
            int cost = s[4];
            int sum = Math.abs(s[2]-s[0]) + Math.abs(s[3]-s[1]);
            if(cost>=sum){
                continue;
            }
            list.add(s);
        }
        int m = list.size();
        int[] min = new int[m];
        for (int i = 0; i < m; i++) {
            int[] p = list.get(i);
            min[i] = p[0]-start[0]  + p[1] - start[1] + p[4];
            ans = Math.min(min[i]+ target[0]-p[2] + target[1] -p[3], ans);
        }
        for (int i = 0; i < m; i++) {

            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(i);
            while (dq.size()>0){
                int now = dq.poll();
                int[] p = list.get(now);
                for (int j = 0; j < m; j++) {
                    if(i==j){
                        continue;
                    }
                    int[] next = list.get(j);
                    int sum = Math.abs(next[0] - p[2]) + Math.abs(next[1] - p[3]) + next[4];
                    if(sum+min[now]<min[j]){
                        dq.add(j);
                        min[j] = sum+min[now];
                        ans = Math.min(ans, min[j] + target[0]-next[2] + target[1] -next[3]);;
                    }

                }
            }
        }
        return ans;

    }

    public String smallestBeautifulString(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        int res = -1;
        for (int i = 0; i < n; i++) {
            int l = map.getOrDefault(cs[i], -4);
            if(i-l==1 || i-l==2){
                res = i;
            }
            map.put(cs[i], i);
        }
        if(res==-1){
            res = n-1;
        }
        char t = cs[res];
        t++;
        char target = (char)( 'a' +  (k));

        while (true){
            if(t>=target || (res>0 && cs[res-1] == t) || (res>1 && cs[res-2] ==t)){
                res --;
                if(res<0){
                    break;
                }
                t = cs[res]++;
            }else {
                break;
            }
        }
        char[] d = new char[]{'a','b','c'};
        if(res<0){
            return "";
        }else {
            StringBuilder ans = new StringBuilder(s.substring(0, res));
            ans.append(t);
            int len = ans.length();
            for (int i = 0; i < n-len; i++) {
                char app = d[i%3];
                boolean f = false;
                if(len+i>1 && ans.charAt(len+i-1)==app){
                    app = d[(i+1)%3];
                    f = true;
                }else if(len+i >2 && (ans.charAt(len+i-1)==app || ans.charAt(len+i-2) == app)){
                    app = d[(i+1)%3];
                    f = true;
                }
                if(f && len+i>1 && ans.charAt(len+i-1)==app){
                    app = d[(i+2)%3];
                }else if(f &&len+i >2 && (ans.charAt(len+i-1)==app || ans.charAt(len+i-2) == app)){
                    app = d[(i+2)%3];
                }


                ans.append(app);
            }
            return ans.toString();
        }



    }

}
