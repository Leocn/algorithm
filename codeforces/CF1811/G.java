package com.example.demo.codeforces.CF1811;

import java.io.*;
import java.util.*;

public class G {

    static IOHandler sc = new IOHandler();
    static int mod = 1_000_000_007;
    static int [] nextPos;
    static Integer [][] memo;

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            solve(i);
        }
    }

    private static void solve(int t) {
        int n = sc.nextInt();
        int k = sc.nextInt();


        int [] arr = sc.readArray(n);

       // int [] next = new int [n + 1];
        nextPos = new int [n];
        Arrays.fill(nextPos, n + 1);

        int [] dp = new int [n + 1];
        dp[n] = 0;

        //Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer>[] map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        List<Integer> list;
        int max = 0;
        int val;

        int nextV;

        for (int i = n - 1; i >= 0; --i) {
            list = map[(arr[i])];
            if (map[arr[i]].size()!=0) {
                nextPos[i] = list.get(list.size() - 1);

            }
            list.add(i);

            nextV = list.size() >= k ? list.get(list.size() - k) + 1 : n + 1;
            //next[i] = nextV;

            if (nextV <= n) {
                max = Math.max(max, 1 + dp[nextV] );
            }

            dp[i] = max;
        }


        int total = max * k;
        memo = new Integer [arr.length] [total + 1];

        int result = solve(arr, 0, total, k);

        System.out.println(result);

    }

    private static int solve(int [] arr, int idx, int left, int k) {
        if (left == 0) {
            return 1;
        } else if (idx >= arr.length) {
            return 0;
        } else if (memo[idx][left] != null) {
            return memo[idx][left];
        }

        int result = 0;

        int nxt;

        nxt = left % k == 0 ? idx + 1 : nextPos[idx];

        result = solve(arr, nxt, left, k);
        nxt = (left - 1) % k == 0 ? idx + 1 : nextPos[idx];

        result += solve(arr, nxt, left - 1, k);
        result %= mod;

        //System.out.println(idx + " " + left + " " + res1 + " " + result);
        memo[idx][left] = result;
        return result;
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

        int [] readArray2(int n) {
            int [] res = new int [n + 1];

            for (int i = 1; i <= n; ++i)
                res[i] = nextInt();

            return res;
        }

        int [][] readGraph(int n, int m, int c) {
            int [][] graph = new int [n + 1][];

            int [] count = new int [n + 1];
            int [][] arr = new int [m][1 + c];

            int a, b;

            for (int i = 0; i < m; ++i) {
                a = sc.nextInt();
                b = sc.nextInt();

                arr[i][0] = a;
                arr[i][1] = b;

                ++count[a];
                ++count[b];

                for (int j = 2; j <= c; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i <= n; ++i) {
                graph[i] = new int [count[i] * c];
                count[i] = 0;
            }
            int swap;

            for (int [] tArr : arr) {
                for (int j = 1; j < tArr.length; ++j) {
                    graph[tArr[0]][count[tArr[0]]++] = tArr[j];
                }

                swap = tArr[0];
                tArr[0] = tArr[1];
                tArr[1] = swap;

                for (int j = 1; j < tArr.length; ++j) {
                    graph[tArr[0]][count[tArr[0]]++] = tArr[j];
                }
            }

            return graph;
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
