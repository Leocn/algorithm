package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {

    public static void main(String[] args) {
        System.out.println(fallingSquares(new int[][]{{1,2},{2,2},{3,2}}));

        System.out.println(fallingSquares(new int[][]{{1,2},{2,3},{6,1}}));
        System.out.println(fallingSquares(new int[][]{{100,100},{200,100},{200,100}}));
        System.out.println(fallingSquares(new int[][]{{2,1},{2,9},{1,8}}));
        System.out.println(fallingSquares(new int[][]{{9,7},{1,9},{3,1}}));
    }

    /**
     查询区间内最大值, 更新区间内的数
     */
    static int[] sum;
    static int[] M;
    public static List<Integer> fallingSquares(int[][] positions) {
        int n = 1;
        for(int[] p: positions){
            n = Math.max(p[1]+p[0], n);
        }
        sum = new int[4*n];
        M = new int[4*n];
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for(int[] p: positions){
            //左闭右开 [indexL, indexR)
            int height = query(1,1,n,p[0],p[0]+p[1]-1,0);

            update(1,1,n,p[0],p[0]+p[1]-1,height+ p[1], 0);
            max = Math.max(height+p[1], max);
            ans.add(max);

        }
        return ans;

    }

    //更新附加值
    public static void update(int k, int left, int right, int L, int R, int val, int fr){


        if(left==L && right == R){
            sum[k] = val;
            M[k] = Math.max(Math.max(M[k] , sum[k]),fr);
            return;
        }
        int m = left+right>>1;
        fr = Math.max(fr,sum[k]);
        if(m>=R){
            update(2*k, left, m, L, R, val, fr);
            //M[k] = Math.max(M[k], M[2*k]);

        }else if (m<L){
            update(2*k+1, m+1, right, L, R, val, fr);
            //M[k] = Math.max(M[2*k+1], M[k]);
        }else{
            update(2*k, left, m, L, m, val, fr);
            update(2*k+1, m+1, right, m+1, R, val, fr);

        }
        M[k] =Math.max( Math.max(M[2*k+1], M[k]),M[2*k]);

    }
    //查询最大值
    public static int query(int k, int left, int right, int L, int R, int fr){
        //System.out.println("left" + left);
        //System.out.println("right" + right);

        if(left==L && right == R){
            M[k] = Math.max(Math.max(M[k] , sum[k]),fr);
            return M[k];
        }
        int m = left+right>>1;
        fr = Math.max(fr,sum[k]);
        if(m<L){
            int lll = query(2*k+1, m+1, right, L, R, fr);
            M[k] =Math.max( Math.max(M[2*k], M[k]),M[2*k+1]);
            return lll;
        }else if (m>= R){
            int rrr = query(2*k, left, m, L, R,fr);
            M[k] =Math.max( Math.max(M[2*k], M[k]),M[2*k+1]);
            return rrr;

        }else{
            int lll = query(2*k, left, m, L, m, fr) ;
            int rrr = query(2*k+1, m+1, right, m+1, R, fr);

            M[k] =Math.max( Math.max(M[2*k], M[k]),M[2*k+1]);
            return Math.max(lll,rrr );
        }

    }
}
