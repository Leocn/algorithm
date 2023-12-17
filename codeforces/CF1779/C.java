package com.example.demo.codeforces.CF1779;

import java.io.*;
import java.util.*;

public class C {

    static IOHandler sc = new IOHandler();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            solve(i);
        }
    }

    private static void solve(int t) {
        int n = sc.nextInt();

        int m = sc.nextInt();

        int [] arr = new int [n + 1];

        for (int i = 1; i <= n; ++i) {
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int count = 0;
        int val;

        for (int i = m; i > 1; --i) {
            sum += arr[i];
            queue.add(arr[i]);


            while (sum > 0) {
                val = queue.poll();
                sum -= 2*val;
                ++count;
            }
        }

        //System.out.println(count);

        sum = 0;
        queue = new PriorityQueue<>();

        for (int i = m + 1; i <= n; ++i) {
            sum += arr[i];
            queue.add(arr[i]);

            //System.out.println(sum + " " + i);
            while (sum < 0) {
                val = queue.poll();
                sum -= 2*val;
                //System.out.println(sum);
                ++count;
            }
        }

        System.out.println(count);
    }

    private static class IOHandler {
        BufferedReader br;
        StringTokenizer st;

        public IOHandler() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int [] readArray(int n) {
            int [] res = new int [n];

            for (int i = 0; i < n; ++i)
                res[i] = nextInt();

            return res;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}

