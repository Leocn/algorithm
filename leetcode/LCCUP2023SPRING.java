package com.example.demo.leetcode;

import java.util.*;

public class LCCUP2023SPRING {
    public static void main(String[] args) {
        //adventureCamp(new String[]{"Alice->Dex","","Dex"});
        int ans = challengeOfTheKeeper(new String[]{"S###.","..###","#..##","##..#","###.T"});
        System.out.println(ans);

    }

    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        int[] ans = new int[n/2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplies[i]);
        }

        int loc = n, left = 0, right =0;
        while (loc>n/2){
            int MAX = Integer.MAX_VALUE;
            for (int i = 0; i < loc-1; i++) {
                if(list.get(i)+list.get(i+1)<MAX){
                    MAX = list.get(i)+list.get(i+1);
                    left = i;
                }
            }
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < loc; i++) {
                if(i==left){
                    list1.add(list.get(left) + list.get(left+1));
                    i++;
                }else {
                    list1.add(list.get(i));
                }

            }
            list = list1;

            loc --;
        }
        for (int i = 0; i < n/2; i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public static int adventureCamp(String[] expeditions) {
        String[] arr = expeditions[0].split("->");
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        int ans = -1, max = 0;
        int n = expeditions.length;
        for (int i = 1; i <n ; i++) {
            int cnt = 0;
            String[] a = expeditions[i].split("->");
            if(expeditions[i].length()==0){
                continue;
            }
            for(String s: a){

                if(!set.contains(s)){
                    cnt ++;
                    set.add(s);
                }
            }
            if(cnt>max){
                max = cnt;
                ans = i;
            }
        }
        return ans;

    }

    public static int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        double[][] arr = new double[n][2];
        double[][] len = new double[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = forceField[i][0] - (double)(forceField[i][2])/2;
            arr[i][1] = forceField[i][0] + (double)(forceField[i][2])/2;
            len[i][0] = forceField[i][1] - (double)(forceField[i][2])/2;
            len[i][1] = forceField[i][1] + (double)(forceField[i][2])/2;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            double a = arr[i][0];
            int res = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(arr[j][0]<=a && arr[j][1]>=a){
                    list.add(j);
                }
            }
            for (int j = 0; j < list.size(); j++) {
                int r = 0;
                int loc = list.get(j);
                double top = len[loc][1];

                for (int k = 0; k <list.size() ; k++) {
                    int l = list.get(k);
                    if(len[l][0]<=top && len[l][1]>=top){
                        r++;
                    }
                }

                res = Math.max(res, r);

                r = 0;

                double bot = len[loc][0];
                for (int k = 0; k <list.size() ; k++) {
                    int l = list.get(k);
                    if(len[l][0]<=bot && len[l][1]>=bot){
                        r++;
                    }
                }
                res = Math.max(res, r);
            }



            double b = arr[i][1];

            res = 0;
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(arr[j][0]<=b && arr[j][1]>=b){
                    list.add(j);
                }
            }
            for (int j = 0; j < list.size(); j++) {
                int r = 0;
                int loc = list.get(j);
                double top = len[loc][1];

                for (int k = 0; k <list.size() ; k++) {
                    int l = list.get(k);
                    if(len[l][0]<=top && len[l][1]>=top){
                        r++;
                    }
                }
                res = Math.max(res, r);

                r = 0;

                double bot = len[loc][0];
                for (int k = 0; k <list.size() ; k++) {
                    int l = list.get(k);
                    if(len[l][0]<=bot && len[l][1]>=bot){
                        r++;
                    }
                }
                res = Math.max(res, r);
            }

            ans = Math.max(ans, res);
        }
        return ans;
    }

    public static  int challengeOfTheKeeper( String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].length();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = chessboard[i].toCharArray();
        }
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dis = new int[n][m];
        for(int[] d: dis){
            Arrays.fill(d,-1);
        }
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cs[i][j] == 'T'){
                    dq.add(new int[]{i,j});
                    dis[i][j] = 0;
                }else if(cs[i][j] == '#'){
                    dis[i][j] = Integer.MAX_VALUE;
                }else if(cs[i][j] == 'S'){
                    sx= i;
                    sy = j;
                }
            }
        }


        int cnt = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (dq.size()>0){
            int s = dq.size();
            cnt++;
            while (s-->0){
                int[] p = dq.poll();
                for(int[] d: dirs){
                    int x = p[0]+d[0], y = p[1] + d[1];
                    if(x<0 || x>=n || y<0 || y>=m){
                        continue;
                    }
                    if(dis[x][y]!=-1){
                        continue;
                    }
                    if(cs[x][y]=='#'){
                        continue;
                    }
                    dis[x][y] = cnt;
                    dq.add(new int[]{x,y});

                }
            }
        }

        int[][] max = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(dis[n-i-1][j] == -1 || dis[i][m-j-1]==-1){
                    max[i][j] = -1;
                    continue;
                }
                int a = dis[n-i-1][j] == Integer.MAX_VALUE ? 0:dis[n-i-1][j];
                int b = dis[i][m-j-1] == Integer.MAX_VALUE ? 0:dis[i][m-j-1];
                max[i][j] = Math.max(a, b);
            }
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i] ,Integer.MAX_VALUE);
        }
        dq = new ArrayDeque<>();
        dq.add(new int[]{sx,sy,0});
        res[sx][sy] = 0;
        int ans  = Integer.MAX_VALUE;
        while (dq.size()>0){
            int[] p =dq.poll();
            for(int[] d: dirs){
                int x = p[0]+d[0], y = p[1] + d[1];
                if(x<0 || x>=n || y<0 || y>=m){
                    continue;
                }
                if(cs[x][y]=='#' || cs[x][y] == 'S'){
                    continue;
                }
                if(cs[x][y] == 'T'){
                    ans = Math.min(res[p[0]][p[1]], ans);
                    continue;
                }
                if(max[x][y]==-1){
                    continue;
                }

                int r = Math.max(res[p[0]][p[1]], max[x][y]);


                if(r<res[x][y]){
                    dq.add(new int[]{x,y,r});
                    res[x][y] = r;
                }

            }

        }
        return  ans ==Integer.MAX_VALUE?-1:ans;



    }


}
