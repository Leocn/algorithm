package com.example.demo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Month10 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
         int val;
         Node prev;
         Node next;
         Node child;
    }
    /**
     * 子字符串
     */
    public static boolean isSubsequence(String s, String r) {
        int flag = 0;
        for (char a : s.toCharArray()) {
            System.out.println(r.indexOf(a, flag));
            if (r.indexOf(a, flag) == -1) {
                return false;
            } else {
                flag = r.indexOf(a, flag) + 1;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        //treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        //treeNode.right.right = new TreeNode(5);

        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        //node.next.next.next.next = new ListNode(1);

//        System.out.println(isSubsequence("sd","aaasda"));
//        System.out.println(singleNumber(new int[]{2,2,1,6,5,5,1}));
//        System.out.println(5&4);
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 5)));
//        System.out.println(minSteps(8));
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(minimumTotal(
                new ArrayList<List<Integer>>() {{
                    add(new ArrayList<Integer>() {{
                        add(2);
                    }});
                    add(new ArrayList<Integer>() {{
                        add(3);
                        add(4);
                    }});
                    add(new ArrayList<Integer>() {{
                        add(6);
                        add(5);
                        add(7);
                    }});
                    add(new ArrayList<Integer>() {{
                        add(4);
                        add(1);
                        add(8);
                        add(3);
                    }});
                }}
        ));
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(minFallingPathSumNotOneRow(new int[][]{{-73, 61, 43, -48, -36}, {3, 30, 27, 57, 10}, {96, -76, 84, 59, -15}, {5, -49, 76, 31, -7}, {97, 91, 61, -46, 67}}));
        System.out.println(maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(waysToChange(900750));
        System.out.println(wordBreak("applepenapple", new ArrayList<String>() {{
            add("apple");
            add("pen");
        }}));
        System.out.println(wordBreak("dogs", new ArrayList<String>() {{
            add("dog");
            add("s");
            add("gs");
        }}));
        System.out.println(longestCommonSubsequence("yby", "bl"));

        System.out.println(inorderTraversal(treeNode));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));

        System.out.println(fib(95));
        System.out.println(levelOrder(treeNode));
        System.out.println(zigzagLevelOrder(treeNode));
        System.out.println(generate(6));
        System.out.println(levelOrderBottom(treeNode));
        System.out.println(Arrays.toString(countBits(8)));
        System.out.println(minDistance("yby", "bl"));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(strStr("jj","j"));
        System.out.println(Arrays.toString(reversePrint(node)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(maxVowels("abciiidef", 3 ));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        reorderList(node);
        System.out.println(lastStoneWeightII(new int[]{1,2,4,8}));
        System.out.println(isValid("([)]"));
        System.out.println(letterCombinations(""));
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(combine(5,5));
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2},5));
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsetsWithDup(new int[]{1,2,2,2}));
        System.out.println(combinationSum3(3,9));
        System.out.println(minFlipsMonoIncr("00011000"));
        System.out.println(isPalindrome("R man, a plan, a canal: Panam2"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(partition("aab"));
        System.out.println(isValidBST(treeNode));
        System.out.println(maximumDifference(new int[]{1,5,2,10}));
        System.out.println(sumArray(new int[]{1,2,3,4,5}, 3));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(massage(new int[]{2,1,4,5,3,1,1,3}));
        System.out.println(arrangeCoins(8));
        System.out.println(kthSmallest(treeNode,2));
        System.out.println(twoOutOfThree(new int[]{1,2,2}, new int[]{4,3}, new int[]{5}));
        System.out.println(minOperations(new int[][]{{1, 5}, {2, 3}}, 1));
        System.out.println(isSymmetric(treeNode));
        System.out.println(numberToWords(12345));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(generateTrees(3));
        System.out.println(divide(-2147483648,1));
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(maxProduct(treeNode));
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(countAndSay(10));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(minWindow("ADOBECODEBANC",  "ABC"));
        System.out.println(addOperators("1000000009",9));
        System.out.println(Arrays.toString(topKFrequent(new int[]{5,3,1,1,1,3,73,12}, 2)));
        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(Arrays.toString(smallestK(new int[]{1, 2, 3}, 2)));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqy" +
                "vtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfe" +
                "lahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklc" +
                "xolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesn" +
                "nrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
        System.out.println(integerBreak(10));
        System.out.println(majorityElement(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println(maxCoins(new int[]{3,1,5,8}));
        System.out.println(Arrays.toString(constructRectangle(6688)));
        System.out.println(change(2, new int[]{5}));
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(shoppingOffers(Arrays.asList(4,3,2,9,8,8),
                new ArrayList<List<Integer>>(){{
                    add(Arrays.asList(1,5,5,1,4,0,18));
                    add(Arrays.asList(3,3,6,6,4,2,32));
                }},
                Arrays.asList(6,5,5,6,4,1)

                ));
        System.out.println(canFinish(20,
                new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}})
        );

        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(isPerfectSquare(2147395600));
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
        System.out.println(asteroidCollision(new int[]{5,10,-5}));
//        System.out.println(getMoneyAmount(18));
    }

    public static int singleNumber(int[] nums) {
        int flag = 0;

        for (int i : nums) {
            flag = i ^ flag;
        }
        return flag;

    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = 0;

        while (m >= 0 && n <= matrix[0].length - 1) {
            if (target == matrix[m][n]) {
                return true;
            }
            if (target < matrix[m][n]) {
                m--;
            } else {
                n++;
            }
        }
        return false;
    }

    /**
     * 两数字和 1
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int h = nums[i];
            if (hashMap.containsKey(h)) {

                return new int[]{hashMap.get(h), i};
            }
            hashMap.put(target - h, i);
        }
        return null;
    }

    /**
     * 只有两个键的键盘 650
     */
    public static int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;
//        int[] m = new int[n+1];
//        m[1]=0;m[2]=2;
//        for (int i = 3; i <= n; i++) {
//            int result = i;
//            for (int j = 2; j < Math.sqrt(i); j++) {
//                if(i%j==0){
//                    result = Math.min(result, m[j]+i/j);
//                }
//            }
//            m[i] = result;
//        }
//        return m[n];


        int result = n;
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                result = Math.min(result, minSteps(i) + n / i);
            }

        }
        return result;
    }

    /**
     * 零钱兑换 322
     */
    public static int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + amount;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }

        }
        return dp[amount] == amount + amount ? -1 : dp[amount];

    }

    /**
     * 链表反转 206
     */
    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        return preNode;
    }

    /**
     * 63. 不同路径 II
     */

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (m == 1 && n == 1) return (obstacleGrid[0][0]) ^ 1;

        int[] aa = new int[m + 1];
        aa[0] = (obstacleGrid[0][0]) ^ 1;
        for (int k = 1; k < m; k++) {
            aa[k] = obstacleGrid[0][k] == 1 ? 0 : aa[k - 1];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[j][i] == 1) {
                    aa[i] = 0;
                    continue;
                }
                if (i == 0) {
                    aa[i] = (obstacleGrid[j][0] == 1 ? 0 : aa[i]);
                    continue;
                }
                aa[i] = aa[i] + aa[i - 1];
            }
        }

        return aa[m - 1];

    }

    /**
     * 64. 最小路径和
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] aa = new int[n + 1];
        if (m == 1 && n == 1) return grid[0][0];
        aa[0] = (grid[0][0]);
        for (int k = 1; k < n; k++) {
            aa[k] = grid[0][k] + aa[k - 1];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    aa[i] = grid[j][0] + aa[i];
                    continue;
                }
                aa[i] = Math.min(aa[i], aa[i - 1]) + grid[j][i];
            }
        }
        return aa[n - 1];

    }

    /**
     * 120. 三角形最小路径和
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);

        int[] aa = new int[n];
        int min = Integer.MAX_VALUE;
        aa[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int m = triangle.get(i).size();
            List<Integer> list = triangle.get(i);
            int newFlag = 0;
            for (int j = 0; j < m; j++) {
                int oldFlag = aa[j];
                aa[j] = Math.min(j == 0 ? Integer.MAX_VALUE : newFlag, j == m - 1 ? Integer.MAX_VALUE : aa[j]) + list.get(j);
                newFlag = oldFlag;
                if (i == n - 1) {
                    min = Math.min(aa[j], min);
                }

            }
        }
        return min;
    }

    /**
     * 931. 下降路径最小和
     */
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;

        if (m == 1 && n == 1) return matrix[0][0];
        int[] aa = Arrays.copyOf(matrix[0], matrix[0].length);

        for (int j = 1; j < m; j++) {
            int newFlag = 0;
            for (int i = 0; i < n; i++) {
                int oldFlag = aa[i];
                aa[i] = Math.min(i == 0 ? Integer.MAX_VALUE : newFlag, aa[i]);
                aa[i] = Math.min(aa[i], i == n - 1 ? Integer.MAX_VALUE : aa[i + 1]) + matrix[j][i];
                newFlag = oldFlag;

                if (j == m - 1) {
                    min = Math.min(aa[i], min);
                }
            }
        }
        return min;
    }

    /**
     * 1289. 下降路径最小和  II
     */
    public static int minFallingPathSumNotOneRow(int[][] matrix) {
        int n = matrix.length;
        //int n= matrix[0].length;
        if (n == 1) return matrix[0][0];

        int minLocation = 0;
        int secondLocation = -1;
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] < matrix[0][minLocation]) {
                secondLocation = minLocation;
                minLocation = i;
            } else if (secondLocation == -1 || matrix[0][i] < matrix[0][secondLocation]) {
                secondLocation = i;
            }
        }
        for (int j = 1; j < n; j++) {
            int minLocationInner = 0;
            int secondLocationInner = -1;

            for (int i = 0; i < n; i++) {
                if (i == minLocation) {
                    matrix[j][i] += matrix[j - 1][secondLocation];
                } else {
                    matrix[j][i] += matrix[j - 1][minLocation];
                }
                if (i == 0) {
                    continue;
                }
                if (matrix[j][i] < matrix[j][minLocationInner]) {
                    secondLocationInner = minLocationInner;
                    minLocationInner = i;
                } else if (secondLocationInner == -1 || matrix[j][i] < matrix[j][secondLocationInner]) {
                    secondLocationInner = i;
                }
            }
            minLocation = minLocationInner;
            secondLocation = secondLocationInner;
        }

        return matrix[n - 1][minLocation];
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] aa = new int[n + 1];
        if (m == 1 && n == 1) return grid[0][0];
        aa[0] = (grid[0][0]);
        for (int k = 1; k < n; k++) {
            aa[k] = grid[0][k] + aa[k - 1];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    aa[i] = grid[j][0] + aa[i];
                    continue;
                }
                aa[i] = Math.max(aa[i], aa[i - 1]) + grid[j][i];
            }
        }
        return aa[n - 1];
    }

    /**
     * 416. 分割等和子集
     */
    public static boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;

        int sum = 0;
        int max = 0;
        for (int j : nums) {
            sum += j;
            max = Math.max(max, j);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }

        boolean[] dp = new boolean[(sum / 2) + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                dp[i] = dp[i - num] || dp[i];
            }
        }

        return dp[sum / 2];
    }

    /**
     * 面试题 08.11. 硬币
     */
    public static int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < coins.length; i++) {
            if (coins[i] > n) continue;
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return (int) (dp[n] % 1000000007);

    }

    /**
     * 139. 单词拆分
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String value : wordDict) {
                if (s.substring(0, i).endsWith(value)) {
                    dp[i] = dp[i - value.length()];
                }
                if (dp[i]) break;
            }

        }
        return dp[n];
    }

    /**
     * 1143. 最长公共子序列
     * dp[i]
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m][n];
    }

    /**
     * 中序遍历
     * */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orderList= new ArrayList<>();
        TreeNode now = root;
        Stack<TreeNode> stack = new Stack<>();

        while(now!=null || !stack.isEmpty()){
            while (now!=null){
                stack.push(now);
                now = now.left;
            }
            now = stack.pop();
            orderList.add(now.val);
            now = now.right;

        }

        return orderList;
    }

    /**
     * 58. 最后一个单词的长度
     * */

    public static int lengthOfLastWord(String s) {
        char[] words = s.toCharArray();
        int flag = 0;
        int i = words.length-1;
        while (i>=0 && (flag==0 || words[i] != ' ')){
            if(words[i]!=' '){
                flag++;
            }
            i--;
        }
        return flag;

    }

    /**
     * 102. 二叉树的层序遍历
     * */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return null;
        List<List<Integer>> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queueTemp = new LinkedList<>();
        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node.left !=null) queueTemp.add(node.left);
            if(node.right != null) queueTemp.add(node.right);
            list.add(node.val);
            if(queue.isEmpty()){
                queue.addAll(queueTemp);
                queueTemp.clear();

                List<Integer> temp = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp,list);
                arrayList.add(temp);
                list.clear();
            }

        }
        return arrayList;
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * */
    public static int fib(int n) {
        if(n==0 ||n==1) return n;
        long a = 0;
        long b = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) %1000000007;
            a = b;
            b = sum;
        }
        return  Integer.parseInt(sum +"");
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     * */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arrayList = new LinkedList<>();
        if (root==null) return arrayList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stackTemp = new Stack<>();
        int flag = 1;

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(flag%2==1){
                if(node.left !=null)stackTemp.push(node.left);
                if(node.right != null)stackTemp.push(node.right);
            }else {
                if(node.right != null) stackTemp.push(node.right);
                if(node.left !=null)stackTemp.push(node.left);
            }

            list.add(node.val);
            if(stack.isEmpty()){
                stack.addAll(stackTemp);
                stackTemp.clear();

                List<Integer> temp = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp,list);
                arrayList.add(temp);
                list.clear();
                flag ++;
            }

        }
        return arrayList;
    }

    /**
     * 160. 相交链表
     * */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode headATemp= headA;ListNode headBTemp= headB;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headATemp!=null) {stackA.push(headATemp);headATemp = headATemp.next;}
        while (headBTemp!=null) {stackB.push(headBTemp);headBTemp = headBTemp.next;}
        ListNode listNode = null;
        while(!stackA.isEmpty() && !stackB.isEmpty() ){
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if(nodeA.val ==  nodeB.val){
                listNode = nodeA;
            }
        }
        return listNode;
    }

    /**
     * 118. 杨辉三角
     * */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new ArrayList<Integer>(){{add(1);}});
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = list.get(i-1);
            List<Integer> l = Arrays.asList(new Integer[i+1]);
            l.set(0,1);l.set(i,1);
            int j = 1;
            while (j<(i/2 + 1)){
                l.set(j, last.get(j-1)+last.get(j));
                l.set( i-j ,last.get(j-1)+last.get(j));
                j++;
            }
            list.add(l);
        }
        return list;
    }

    /**
     * 107. 二叉树的层序遍历 II
     * */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) return null;
        List<List<Integer>> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queueTemp = new LinkedList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left !=null) queueTemp.add(node.left);
            if(node.right != null) queueTemp.add(node.right);
            list.add(node.val);
            if(queue.isEmpty()){
                queue.addAll(queueTemp);
                queueTemp.clear();

                List<Integer> temp = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp,list);
                arrayList.add(0,temp);
                list.clear();
            }

        }
        return arrayList;
    }

    /**
     * 2. 两数相加
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode moveNode = head;
        int left = 0;
        while(l1!=null || l2!=null || left!=0){
            int sum = (l1==null? 0:l1.val) + (l2==null? 0:l2.val) + left;
            left = sum/10;
            sum = sum%10;
            moveNode.next = new ListNode(sum);
            moveNode = moveNode.next;
            l1 = l1==null? null : l1.next;
            l2 = l2==null? null : l2.next;
        }
        head = head.next;
        return head;
    }

    /**
     * 338. 比特位计数
     * */
    public static int[] countBits(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i/2] + i%2;
        }
        return array;

    }
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     *
     * */
    public static int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        int i = 0;
        for(ListNode listNode = head; listNode!=null; listNode = listNode.next){
            i++;
        }
        int[] array = new int[i];
        for(ListNode listNode = head; listNode!=null; listNode = listNode.next){
            array[i-1] = listNode.val;
            i--;
        }

        return array;
    }

    /**
     * 430. 扁平化多级双向链表
     *
     * 递归遍历
     * 递归前保存当前节点的next节点
     * */
    public static Node flatten(Node head) {
        Node n = head;
        while (n!=null){

            if(n.child !=null){
                Node next = n.next;
                n.next = flatten(n.child);
                n.next.prev = n;
                n.child = null;

                if (next!=null){
                    while (n.next!=null){
                        n = n.next;
                    }
                    n.next = next;
                    next.prev = n;
                }


            }
            n = n.next;
        }
        return head;
    }

    /**
     * 583. 两个字符串的删除操作
     *
     * 最长公共子序列的变种
     * */
    public static int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(w1[i-1] == w2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }
        return m+n - 2* dp[m][n];

    }

    /**
     * 26. 删除有序数组中的重复项
     * */
    public static int removeDuplicates(int[] nums) {
        int tag = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[tag]){
                tag++;
                nums[tag] = nums[i];
            }
        }
        return tag+1;
    }
    /**
     * 27. 移除元素
     * */
    public static int removeElement(int[] nums, int val) {
        int tag = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                tag++;
                nums[tag] = nums[i];
            }
        }
        return tag+1;
    }

    /**
     *  28. 实现 strStr()
     * */
    public static int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        if(n==0) return 0;
        for (int i = 0; i < m; i++) {
            if(haystack.charAt(i) == needle.charAt(0) && m - i >= n && haystack.substring(i,i+n).equals(needle)) {
                return i;
            }
        }
        return -1;

    }
    /**
     * 1171. 从链表中删去总和值为零的连续节点
     * 两次遍历，存储sum值到hashmap，重复的sum值覆盖
     * */

    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        //返回的node
        ListNode node = new ListNode(0);
        node.next = head;
        //第一次遍历
        ListNode cur = node;
        int sum = 0;
        while (cur != null){
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        //遍历第二次，找到sum
        ListNode cur2 = node;
        int sum2 = 0;
        while (cur2!=null){
            sum2 += cur2.val;
            ListNode n = map.get(sum2);
            cur2.next = n.next;
            cur2 = cur2.next;
        }
        return node.next;
    }

    /**
     * 剑指 Offer II 027. 回文链表
     * */
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        for(ListNode node = head; node!=null; node = node.next){
            stack.push(node);
        }
        for(ListNode node = head; node!=null; node = node.next){
            if(stack.pop().val != node.val){
                return false;
            }
        }
        return true;

    }

    /**
     * 371. 两整数之和
     * */
    public static int getSum(int a, int b) {
        return  b!=0 ? getSum(a^b, (a&b)<<1) : a;
    }


    /**
     * 239. 滑动窗口最大值
     * */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1) return nums;
        int[] res = new int[nums.length-k+1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int right = 0;
        for (int num : nums) {

            while (!list.isEmpty() && list.peekLast() < num) {
                list.removeLast();
            }
            list.addLast(num);
            right++;
            if (right >= k) {
                res[index++] = list.peekFirst();
                if (list.peekFirst() == nums[right - k]) {
                    list.removeFirst();
                }
            }

        }
        return res;
    }

    /**
     * 1456. 定长子串中元音的最大数目
     * */
    public static int maxVowels(String s, int k) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int right = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                count ++;
            }
            right++;
            if(right>=k){
                max = Math.max(max, count);
                if(set.contains(s.charAt(right-k))){
                    count --;
                }
            }

        }
        return max;
    }

    /**
     * 3. 无重复字符的最长子串
     * */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        int left = 0;
        int max = 0, count = 0;
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(linkedHashMap.containsKey(s.charAt(i))){
                left = Math.max(left,linkedHashMap.get(s.charAt(i)));
                count = i - left;
            }else {
                count++;
            }
            linkedHashMap.put(s.charAt(i), i);
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null || l2 != null){
            if(l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                cur.next = l1;
                l1 = l1.next;
            }else {
                if(l1.val>l2.val){
                    cur.next = l2;
                    l2 = l2.next;

                }else{
                    cur.next = l1;
                    l1 = l1.next;

                }
            }
            cur = cur.next;

        }

        return head.next;
    }

    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * */
    public static int kthToLast(ListNode head, int k) {
        int count = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            if(count>k){
                slow = slow.next;
            }

            count ++;
            fast = fast.next;
        }
        return slow.val;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            if(cur.val == val){
                if(pre == null){
                    head.next = cur.next;
                }else {
                    pre.next = cur.next;
                }
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
    /**
     * 143. 重排链表
     * */
    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        //求出中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //right就是右半部分 12345 就是45  1234 就是34
        ListNode right = slow.next;
        //断开左部分和右部分
        slow.next = null;
        ListNode preNode = null;
        while (right != null) {
            ListNode next = right.next;
            right.next = preNode;
            preNode = right;
            right = next;
        }
        ListNode cur = head;
        while (preNode!=null ){
            ListNode next = cur.next;
            ListNode nextRight = preNode.next;

            cur.next = preNode;
            cur = cur.next;
            cur.next = next;

            preNode = nextRight;
            cur = next;
        }
    }

    /**
     * 437. 路径总和 III
     * */
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count = 0;
        if(root.val == targetSum) count = 1;

        if(root.left!=null){
            count += pathSum(root.left, targetSum);
            count += PathSumRoot(root.left, targetSum-root.val);
        }

        if(root.right!=null) {
            count += pathSum(root.right, targetSum);
            count += PathSumRoot(root.right, targetSum-root.val);
        }
        return count;
    }

    private int PathSumRoot(TreeNode root, int targetSum){
        int count = 0;
        if(root.val == targetSum) count = 1;
        if(root.left!=null){
            count += PathSumRoot(root.left, targetSum-root.val);
        }
        if(root.right!=null) {
            count += PathSumRoot(root.right, targetSum-root.val);
        }
        return count;

    }

    /**
     * 11. 盛最多水的容器
     * */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int s = 0;
        while (i<j){
            s = Math.max(s, (j-i) * (height[j]>height[i]? height[i++] :  height[j--]));
        }
        return s;
    }

    /**
     * 1049. 最后一块石头的重量 II
     * 题解分解成离 sum/2最近的几个数的和时多少
     * dp[i][j]前i个数期望和为j时的真实和为多少
     * */
    public static int lastStoneWeightII(int[] stones) {
        int size = stones.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stones[i];
        }
        int[][] dp = new int[size + 1][sum/2 + 1];


        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if(j<stones[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]] +stones[i-1]);
                }
            }

        }
        return sum- 2* dp[size][sum/2];

    }

    /**
     * 517. 超级洗衣机
     * */
    public static int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for(int i = 0;i<machines.length;i++) {
            sum+=machines[i];
        }
        // 如果不能均分直接返回-1
        if(sum%n!=0) return -1;
        int target = sum/n;
        int diff = 0;
        int res = 0;
        for(int i = 0;i<n;i++) {
            // 获取当前位置需要的衣服
            diff += machines[i]-target;
            // 三个状态,1,res,上个状态的最小操作数,2,Math.max(Math.abs(diff))当前组需要的最小操作数,3,当前位置能够往两遍输送的最衣服数量
            res = Math.max(res,Math.max(Math.abs(diff),machines[i]-target));
        }
        return res;
    }

    /**
     *  223. 矩形面积
     * */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //定义重合顶点的坐下坐标为  cx1 cy1  右上坐标为 cx2 cy2
        int cx1 = Math.max(bx1, ax1);
        int cy1 = Math.max(by1, ay1);

        int cx2 = Math.min(bx2, ax2);
        int cy2 = Math.min(by2, ay2);

        return(ax2-ax1) * (ay2-ay1)+ (bx2-bx1) * (by2-by1)
                - Math.max(0,(cx2-cx1)) * Math.max(0,(cy2-cy1));

    }

    /**
     * 20. 有效的括号
     * */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(')');
                continue;
            }
            if(s.charAt(i) == '['){
                stack.push(']');
                continue;
            }
            if(s.charAt(i) == '{'){
                stack.push('}');
                continue;
            }
            if(stack.isEmpty() || stack.pop()!=s.charAt(i)){
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     *  17. 电话号码的字母组合
     * */
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        HashMap<Character,String> hashMap = new HashMap<>();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        StringBuilder sb = new StringBuilder("");
        backtracking(hashMap, list, sb, digits);
        return list;

    }

    private static void backtracking(HashMap<Character,String> map,  List<String> list, StringBuilder sb, String digits){
        if(sb.length() == digits.length()){
            list.add(sb.toString());
            return;
        }
        int index = sb.length();
        String words = map.get(digits.charAt(index));
        for (int i = 0; i < words.length(); i++) {
            sb.append(words.charAt(i));
            backtracking(map, list, sb, digits);
            sb.deleteCharAt(index);
        }
    }

    /**
     * 434. 字符串中的单词数
     * */
    public static int countSegments(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c != ' '){
                count ++;
                if(i == s.length()-1){res ++;}
            }else if(count>0){
                res ++;
                count = 0;
            }

        }
        return res;
    }

    /**
     * 77. 组合
     * */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtracking(list, res, n, k,1);
        return res;

    }
    private static void backtracking(LinkedList<Integer> list, List<List<Integer>> res, int n, int k, int last) {
        if(list.size() == k ){
            res.add(new ArrayList<>(list));
        }

        for (int i = last; i <= n; i++) {
            list.add(i);
            backtracking(list, res, n, k,i+1);
            list.removeLast();
        }
    }

    /**
     * 39. 组合总和
     * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(list, res,candidates,target,0);
        return res;
    }

    private static void backtracking(LinkedList<Integer> list, List<List<Integer>> res,
                                     int[] candidates, int target, int index) {
        if(target == 0 ){
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if(target < candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            backtracking(list, res,candidates,target-candidates[i],i);
            list.removeLast();
        }
    }

    /**
     *  40. 组合总和 II
     * */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] booleans = new boolean[candidates.length];
        backtracking2(list, res,candidates,target,0,booleans);
        return res;
    }
    private static void backtracking2(LinkedList<Integer> list, List<List<Integer>> res,
                                     int[] candidates, int target, int index, boolean[] booleans) {
        if(target == 0 ){
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if(target < candidates[i] || (i>0&&candidates[i]==candidates[i-1] && !booleans[i-1])){
                continue;
            }
            list.add(candidates[i]);
            booleans[i] = true;
            backtracking2(list, res,candidates,target-candidates[i],i+1, booleans);
            booleans[i] = false;
            list.removeLast();

        }
    }

    /**
     * 78. 子集
     * */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        LinkedList<Integer> list = new LinkedList<>();
        backtracking(list, res, nums,0);
        return res;
    }

    private static void backtracking(LinkedList<Integer> list, List<List<Integer>> res,
                                      int[] nums, int index){
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(list, res, nums, i+1);
            list.removeLast();
        }
    }

    /**
     * 90. 子集 II
     * */

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] booleans = new boolean[nums.length];
        backtrackingWithDup(list, res, nums,0, booleans);
        return res;
    }

    private static void backtrackingWithDup(LinkedList<Integer> list, List<List<Integer>> res,
                                     int[] nums, int index, boolean[] booleans){
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if(i>0&& nums[i]==nums[i-1]&& !booleans[i-1]){continue;}
            list.add(nums[i]);
            booleans[i] = true;
            backtrackingWithDup(list, res, nums, i+1, booleans);
            booleans[i] = false;
            list.removeLast();
        }
    }

    /**
     * 216. 组合总和 III
     * */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n==0 || k==0){return res;}
        LinkedList<Integer> list = new LinkedList<>();
        backtrackingCombinationSum3(list, res,k,n,1);
        return res;
    }
    private static void backtrackingCombinationSum3(LinkedList<Integer> list, List<List<Integer>> res,
                                     int k, int n,int index){
        if(k==list.size() || n==0){
            if(k==list.size() && n==0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i <=9 ; i++) {
            if(n<i){continue;}
            list.add(i);
            backtrackingCombinationSum3(list, res,k,n-i,i+1);
            list.removeLast();
        }
    }

    /**
     * 剑指 Offer II 092. 翻转字符
     * dp[i][0]代表以截至第i个字符串，以0为结尾的最小翻转次数
     * */
    public static int minFlipsMonoIncr(String s) {
        int m = s.length();
        if(m==0 || m==1) return 0;
        int[][] dp = new int[m][2];
        if(s.charAt(0) == '0'){
            dp[0][1] = 1;
        }else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if(s.charAt(i) == '1'){
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]);
            }else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]+1;
            }

        }
        return Math.min(dp[m-1][0],dp[m-1][1]);
    }

    /**
     * 剑指 Offer II 018. 有效的回文
     * */
    public static boolean isPalindrome(String s) {
        if(s.length()==0) return false;
        int left = 0;
        int right = s.length()-1;
        while(left<right ){
            char le = s.charAt(left);
            char ri = s.charAt(right);

            if( !(le>=48 && le<=57) && !(le>=65 && le<=90) && !(le>=97 && le<=122)){
                left++;
                continue;
            }
            if( !(ri>=48 && ri<=57) && !(ri>=65 && ri<=90) && !(ri>=97 && ri<=122)){
                right--;
                continue;
            }

            if( (le != ri) && (Math.abs(le-ri) != 32 || le<65 || ri<65 )){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    /**
     * 93. 复原 IP 地址
     * */

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        //记录"."的位置
        int[] record = new int[3];
        backtracking(list, s, 0, record, 1);
        return list;

    }

    private static void backtracking(List<String> list, String s, int count, int[] record, int index){
        if(count ==3){
            if(isValidIp(s.substring(index-1))){
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < record.length; i++) {
                    sb.insert(record[i]+i,".");
                }
                list.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            record[count] = i;
            if(isValidIp(s.substring(count==0?0:record[count-1],record[count]))){
               backtracking(list, s,count+1,record, i+1);
            }
            record[count] = 0;

        }

    }
    private static boolean isValidIp(String str){
        return (str.length() == 1 || !str.startsWith("0")) && (str.length() <= 3) && (Integer.parseInt(str)<=255) ;

    }

    /**
     * 131. 分割回文串
     * */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0) return res;
        backtracking(res, s, new ArrayList<>(), 0);
        return res;
    }
    private static void backtracking(List<List<String>> res,String s, ArrayList<String> list, int start){
        if(start==s.length()){
           res.add(new ArrayList<>(list));
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start,i+1);
            list.add(sub);
            if(isValidPalindrome(sub)) {
                backtracking(res, s, list, i + 1);
            }
            list.remove(list.size() - 1);
        }

    }

    private static boolean isValidPalindrome(String str){
        int left = 0; int right = str.length()-1;
        while (left<right){
            if(str.charAt(left)!= str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 98. 验证二叉搜索树
     * 中序遍历 入栈
     * */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> l = new LinkedList<>();

        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            l.add(root);
            root = root.right;
        }

        TreeNode r = l.pop();
        while(!l.isEmpty()){
            if(r.val >= l.peekFirst().val){
                return false;
            }
            r = l.pop();
        }
        return true;
    }

    /**
     * 2016. 增量元素之间的最大差值
     * */
    public static int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]-min);
            min = Math.min(nums[i],min);
        }
        return max<=0?-1:max;
    }

    /**
     * 100. 相同的树
     * */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q== null) return true;

        if(p == null || q == null) return false;
        if(p.val != q.val){ return false;}
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    /**
     * dp[i][j][0]截至到第i个字符， 长度为j+1的子序列合为偶数个数
     * dp[i][j][1]截至到第i个字符， 长度为j+1的子序列合为奇数个数
     * nums[i]>0
     * */
    public static int sumArray(int[] nums, int k){
        int n = nums.length;
        if(nums.length==0) return 0;
        int[][][] dp = new int[n][k][2];
        dp[0][0][0] = nums[0]%2==0? 1:0;
        dp[0][0][1] = nums[0]%2==0? 0:1;

        for (int i = 1; i < n; i++) {
            if(nums[i]%2 == 0){
                dp[i][0][0] = dp[i-1][0][0] + 1;
                dp[i][0][1] = dp[i-1][0][1];
            }else {
                dp[i][0][0] = dp[i-1][0][0];
                dp[i][0][1] = dp[i-1][0][1] + 1;
            }

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if(nums[i]%2==0){
                    dp[i][j][0] = dp[i-1][j-1][0] + dp[i-1][j][0];
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j-1][1];
                }else {
                    dp[i][j][0] = dp[i-1][j-1][1] + dp[i-1][j][0];
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j-1][0];
                }
            }
        }

        return dp[n-1][k-1][0];
    }

    /**
     * 187. 重复的DNA序列
     * */
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10 || s.length() > 10000) return new ArrayList<>();
        Set<String> set = new HashSet<>(), res = new HashSet<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i <= chs.length - 10; i++) {
            String str = String.valueOf(chs, i, 10);
            if (!set.add(str)) res.add(str);
        }
        return new ArrayList<>(res);
    }

    /**
     * 面试题 17.16. 按摩师
     * */
    public static int massage(int[] nums) {
        if(nums.length==0) return 0;
        int choose = nums[0];
        int notChoose = 0;
        for (int i = 1; i < nums.length; i++) {
            int tem = choose;
            choose = Math.max(choose,notChoose + nums[i]);
            notChoose = Math.max(tem, notChoose);
        }
        return Math.max(choose,notChoose);

    }

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * */
    public int[] levelOrder2(TreeNode root) {
        if (root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left !=null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            list.add(node.val);

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 441. 排列硬币
     * */

    public static int arrangeCoins(int n) {

        if (n == 1) return 1;
        int t = (int) Math.sqrt((long) 2 * n);
        while (t * (t + 1) > 2 * n) {
            t--;
        }
        return t;
    }

    /**
     * 230. 二叉搜索树中第K小的元素
     * */
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count =0;
        while (root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count ++;
            if(count == k) {
                return root.val;
            }

            root = root.right;
        }
        return 0;
    }


    /**
     *
     * */

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, 1);
        }

        for (int j : nums2) {
            if (map.putIfAbsent(j, 2) != null && map.get(j) == 1) {
                l.add(j);
                map.put(j, 10);
            }
        }

        for (int j : nums3) {
            if (map.putIfAbsent(j, 3) != null && (map.get(j) == 1 || map.get(j) == 2)) {
                l.add(j);
                map.put(j, 20);
            }
        }

        return l;

    }


    /**
     *
     * */

    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = grid[0][0]%x;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]%x!=mod){
                    return -1;
                }
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);

        int s = list.get(m*n/2);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += Math.abs(list.get(i)- s)/x;
        }
        return count;
    }

    /**
     * 101. 对称二叉树
     * */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }
    private static boolean isSymmetric(TreeNode left, TreeNode right){
        if(left ==null && right == null){
            return true;
        }
        if(left ==null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

    /**
     * 501. 二叉搜索树中的众数
     * */
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        Stack<TreeNode> stack = new Stack<>();
        int count =1;
        int val = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        int max = 0;

        while (root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val == val){
                count++;
            }else {
                if(count == max){
                    list.add(val);
                }else if(count > max){
                    max = count;
                    if(val != Integer.MAX_VALUE){
                        list = new ArrayList<>();
                        list.add(val);
                    }
                }
                count = 1;
                val = root.val;
            }
            root = root.right;
        }

        if(count == max){
            list.add(val);
        }else if(count > max){
            if(val != Integer.MAX_VALUE){
                list.clear();
                list.add(val);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 273. 整数转换英文表示
     * */
    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        String[] data2 = new String[]{
                "",
                "Thousand",
                "Million",
                "Billion"
        };
        String[] data = new String[]{
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",

        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
         "Fifteen",
         "Sixteen",
        "Seventeen",
        "Eighteen",
         "Nineteen",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
         "Ninety",
        "Hundred"
        };

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            int n =num%1000;
            if(n!=0){
                StringBuilder tem = numsLessThanOneThousandToString(data,n);
                if(count>0){
                    tem.append(" ").append(data2[count]);
                    if(sb.length()>0){
                        tem.append(" ");
                    }

                }
                sb.insert(0,tem);
            }
            count++;
            num = num/1000;
        }


        return sb.toString();
    }

    private static StringBuilder numsLessThanOneThousandToString( String[] data,
                                                                 int num){
        StringBuilder sb = new StringBuilder();
        if(num>=100){
            sb.append(data[num/100]).append(" ").append("Hundred");
        }
        int lef = num%100;
        if(sb.length()!=0 && lef!=0){
            sb.append(" ");
        }
        if(lef>=20){
            sb.append(  data[lef/10 +18]);
            if(lef%10!=0){
                sb.append(" ").append( data[lef%10]);
            }

        }else if(lef!=0){

            sb.append(data[lef]);

        }
        return sb;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * O(m+n)
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index = 0;
        int[] sum = new int[m+n];
        int j = 0;
        int i = 0;

        while (j<m || i<n){
            if(j==m){
                sum[index] =   nums2[i++];
            }else if(i==n){
                sum[index] =   nums1[j++];
            }else {
                sum[index] = nums1[j] <  nums2[i]? nums1[j++]: nums2[i++];
            }
            index ++;
        }

        return (double)(sum[(m+n)/2] + sum[(m+n-1)/2])/2;
    }

    /**
     * 543. 二叉树的直径
     * */
    private static Integer diameterOfBinaryTreeMax = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return diameterOfBinaryTreeMax;
    }

    private static int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftSize = root.left == null? 0: dfs(root.left) + 1;
        int rightSize = root.right == null? 0: dfs(root.right) + 1;
        diameterOfBinaryTreeMax = Math.max(diameterOfBinaryTreeMax, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }


    /**
     * 95. 不同的二叉搜索树 II
     * */
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return  new LinkedList<>();
        return dfs(1,n);
    }
    private static List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new LinkedList<>();

        if(start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs( start,  i-1);
            List<TreeNode> right =  dfs( i+1,  end);

            for (TreeNode node : left) {
                for (TreeNode treeNode : right) {
                    TreeNode t  = new TreeNode(i);
                    t.left = node;
                    t.right = treeNode;
                    res.add(t);

                }
            }

        }
        return res;
    }

    /**
     * 29. 两数相除
     * */
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor ==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend ^ divisor) > 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        for (int i = 31; i >=0 ; i--) {
            if(a>>i >= b){
                res += 1<<i;
                a -= b<<i;
            }
        }
        return flag? res : -res;

    }

    /**
     * 1325. 删除给定值的叶子节点
     * */
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(root.val == target && root.left ==null && root.right == null) {root = null;}
        return root;

    }

    /**
     * 1372. 二叉树中的最长交错路径
     * */
    int maxLongestZigZag = 0;
    public  int longestZigZag(TreeNode root) {
        longestZigZag(root.left, true);
        longestZigZag(root.right, false);
        return maxLongestZigZag;
    }
    private  int longestZigZag(TreeNode root, boolean left){
        if(root==null) return 0;
        int a = 0;
        int b = 0;
        if(left){
            a = 1+ longestZigZag(root.right,false);
            b = longestZigZag(root.left,true);
        }else {
            a = 1+ longestZigZag(root.left,true);
            b = longestZigZag(root.right,false);
        }
        maxLongestZigZag =Math.max(a,maxLongestZigZag);
        maxLongestZigZag =Math.max(maxLongestZigZag,b);
        return a;
    }

    /**
     * 412. Fizz Buzz
     * */
    public static List<String> fizzBuzz(int n) {
        String[] s = new String[n];
        for (int i=1; i<=n; ++i){
            StringBuilder tmp = new StringBuilder();
            if (i%3 == 0) tmp.append("Fizz");
            if (i%5 == 0) tmp.append("Buzz");
            if (tmp.length() == 0) tmp.append(i);
            s[i-1]= tmp.toString();
        }
        return Arrays.asList(s);
    }

    /**
     * 32. 最长有效括号
     * */
    public static int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()+1];

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1) == '('){
                    dp[i+1]= dp[i-1]+2;
                }else {
                    if(i-1-dp[i]>=0 && s.charAt(i-1-dp[i])=='('){
                        dp[i+1]= dp[i-dp[i]-1] + dp[i]+2;
                    }
                }
                max = Math.max(max, dp[i+1]);

            }

        }
        return max;
    }

    /**
     * 1339. 分裂二叉树的最大乘积
     * */
    public static int maxProduct(TreeNode root) {
        long max = 0;
        List<Integer> list = new ArrayList<>();
        int sum = sumTreeNode(root, list);
        int maxLeft = 0; int minRight = sum;
        for (Integer integer : list) {
            if(integer>=sum/2 && integer<minRight) minRight = integer;
            if(integer<=sum/2 && integer>maxLeft) maxLeft = integer;
        }
        max = Math.max((long) (sum - maxLeft) * (long) maxLeft, (long) (sum - minRight) * (long) minRight);
        return (int)(max%1000000007);
    }

    private static int sumTreeNode(TreeNode root, List<Integer> list){
        if(root == null) return 0;
        int sum= sumTreeNode(root.left, list) + sumTreeNode(root.right, list) + root.val;
        list.add(sum);
        return sum;
    }

    /**
     * 852. 山脉数组的峰顶索引
     * */
    public static int peakIndexInMountainArray(int[] arr) {
        int res = (arr.length)/2;
        int left = 0; int right = arr.length;
        while (true){
            if(arr[res]>arr[res-1] && arr[res]>arr[res+1]){
                return res;
            }
            if(arr[res]>arr[res+1]){ right = res; res = (left + res)/2; }
            if(arr[res]<arr[res+1]){left = res; res = (res + right)/2;}
        }

    }

    /**
     * 99. 恢复二叉搜索树
     * */
    TreeNode pre,one,two;
    public void recoverTree(TreeNode root) {
        recoverTreeRecursion(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
    private void recoverTreeRecursion(TreeNode root) {
        if(root == null || (one!=null && two!=null)) return;
        recoverTreeRecursion(root.left);
        if (pre != null && pre.val > root.val) {
            if (one == null) one = pre;
            two = root;
        }
        pre = root;
        recoverTreeRecursion(root.right);
    }

    /**
     * 38. 外观数列
     * */
    public static String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char left = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if(s.charAt(j) == left ){
                    count ++;
                }else {
                    sb.append(count).append(left);
                    count =1;
                    left = s.charAt(j);
                }
            }
            sb.append(count).append(left);
            s = sb;
        }
        return s.toString();
    }

    /**
     * 97. 交错字符串
     * dp[i][j] S1 0到i 和 S2 0到j 能否组成 S3 0到i+j
     * */
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m =s1.length(), n=s2.length(), l = s3.length();
        if(m + n != l) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            dp[i+1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i+1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = (s2.charAt(j) == s3.charAt(i+j+1)  && dp[i+1][j])
                || (s1.charAt(i) == s3.charAt(i+j+1)  && dp[i][j+1]);
            }
        }
        return dp[m][n];
    }

    /**
     * 76. 最小覆盖子串
     * 滑动窗口
     * */
    public static String minWindow(String s, String t) {

        int i = 0; int j =0;
        //String minString = "";
        int tLength = t.length();
        if(tLength>s.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for (int k = 0; k < tLength; k++) {
            char c = t.charAt(k);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        int maxLeft = 0; int maxRight = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int k = 0; k <s.length(); k++) {
            //count 判断是否当前字符串是否包含所有t的内容
            char c = s.charAt(k);
            if(count <tLength){
                if(map.containsKey(c)){
                    int sum = map.get(c);
                    if(sum>0){
                        count++;
                    }
                    map.put(c,sum-1);
                    if(count == tLength) {maxRight = k;}
                }
            }
            while (count == tLength){
                if(min>maxRight+1 - maxLeft){
                    i = maxLeft;
                    j = maxRight+1;
                    min = maxRight+1-maxLeft;
                }
                char left = s.charAt(maxLeft);
                if(map.containsKey(left)){
                    int sum = map.get(left);
                    if(sum==0){
                        count --;
                    }
                    map.put(left,sum+1);
                }
                maxLeft ++;

            }

        }
        return  s.substring(i,j);
    }

    /**
     * 282. 给表达式添加运算符
     * */

    public static List<String> addOperators(String num, int target) {

        //需要保留加减
        List<String> list = new ArrayList<>();
        backTracking(num, target, list, 0,0,"", 0, 1);
        return list;
    }
    private static void backTracking(String num, long target, List<String> list, long now , int start, String s, long plusInt, long productInt){
        if(start>=num.length() && target == now){
            list.add(s);
            return;
        }
        if(start >= num.length()){
            return;
        }

        for (int i = start; i < num.length(); i++) {
            //int t  = Integer.parseInt(String.valueOf(num.charAt(start)));
            if(i==start){
                int t  = Integer.parseInt(String.valueOf(num.charAt(start)));
                if(t==0){
                    if(start==0){
                        backTracking(num, target, list,  0L, i + 1, 0 + "", 0L, 0L);

                    }else {
                        backTracking(num, target, list, plusInt, i + 1, s + "*" + 0, plusInt, 0L);
                        backTracking(num, target, list, now, i + 1, s + "-" + 0, now, 0L);
                        backTracking(num, target, list, now, i + 1, s + "+" + 0, now, 0L);
                    }
                    return;
                }
            }

            long next = Long.parseLong(num.substring(start,i+1));
            if(start==0){
                backTracking(num, target, list,  next, i + 1, next + "", 0L, next);
            }else {
                    backTracking(num, target, list, plusInt + productInt * next, i + 1, s + "*" + next, plusInt, productInt * next);
                    backTracking(num, target, list, now - next, i + 1, s + "-" + next, now, -1 * next);
                    backTracking(num, target, list, now + next, i + 1, s + "+" + next, now, next);
            }
        }
    }

    /**
     * 剑指 Offer 26. 树的子结构
     * */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        return isSubStructureDfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right, B);
    }
    private static boolean isSubStructureDfs(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null) return false;
        return A.val == B.val && isSubStructureDfs(A.left , B.left) && isSubStructureDfs(A.right , B.right);
    }

    /**
     * 347. 前 K 个高频元素
     * */

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());


        queue.addAll(map.entrySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return res;
    }
    /**
     * 453. 最小操作次数使数组元素相等
     * */
    public static int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(0);
        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

    /**
     * 面试题 17.14. 最小K个数
     * */
    public static int[] smallestK(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    /**
     * 66. 加一
     * */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> l = new LinkedList<>();
        int plus = 1;
        for (int i = n-1; i >= 0; i--) {
            if(digits[i]+plus==10){
                plus=1;
                digits[i] = 0;
            }else {
                digits[i] += plus;
                plus = 0;
            }
            l.add(0,digits[i]);
        }
        if(plus==1) l.add(0,1);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 343. 整数拆分
     * */
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <i ; j++) {
                max = Math.max(max,(i-j) * Math.max(dp[j],j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * 516. 最长回文子序列
     * */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n==1) return 1;
        //从i到j的最长回文子序列
        int[][] dp  = new int[n+1][n+1];
        char[] c = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            int j = i-1;
            while (j>=1){
                if(c[j-1] == c[i-1]){
                    dp[j][i] = dp[j+1][i-1] +2;
                }else {
                    dp[j][i] = Math.max(dp[j][i-1],dp[j+1][i]);
                }
                j--;
            }
        }
        return dp[1][n];

    }


    /**
     * 413. 等差数列划分
     * */
    public static int numberOfArithmeticSlices(int[] nums) {
        int n;
        if( (n = nums.length )== 1 || n ==2 ) return 0;
        int sum = 0;
        int[] dp = new int[2];
        dp[0] = nums[1]- nums[0];
        for (int i = 2; i < nums.length ; i++) {
            if(nums[i] - dp[0] == nums[i-1]){
                dp[1] = dp[1] + 1;
            }else {
                dp[0] = nums[i] - nums[i-1];
            }
            sum += dp[1];
        }
        return sum;

    }

    /**
     * 229. 求众数 II
     * */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        if(n == 1) {l.add(nums[0]); return l;}

        int a = Integer.MAX_VALUE; int b = Integer.MAX_VALUE;
        int countA = 0; int countB = 0;
        for (int num : nums) {

            if ((a == num || countA == 0) && num != b) {
                countA++;
                a = num;
            } else if (b == num || countB == 0) {
                countB++;
                b = num;
            } else {
                countA--;
                countB--;
            }
        }
        int c = 0;
        int d = 0;
        for (int num : nums) {
            if (a == num) c++;
            if (b == num) d++;
        }

        if(c>n/3) l.add(a);
        if(d>n/3) l.add(b);
        return l;
    }

    /**
     * 312. 戳气球
     * */

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] all = new int[n+2];
        all[0]=1; all[n+1] = 1;
        System.arraycopy(nums, 0, all, 1, n);
        int[][] dp = new int[n+2][n+2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            (dp[i][k] + dp[k][j] + all[i] * all[k] * all[j]));
                }
            }
        }
        return dp[0][n+1];
    }

    /**
     * 492. 构造矩形
     * */
    public static int[] constructRectangle(int area) {
        int n = (int) Math.sqrt(area);
        int j = n;
        while (area%j !=0 && area%n !=0){
            j--;n++;
        }

        return  area%j ==0?  new int[]{area/j,j}: new int[]{n,area/n};

    }

    /**
     * 518. 零钱兑换 II
     * */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
    /**
     * 692. 前K个高频单词
     * */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>((o1, o2) -> {

            if(!o2.getValue().equals(o1.getValue())) return o2.getValue()-o1.getValue();
            return o1.getKey().compareTo(o2.getKey());
        });

        queue.addAll(map.entrySet());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Objects.requireNonNull(queue.poll()).getKey());
        }
        return list;
    }

    /**
     * 673. 最长递增子序列的个数
     * */
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        //dp[i][0] dp[i][1] 以nums[i]为结尾最长长度，个数
        int[][] dp = new int[n+1][2];
        dp[1][0] = 1; dp[1][1] = 1;
        int len = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1; dp[i][1] = 1;
            for (int j = 1; j <i; j++) {
                if(nums[i-1]>nums[j-1]){
                    if(dp[j][0]+1>dp[i][0]){
                        dp[i][0] = dp[j][0]+1;
                        dp[i][1] = dp[j][1];
                    }else if(dp[j][0]+1==dp[i][0]){
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if(dp[i][0]> len) {
                len = dp[i][0];
                sum = dp[i][1];
            }else if(dp[i][0] == len){
                sum += dp[i][1];
            }
        }
        return sum;
    }

    /**
     * 1190. 反转每对括号间的子串
     * TODO
     * */
//    public static String reverseParentheses(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] c = s.toCharArray();
//        int i = 0;
//        while (c[i] != ')'){
//            stack.push(c[i]);
//            i++;
//        }
//        for (int j = 0; j < c.length; j++) {
//
//        }
//    }

    /**
     * 638. 大礼包
     * */
    static int minPrice = 0;
    static List<Integer> priceI;
    static List<List<Integer>> specialI;
    static List<Integer> needsI;
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        priceI = price;
        specialI = special;
        needsI = needs;
        int[] now = new int[price.size()];
        //去掉不满足条件的大礼包
        for (int i = 0; i < specialI.size(); i++) {
            List<Integer> list = specialI.get(i);
            for (int j = 0; j < list.size()-1; j++) {
                if(list.get(j)>needsI.get(j)){
                    specialI.remove(list);
                    break;
                }
            }
        }
        for (int i = 0; i < needsI.size(); i++) {
            minPrice += needsI.get(i) * priceI.get(i);
        }
        shoppingOffersDfs(now, 0,0);
        return minPrice;
    }
    private static void shoppingOffersDfs(int[] now, int sum, int d){
        int length = priceI.size();

        for (int i = d; i < specialI.size(); i++) {
            List<Integer> list = specialI.get(i);
            int temSum = sum;
            for (int j = 0; j < length; j++) {
                now[j] += list.get(j);
            }
            sum += list.get(length);
            if(isValidShoppingOffers(needsI,now) && sum<minPrice){
                shoppingOffersDfs( now, sum,  i );
            }
            for (int j = 0; j < length; j++) {
                now[j] -= list.get(j);
            }
            sum = temSum;
        }


        for (int i = 0; i < length; i++) {
            sum += priceI.get(i) *(needsI.get(i) - now[i]);
        }

        minPrice = Math.min(minPrice, sum);
    }

    private static boolean isValidShoppingOffers(List<Integer> needs, int[] now) {
        for (int i = 0; i < needs.size(); i++) {
            if(needs.get(i)<now[i]){ return false;}
        }
        return true;
    }

    /**
     * 463. 岛屿的周长
     * */
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    sum += 4;
                    if(i+1<m && grid[i+1][j] ==1){
                        sum-=2;
                    }
                    if(j+1<n && grid[i][j+1] ==1){
                        sum-=2;

                    }
                }
            }
        }
        return sum;
    }

    /**
     * 207. 课程表
     * BFS
     * */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return false;
        //存储入度个数
        int[] degree = new int[numCourses];
        //存储出度信息
        HashSet<Integer>[] sets  = new HashSet[numCourses];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            degree[p[0]] += 1;
            sets[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 0 ) {queue.add(i);count++;}
        }
        while (!queue.isEmpty()){
            int out = queue.poll();
            for (int success : sets[out]) {
                degree[success] -- ;
                if(degree[success] == 0) {
                    count++;
                    queue.add(success);
                }
            }
        }
        return count == numCourses;

    }

    /**
     * 210. 课程表 II
     * BFS
     * */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        //存储入度个数
        int[] degree = new int[numCourses];
        //存储出度信息
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            degree[p[0]] += 1;
            lists.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] res = new int[numCourses];
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                res[count] = i;
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int out = queue.poll();
            for (int success : lists.get(out)) {
                degree[success]--;
                if (degree[success] == 0) {
                    res[count] = success;
                    count++;
                    queue.add(success);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }

    /**
     * 802. 找到最终的安全状态
     * DFS
     * */
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] flags = new int[n];
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(dfs(graph, flags, i)) {l.add(i);}
        return l;

    }

    private static boolean dfs(int[][] graph, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(Integer j : graph[i])
            if(!dfs(graph, flags, j)) return false;
        flags[i] = -1;
        return true;
    }

    /**
     * 1312. 让字符串成为回文串的最少插入次数
     * */
    public int minInsertions(String s) {
        //s 和 s逆序的公共子序列 和s长度的差
        int l = s.length();

        char[] t1 = s.toCharArray();
        char[] t2 = new char[l];
        for (int i = 0; i < l; i++) {
            t2[l-1-i] = t1[i];
        }

        int[][]dp = new int[l+1][l+1];

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if(t1[i-1] == t2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return s.length() - dp[l][l];
    }

    /**
     * 面试题 08.06. 汉诺塔问题
     * */
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int size = A.size();
        move(size, A, B, C);
    }
    private static void move(int n, List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(A.remove(A.size()-1));
            return;
        }
        move(n-1,A,B,C);
        C.add(A.remove(A.size()-1));
        move(n-1,B,A,C);
    }

    /**
     * 344. 反转字符串
     * */
    public static void reverseString(char[] s) {
        char tem = 0;
        int size = s.length;
        for (int i = 0; i < s.length/2; i++) {
            tem = s[i];
            s[i] = s[size-i-1];
            s[size-i-1] = tem;
        }
    }
    /**
     * 743. 网络延迟时间
     * djstra
     * */
    public static int networkDelayTime(int[][] times, int n, int k) {
        List[] ed = new List[n];
        for (int i = 0;  i< n; i++) {
            ed[i] = new ArrayList<Map<Integer,Integer>>();
        }
        //距离
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k-1] = 0;

        for (int[] edge : times) {
            int[] s = new int[]{edge[1] - 1, edge[2]};
            ed[edge[0] - 1].add(s);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k-1);
        while (!queue.isEmpty()){
            int s = queue.poll();
            for (int i = 0; i < ed[s].size(); i++) {
                int[] time = (int[]) ed[s].get(i);
                int current = dis[s] + time[1];
                if(dis[time[0]]>current){
                    queue.offer(time[0]);
                    dis[time[0]] = current;
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for (int di : dis) {
            if (di == Integer.MAX_VALUE) return -1;
            max = Math.max(max, di);
        }
        return max;

    }

    /**
     *  301. 删除无效的括号
     *  BFS
     * */
    public static List<String> removeInvalidParentheses(String s) {
        Set<String> cur = new HashSet<>();
        List<String> res = new ArrayList<>();
        cur.add(s);
        while (true){
            for (String s1 : cur) {
                if(isValidC(s1)){
                    res.add(s1);
                }
            }
            if(res.size()>0){
                return res;
            }

            Set<String> next = new HashSet<>();
            for (String s1 : cur) {
                char[] chars = s1.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if(i>0 && chars[i] == chars[i-1]){continue;}
                    if(chars[i] =='(' || chars[i] == ')'){
                        next.add(s1.substring(0,i) + s1.substring(i+1));
                    }
                }
            }
            cur = next;

        }
    }
    private static boolean isValidC(String s){
        int flag = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '('){
                flag++;
                continue;
            }
            if(chars[i] == ')'){
                if(flag ==0 ){
                    return false;
                }else {
                    flag--;
                }
            }
        }
        return flag == 0;
    }

    /**
     * 104. 二叉树的最大深度
     * */
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            int s =queue.size();
            while (s>0){
                TreeNode treeNode = queue.poll();
                if(treeNode.left !=null ){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right !=null ){
                    queue.offer(treeNode.right);
                }
                s--;
            }
            level++;
        }
        return level;
    }
    /**
     * 129. 求根节点到叶节点数字之和
     * */
    static Long sumNumbers = 0l;
    public static int sumNumbers(TreeNode root) {
        if(root == null ) return 0;
        return (int) (dfs(root.left,root.val) + dfs(root.right,root.val));
    }

    private static long dfs(TreeNode root, long f){
        if(root==null) return f;
        return 10*f + dfs(root.left,10*f+root.val) + 10*f + dfs(root.right, 10*f+root.val);
    }

    /**
     * 335. 路径交叉
     * 三种情况  4 5 6 条线
     * */
    public static boolean isSelfCrossing(int[] distance) {
        if(distance.length<4) return false;
        for (int i = 3; i < distance.length; i++) {
            if(distance[i]>= distance[i-2] && distance[i-1] <= distance[i-3]) return true;
            if(i>3 && distance[i-1]== distance[i-3] && distance[i] + distance[i-4]>= distance[i-2] ) return true;
            if(i>4 && distance[i-3]>distance[i-5] && distance[i-3]>distance[i-1] && distance[i-2]>distance[i-4] &&
                    distance[i-3] <= distance[i-1] + distance[i-5] && distance[i] + distance[i-4] >= distance[i-2]) return true;

        }
        return false;
    }

    /**
     * 500. 键盘行
     * */

    static Set<Character> set1 = new HashSet<>();
    static Set<Character> set2 = new HashSet<>();
    static Set<Character> set3 = new HashSet<>();
    static {
        String s1 =  "qwertyuiop";
        String s2 =  "asdfghjkl";
        String s3 =  "zxcvbnm";



        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }

        for (int i = 0; i < s3.length(); i++) {
            set3.add(s3.charAt(i));
        }
    }
    public static String[] findWords(String[] words) {




        List<String> l = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i].toLowerCase();
            int i1 = 0; int i2 = 0; int i3 = 0;

            for (int j = 0; j < str.length(); j++) {
                if(j!=i1 && j!=i2 && j!=i3){
                    break;
                }
                if(i1 == j && set1.contains(str.charAt(j))){
                    i1++;
                    continue;
                }
                if(i2 == j && set2.contains(str.charAt(j))){
                    i2++;
                    continue;
                }
                if(i3 == j && set3.contains(str.charAt(j))){
                    i3++;
                }
            }

            if(i1==str.length() || i2==str.length() || i3==str.length()) {
                l.add(words[i]);
            }
             i1 = 0;  i2 = 0;  i3 = 0;

        }
        return l.toArray(new String[0]);
    }

    public static boolean isPerfectSquare(int num) {

        int s = num>>1;
        long a = (long) s *s;
        while(a > num){
            System.out.println(a);
            s = s>>1;
            a = (long) s *s;
        }
        while(s*s<num || s*s == num){
            if(s*s == num){return true;}
            s++;
        }
        return false;

    }


    /**
     * 42. 接雨水
     * 每个节点的雨水等于该节点左右侧最高的最低点 和该节点高的差(不包含自己)
     * */
    public static int trap(int[] height) {
        int n = height.length;
        //左边最大的
        int[] left = new int[n];
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            left[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        int[] right = new int[n];
        int maxR = 0;
        for (int i = n-1; i >=0 ; i--) {
            right[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i],right[i]) - height[i];
        }
        return res;
    }

    /**
     * 114. 二叉树展开为链表
     * */
    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if (root.left!=null){
            TreeNode pre = root.left;
            while (pre.right!=null){
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    /**
     * 128. 最长连续序列
     * 记录每个数字左右两侧的长度
     * */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num:nums){
            int curMax = 0;
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1,0);
                int right = map.getOrDefault(num+1,0);
                curMax = left + right +1;
                maxLength = Math.max(curMax, maxLength);
                map.put(num-left, curMax);
                map.put(num+right, curMax);
                map.put(num, curMax);
            }
        }
        return  maxLength;
    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 用数字start end限制位置更快
     * */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){return null;}
        int rootV = preorder[0];
        TreeNode treeNode = new TreeNode(rootV);
        int size = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootV){
                size = i;
            }
        }
        System.out.println(Arrays.toString(preorder));
        int[] leftP = Arrays.copyOfRange(preorder, 1,size+1);
        int[] lefI = Arrays.copyOfRange(inorder,0, size);

        int[] rightP = Arrays.copyOfRange(preorder, size+1,preorder.length);
        int[] rightI = Arrays.copyOfRange(inorder,size+1, preorder.length);

        treeNode.left = buildTree(leftP, lefI);
        treeNode.right = buildTree(rightP, rightI);
        return treeNode;
    }
    /**
     * 299. 猜数字游戏
     * */
    public static String getHint(String secret, String guess) {

        char[] secretC = secret.toCharArray();
        char[] secretG = guess.toCharArray();
        int sameSize = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if(secretC[i] == secretG[i]){
                sameSize ++;
            }
            map.put(secretC[i],map.getOrDefault(secretC[i],0)+1);
        }
        int size = 0;
        for (int i = 0; i < secret.length(); i++) {
            Integer value = map.get(secretG[i]);
            if(value!=null && value!=0){
                size++;
                map.put(secretG[i], value-1);
            }
        }
        return sameSize+"A" + (size -sameSize) +"B";
    }

    /**
     * 488. 祖玛游戏
     *
     "RRYGGYYRRYYGGYRR"
     "GGBBB" 超时
     TODO
     * */
    int min = 6;
    boolean[] handUsed;
    public  int findMinStep(String board, String hand) {
        int n = hand.length();
        handUsed = new boolean[n];
        dfs(board, hand, 0);
        return min==6?-1:min;
    }

    private  void dfs( String board, String hand, int times){

        if(times>=min){
            return;
        }
        if(board.length()==0){
            min = times;
        }
        int bLength = board.length();
        for (int i = 0; i < hand.length(); i++) {
            if(handUsed[i]){
                continue;
            }
            char c = hand.charAt(i);
            for (int j = 0; j < bLength; j++) {
                if( c == board.charAt(j)){
                    handUsed[i] = true;
                    times++;
                    if(j+1<bLength && board.charAt(j+1) == c  ){
                        Set<String> now = modify(board.substring(0,j)+ board.substring(j+2,bLength));
                        for (String s: now){
                            dfs(s ,hand , times);
                        }
                        j++;
                    }else {
                        Set<String> now = modify(board.substring(0,j)+c+ board.substring(j,bLength));
                        for (String s: now){
                            dfs(s ,hand , times);
                        }
                    }
                    times--;
                    handUsed[i] = false;
                }
            }
        }

    }
    private  Set<String> modify(String now){
        Set<String> set = new HashSet<>();
        int index = 0;
        int count = 0;
        while (index+2<now.length()){
            if(now.charAt(index) == now.charAt(index+1) &&  now.charAt(index) == now.charAt(index+2)){
                set.add(now.substring(0,index) + now.substring(index+3));
                int max = index+3;
                while (max <now.length() && now.charAt(index) == now.charAt(max)){
                    set.add(now.substring(0,index) + now.substring(max));
                    max++;
                }
                set.addAll(modify(now.substring(0,index) + now.substring(max)));
                count++;
            }
            index++;
        }
        if(count==0){ set.add(now); }
        return set;
    }

    /**
     * 629. K个逆序对数组
     * TODO
     * */
