package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/20.
 * 字典序最小问题
 * 给定长度为N的字符串S，要构造一个长度为N字符串T。T是一个空串，反复执行下列任意操作：
 * ->从S的头部删除一个字符，加到T的尾部；
 * ->从S的尾部删除一个字符，加到T的尾部；
 */
public class StringMin {
    public static void main(String[] args) {
        String str="ACDBCB";
        StringBuilder sb=new StringBuilder();
        int low=0;
        int high=str.length()-1;
        while (low<=high){
            if(str.charAt(low)< str.charAt(high)){
                sb.append(str.charAt(low));
                low++;
            }else {
                sb.append(str.charAt(high));
                high--;
            }
        }
        System.out.println(sb.toString());
    }
}
