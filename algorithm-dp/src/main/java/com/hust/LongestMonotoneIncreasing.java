package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/15.
 * 最长单调递增子序列 动态规划
 * 利用动态规划求解，求出状态转移方程。
 * 动态规划法重要的是确定状态与状态转移方程
 * 状态是局部环境下得到的局部解，后项的答案由前面的更小的项决定，前面的更小的项又由更小更小的项决定，直到到达一个边界，这称之为状态转移.
 */
public class LongestMonotoneIncreasing {
    public static int longestMonotoneIncreasing(String str){
        if(str.length()==0)
            return 0;
        int size = str.length();
        //dp[i] 指的就是str中前i个元素的最长单调递增子序列的个数,必须以str[i]结尾
        int dp[]=new int[size+1];
        //dp[i]的值是前面所有小于a[i]的数组的dp[i]的最大值+1；
        int result=Integer.MIN_VALUE;
        for (int i = 1; i <= str.length(); i++) {
            int max=0;
            for (int j = 1; j <= i; j++) {
                if(str.charAt(j-1)<str.charAt(i-1)){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            result=Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = LongestMonotoneIncreasing.longestMonotoneIncreasing("52431");
        System.out.println(i);
    }
}
