package com.example.demo.template;

import java.util.Arrays;

/**
 * 后缀数组 + 诱导排序
 * TODO
 * */
public class SA {
    public String lastSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] ss = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ss[i] = cs[i] - 'a' + 1;
        }
        int[] sa = saIS(ss, n + 1, 27);
        return new String(cs, sa[n], n - sa[n]);
    }

    public static final int L_TYPE = 0;
    public static final int S_TYPE = 1;

    /**
     * 诱导排序
     * @param s -- 加入了最后一位占位的序列
     * @param len -- 加入最后一位占位的长度
     * @param sigma -- 字符集大小
     * @return
     */
    public static int[] saIS(int[] s, int len, int sigma) {
        int n = len;
        int[] type = new int[n];
        int[] position = new int[n];
        int[] name = new int[n];
        int[] sa = new int[n];

        int bn = sigma + 1;
        int[] bucket = new int[bn];
        int[] lbucket = new int[bucket.length];
        int[] sbucket = new int[bucket.length];

        //桶
        for (int i = 0; i < n; i++) {
            bucket[s[i]]++;
        }
        for (int i = 1; i < bn; i++) {
            bucket[i] += bucket[i - 1];
            lbucket[i] = bucket[i - 1];
            sbucket[i] = bucket[i] - 1;
        }

        //计算后缀类型
        type[n - 1] = S_TYPE;
        for (int i = n - 2; i >= 0; i--) {
            if (s[i] < s[i + 1]) {
                type[i] = S_TYPE;
            } else if (s[i] > s[i + 1]) {
                type[i] = L_TYPE;
            } else {
                type[i] = type[i + 1];
            }
        }

        //寻找每个LMS子串
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (isLcmLetter(type, i)) {
                position[cnt++] = i;
            }
        }

        //LMS子串排序
        Arrays.fill(sa, -1);
        for (int i = 0; i < cnt; i++) {
            sa[sbucket[s[position[i]]]--] = position[i];
        }
        induced_sort(s, sa, type, bucket, lbucket, sbucket, n, sigma);

        //为每个LMS子串命名
        Arrays.fill(name, -1);
        int lastIdx = -1;
        int nameCnt = 1; //上一次处理的LMS子串与名称计数
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            int p = sa[i];
            if (isLcmLetter(type, p)) {
                if (lastIdx >= 0 && !equalsLCMStr(s, p, lastIdx, type)) {
                    nameCnt++;
                }
                if (lastIdx >= 0 && nameCnt == name[lastIdx]) {
                    flag = true;
                }
                name[p] = nameCnt;
                lastIdx = p;
            }
        }
        name[n - 1] = 0;

        //生成s1
        int[] s1 = new int[cnt];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (name[i] >= 0) {
                s1[pos++] = name[i];
            }
        }

        //计算sa1
        int[] sa1;
        if (!flag) {
            //直接桶计算sa1
            sa1 = new int[cnt + 1];

            for (int i = 0; i < cnt; i++) {
                sa1[s1[i]] = i;
            }
        } else {
            sa1 = saIS(s1, cnt, nameCnt);
        }

        //从sa1诱导到sa
        lbucket[0] = 0;
        sbucket[0] = 0;
        for (int i = 1; i <= sigma; i++) {
            lbucket[i] = bucket[i - 1];
            sbucket[i] = bucket[i] - 1;
        }

        Arrays.fill(sa, -1);
        for (int i = cnt - 1; i >= 0; i--) {
            sa[sbucket[s[position[sa1[i]]]]--] = position[sa1[i]];
        }
        induced_sort(s, sa, type, bucket, lbucket, sbucket, n, sigma);

        return sa;
    }

    private static boolean equalsLCMStr(int[] s, int i, int j, int[] type) {
        do {
            if (s[i] != s[j]) {
                return false;
            }
            i++;
            j++;
        } while (!isLcmLetter(type, i) && !isLcmLetter(type, j));
//        return s[i] == s[j];
        return s[i] == s[j] && type[i] == type[j];
    }

    private static void induced_sort(int[] s, int[] sa, int[] type, int[] bucket, int[] lbucket, int[] sbucket, int n, int sigma) {
        //L
        for (int i = 0; i < n; i++) {
            if (sa[i] > 0 && type[sa[i] - 1] == L_TYPE) {
                sa[lbucket[s[sa[i] - 1]]++] = sa[i] - 1;
            }
        }
        //Reset S
        for (int i = 1; i <= sigma; i++) {
            sbucket[i] = bucket[i] - 1;
        }
        //S
        for (int i = n - 1; i >= 0; i--) {
            if (sa[i] > 0 && type[sa[i] - 1] == S_TYPE) {
                sa[sbucket[s[sa[i] - 1]]--] = sa[i] - 1;
            }
        }
    }

    private static boolean isLcmLetter(int[] type, int i) {
        return i > 0 && type[i] == S_TYPE && type[i - 1] == L_TYPE;
    }
}
