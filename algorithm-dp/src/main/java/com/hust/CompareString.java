package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 判断一个字符串是否是另一个字符串的字串
 * 可以用动态规划的思想来解决，定义bool函数L( i, j ) 返回子串s[ 0, i ] 是否为 t[ 0, j ] 的子序列。则L( i, j )的状态转换方程为
 */
public class CompareString {
    public boolean compareStrings(String sub, String parent) {
        if(parent==null||sub==null)
            return false;
        return compareStringsHelper(sub,parent,0,0);
    }

    private boolean compareStringsHelper(String sub, String parent, int i, int j) {
        if(i==sub.length()-1)
            return true;
        if(j>=parent.length())
            return false;

        if(parent.charAt(j)==sub.charAt(i)){
            return compareStringsHelper(sub,parent,++i,++j);
        }else
            return compareStringsHelper(sub,parent,i,++j);
    }

    public static void main(String[] args) {
        CompareString compareString=new CompareString();
        boolean b = compareString.compareStrings("A6CD", "ABEFCGD");
        System.out.println(b);
    }
}
