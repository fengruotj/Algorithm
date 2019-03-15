package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/15.
 * 求最长公共子序列问题
 * 利用动态规划求解，求出状态转移方程。
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String str1,String str2){
        if(str1.length()==0 || str2.length()==0)
            return 0;
        int size1 = str1.length();
        int size2 = str2.length();
        //dp[i][j] 表示str1的前i个元素和str2的前j个元素的最长公共子序列的个数
        int dp[][]=new int[size1+1][size2+1];
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[size1][size2];
    }

    public static void main(String[] args) {
        int i = LongestCommonSubsequence.longestCommonSubsequence("13456778", "357486782");
        System.out.println(i);
    }
}
