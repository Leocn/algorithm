package com.example.demo.codestudio;

import java.util.Arrays;

public class A {

    public class Solution {
         int godOfThunder(int n, int[] a) {
            Arrays.sort(a);
            int ans =0;
            for(int i=n-1; i>0; i--){
                if(a[i]==a[i-1]){
                    ans += a[i];
                    i--;
                }else if(a[i]>a[i-1]){
                    ans += a[i-1];
                    a[i-1] = a[i] - a[i-1];
                }else{
                    ans+=a[i];
                    a[i-1] = a[i-1] -a[i];
                }
            }// Write your code here.
            if(a[0]==0){
                return ans;
            }
            return -1;
        }
    }
}
