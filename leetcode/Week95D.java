package com.example.demo.leetcode;

public class Week95D {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean f = false;
        if(length>=1e4 || width>=1e4 || height>= 1e4 || (long)length*width*height>=1e9){
            f = true;
        }
        boolean t = false;
        if(mass>=100){
            t = true;
        }
        if(t&&f){
            return "Both";
        }
        if(!t&&!f){
            return "Neither";
        }
        if(f){
            return "Bulky";
        }
        if(t){
            return "Heavy";
        }
        return "Both";
    }

    class DataStream {
        int value;
        int k;
        int tem = 0;
        int temV = 0;
        public DataStream(int _value, int _k) {
            value = _value;
            k = _k;
            tem = 1;
            temV = Integer.MAX_VALUE;
        }

        public boolean consec(int num) {
            if(num== temV){
                tem ++;

            }else{
                tem =1;
                temV = num;
            }
            if(tem >= k && value == temV ){
                return true;
            }
            return false;
        }
    }

    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
    public long maxPower(int[] stations, int r, int k) {
        long right = Long.MAX_VALUE, left = 0;
        int n = stations.length;
        long[] sum =  new long[n+1];
        for(int i=0; i<n; i++){
            sum[i+1] = sum[i]+stations[i];
        }
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            int min = Math.max(0, i-r);
            int max = Math.min(i+r+1 , n);
            res[i] = sum[max] - sum[min];
        }

        while(left< right){
            long mid  = left+(right-left)/2;
            long s = 0;
            long tem = 0;
            long[] tt = new long[n];
            for(int i =0;i<n; i++){
                if(i-2*r>0){
                    tem -= tt[i-2*r-1];
                }
                if(res[i]+tem<mid){
                    tt[i] = mid - res[i]-tem;
                    s+=tt[i];
                    tem += tt[i];
                }
                if(s>k){
                    right = mid;
                    break;
                }
            }
            if(s>k){
                right = mid;
            }else{
                left  = mid+1;
            }
        }
        return left-1;

    }
}
