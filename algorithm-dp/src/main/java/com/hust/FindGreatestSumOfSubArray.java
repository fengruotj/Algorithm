package com.hust;

/**
 * locate com.hust.edu.offer
 * Created by MasterTj on 2019/3/6.
 * 连续子数组的最大和
 * 动态规划
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;

        int maxSum=Integer.MIN_VALUE;
        // dp[i]表示以第i个元素结尾的连续子数组最大
        int dp[]=new int[array.length+1];
        dp[0]=Integer.MIN_VALUE;
        for (int i = 1; i <= array.length; i++) {
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+array[i-1];
            }else
                dp[i]=Math.max(dp[i-1],array[i-1]);
        }
        for (int i = 1; i <= array.length; i++) {
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}
