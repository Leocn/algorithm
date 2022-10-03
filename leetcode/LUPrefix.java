package com.example.demo.leetcode;

public class LUPrefix {

    int[] ds;
    int n;
    boolean[] vis;
    public LUPrefix(int _n) {

        n = _n;
        ds = new int[n+1];
        vis = new boolean[n+1];
        for (int i = 1; i <=n ; i++) {
            ds[i] = i;
        }
    }

    public void upload(int video) {
        vis[video] = true;
        if(video<n && vis[video+1]){
            ds[video] = find(ds[video+1]);
        }
        if(video>1 && vis[video-1]){
            ds[video-1] = find(ds[video]);
        }
    }

    public int longest() {
        if(!vis[1]){
            return 0;
        }
        return find(1);
    }
    private int find(int f){
        int res = ds[f];
        if(res!=f){
            return find(res);
        }
        return f;
    }
}
