package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/18.
 * 钢条切割问题
 * Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。公司管理层希望知道最佳的切割方案。
 * 假定我们知道Serling公司出售一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。钢条的长度均为整英寸。
 */
public class BottomUpCutRod {
    public static int cutRod(int prof[], int n){
        if(prof.length==0){
            return 0;
        }
        //dp[i]表示 钢条长度为i时的切割方案的最优解
        int[] dp=new int[prof.length+1];
        dp[0]=0;
        for (int i = 1; i <= prof.length; i++) {
            int maxValue=Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxValue=Math.max(maxValue,prof[j-1]+dp[i-j]);
            }
            dp[i]=maxValue;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = BottomUpCutRod.cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 5);
        System.out.println(i);
    }
}
