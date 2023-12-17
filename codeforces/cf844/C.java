package com.example.demo.codeforces.cf844;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            String s = sc.next();
            int[] cnt = new int[26];
            char[] cs = s.toCharArray();
            for(char c:cs){
                cnt[c-'a']++;
            }
            int diff = 0;
            for (int i = 0; i < 26; i++) {
                if(cnt[i]>0){
                    diff++;
                }
            }
            int[] tem = new int[26];
             System.arraycopy(cnt, 0, tem,0,26);
            Arrays.sort(cnt);

            int d = 1, max = Integer.MAX_VALUE;
            int ans = 0;
            while(d<=26){
                if(n%d!=0){
                    d++;
                    continue;
                }
                int sum =0;
                int left = n/d;
                int p = d-diff;
                for(int i =0; i<26;i++){
                    int abs = Math.abs(cnt[i] - left);
                    if(p==0){
                        if(cnt[i]==0) continue;
                        sum += abs;

                    }else if(p>0){
                        if(cnt[i]==0){
                            p--;
                            sum+= left;
                        }else{
                            sum += abs;
                        }
                    }else{
                        if(cnt[i]>0){
                            p++;
                            sum += cnt[i];
                        }
                    }
                }
                if(sum<max){
                    ans = d;
                    max = sum;
                }
                d++;
            }
            int[][] hh = new int[26][2];
            for(int i=0; i<26; i++){
                hh[i][0] = tem[i];
                hh[i][1] = i;
            }
            int p = ans-diff;
            int left = n/ans;
            Arrays.sort(hh,(a,b)->a[0]-b[0]);

            for (int i = 0; i < 26; i++) {
                int gg = hh[i][0];
                if(p==0){
                    if(gg==0) continue;
                    hh[i][0] = left;

                }else if(p>0){
                    if(gg==0){
                        p--;
                        hh[i][0] = left;
                    }else{
                        hh[i][0] = left;
                    }
                }else{
                    if(gg>0){
                        p++;
                        hh[i][0] = 0;
                    }
                }
            }
            out:for(int i=0 ;i<n; i++){
                char c = cs[i];
                for(int j=0;j<26;j++){
                    if(c-'a' == hh[j][1] && hh[j][0]>0){
                        hh[j][0]--;
                        continue out;
                    }
                }

                cs[i] = '-';

            }

            for (int i = 0; i < n; i++) {
                if(cs[i]=='-'){
                    for (int j = 0; j < 26; j++) {
                        if(hh[j][0]>0){
                            cs[i] = (char) ('a' + hh[j][1]);
                            hh[j][0]--;
                            break;
                        }
                    }
                }
            }


            System.out.println(max/2);
            System.out.println(cs);






        }
    }
}
