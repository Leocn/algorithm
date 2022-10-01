package com.example.demo.codeforces;

import java.util.Scanner;

public class CF805D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str = sc.next();
            int maxV = sc.nextInt();
            int[] values = new int[str.length()];
            int[] counts = new int[27];
            int[] remains = new int[27];
            int sum = 0;
            for(int i=0; i<str.length(); i++){
                values[i] = str.charAt(i) - 'a' + 1 ;
                counts[values[i]] ++;
                remains[values[i]] ++;
                sum += values[i];
            }
            if(maxV>= sum){
                System.out.println(str);
                continue;
            }

            for(int i=26; i>0; i--){
                if(counts[i]==0){
                    continue;
                }
                if(counts[i]>0){
                    if(sum-maxV> counts[i]*i){
                        remains[i]=0;
                        sum -= counts[i]*i;
                    }else{
                        int a = (sum-maxV)/i;
                        int b = (sum-maxV)%i;
                        if(b>0){
                            a++;

                        }
                        sum -= a*i;
                        remains[i]=counts[i]-a;
                        break;
                    }
                }
            }

            if(sum<=0){
                System.out.println("");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<values.length; i++){
                if(counts[values[i]] > remains[values[i]]){
                    counts[values[i]]--;
                }else{
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb);
        }


    }
}