//    public static int kInversePairs(int n, int k) {
//
//    }
    /**
     * 375. 猜数字大小 II
     * TODO
     * */
//    public static int getMoneyAmount(int n) {
//
//    }

    /**
     * 677. 键值映射
     * */
    private class MapSum {

        Map<String, Integer> map;
        Map<String, Integer> m;
        public MapSum() {
            map = new HashMap<>();
            m = new HashMap<>();
        }

        public void insert(String key, int val) {
            int d = 0;
            if(m.containsKey(key)){
                d = m.get(key);
            }
            m.put(key,val);

            for (int i = 1; i <=key.length() ; i++) {
                String s= key.substring(0,i);
               map.put(s, map.getOrDefault(s,0) + val -d);
            }


        }

        public int sum(String prefix) {
           return map.getOrDefault(prefix, 0);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int s: asteroids){
            if(stack.size()==0){
                stack.push(s);
            }else{
                if((stack.peek()>0)^(s>0)){
                    while(stack.size()>0 && s!=0){
                        int pop = stack.pop();

                        if(Math.abs(pop)> Math.abs(s)){
                            s=0;
                            stack.push(pop);

                        }else if(Math.abs(pop)== Math.abs(s)){
                            s=0;
                        }
                    }
                    if(stack.size()==0 && s!=0){
                        stack.push(s);
                    }
                }else{
                    stack.push(s);
                }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for(int i=0 ;i<size;i++){
            int p = stack.pollLast();
            System.out.println(p);
            ans[i] = p;
        }
        return ans;
    }

}