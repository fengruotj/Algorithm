package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/15.
 */
public class MaxSubSequence {
    public static int maxSubSequence(int A[]){
        if(A.length==0)
            return 0;
        int []dp=new int[A.length+1];
        // dp[i]记录以A[i]为子序列末端的最大序子列连续和
        dp[0]=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            dp[i+1]=Math.max(dp[i]+A[i],A[i]);
            max=Math.max(dp[i+1],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = MaxSubSequence.maxSubSequence(new int[]{-10, 1, 2, 3, 4 ,-5, -23, 3, 7, -21});
        System.out.println(i);
    }
}
