package com.example.demo.leetcode;

public class LeetCodeCup {
    public static void main(String[] args) {

    }

    public int giveGem(int[] gem, int[][] operations) {
        for(int[] o: operations){
            int n = gem[o[0]]/2;
            gem[o[0]] -= n;
            gem[o[1]] += n;
        }
        int ans = 0;
        int max=0;
        int min =Integer.MAX_VALUE;
        for(int g: gem){
            max = Math.max(g, max);
            min = Math.min(g, min);
        }
        return  max- min;
    }

    /**
     * 可选可不选，2(n);
     *
     * */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int n = cookbooks.length;
        int ans = 0;
        for(int i=1; i<(1<<n); i++){
            int[] sum = new int[5];
            int l = 0;
            int m = 0;
            for(int j=0;j<8;j++){
                if((i&(1<<j))==(1<<j)){
                    for(int h=0;h<5;h++){
                        sum[h] += cookbooks[j][h];
                    }
                }
                l += attribute[j][1];
                m += attribute[j][0];
            }
            boolean t = true;
            for(int h=0;h<5;h++){
                if(sum[h]>materials[h]){
                    t = false;
                }
            }
            if(t && l >= limit){
                ans = Math.max(ans, m);
            }

        }
        return ans ==0?-1:ans;
    }

    int[] materials;
    int[][] cookbooks;
    int[][] attribute;
    int limit;
    int ans;
    int n;
    public int perfectMenu1(int[] _materials, int[][] _cookbooks, int[][] _attribute, int _limit) {
        n = cookbooks.length;
        materials = _materials;
        cookbooks = _cookbooks;
        attribute = _attribute;
        limit = _limit;
        ans = 0;
        dfs(0, 0, 0, new int[5]);

        return ans;
    }
    private void dfs(int loc, int sum, int all, int[] m){
        for (int i = 0; i < 5; i++) {
            if(m[i]>materials[i]){
                return;
            }
        }
        if(loc>=n){
            return;
        }
        if(sum>=limit){
            ans  = Math.max(all, ans);
        }
        for (int i = loc; i < n ; i++) {
            for (int j = 0; j < 5; j++) {
                m[j]+= cookbooks[i][j];
            }
            all += attribute[i][0];
            sum += attribute[i][1];
            dfs(loc+1, sum, all, m);

            for (int j = 0; j < 5; j++) {
                m[j]-= cookbooks[i][j];
            }
            all -= attribute[i][0];
            sum -= attribute[i][1];

        }

    }



}
