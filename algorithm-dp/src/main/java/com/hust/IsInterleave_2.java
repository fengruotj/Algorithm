package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 两个字符串交叉组成第三个字符 递归求解
 * 将一个大问题分解成为若干小问题,
 */
public class IsInterleave_2 {
    public boolean isInterleave(String str1, String str2, String str3){
        if(str1==null||str2==null|| str1.length()+str2.length()!=str3.length())
            return false;
        return isInterleaveHelper(str1,str2,str3,0,0,0);
    }

    private boolean isInterleaveHelper(String str1, String str2, String str3, int n, int j, int k) {
        // n j k 分别对应与三个字符串的下标，将str3是否由str2和str1构成的问题，分解成str3的字串是否由str的字串加上str2的字串构成
        if(k==str3.length())
            return true;
        boolean result=false;
        if(n<str1.length() && str1.charAt(n)==str3.charAt(n+j)){
            result=isInterleaveHelper(str1,str2,str3,n+1,j,k+1);
        }
        if(j<str2.length() && str2.charAt(j)==str3.charAt(n+j)){
            result=isInterleaveHelper(str1,str2,str3,n,j+1,k+1);
        }

        return result;
    }

    public static void main(String[] args) {
        IsInterleave_2 isInterleave=new IsInterleave_2();
        boolean interleave = isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(interleave);
    }
}
