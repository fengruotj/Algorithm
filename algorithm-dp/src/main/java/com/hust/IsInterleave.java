package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 两个字符串交叉组成第三个字符 动态规划
 */
public class IsInterleave {
    public boolean isInterleave(String str1, String str2, String str3){
        int length1 = str1.length();
        int length2 = str2.length();
        int length3 = str3.length();
        if(length1+length2!=length3)
            return false;

        //dp[i][j] 表示str3可以由str1的前i个和str2的前j个元素组成
        boolean dp[][]=new boolean[length1+1][length2+1];
        dp[0][0]=true;
        for (int i = 1; i <= length1; i++) {
            dp[i][0]=(str1.charAt(i-1)==str3.charAt(i-1));
        }

        for (int i = 1; i <= length2; i++) {
            dp[0][i]=(str2.charAt(i-1)==str3.charAt(i-1));
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if(dp[i-1][j] && str1.charAt(i-1)==str3.charAt(i+j-1)||dp[i][j-1] && str2.charAt(j-1)==str3.charAt(i+j-1)){
                    dp[i][j]=true;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        IsInterleave isInterleave=new IsInterleave();
        boolean interleave = isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }
}
