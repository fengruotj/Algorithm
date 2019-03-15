package com.hust;

import java.util.ArrayList;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 全排列递归算法 考虑去重复元素
 * 算法思想：求 n 位的字符串的全排列，先确定第 0 位，然后对后面 n-1 位进行全排列，在对 n-1 为进行全排列时，先确定第 1 位，然后对后面的 n-2 位进行全排列...由此得到递归函数和递归的结束条件。
 * 全排列也就是交换位置，到 n-2 位时，就是将 n-2 和 n-1 交换位置。
 */
public class PermutationString_2 {
    private ArrayList<String> list=new ArrayList<>();

    public ArrayList<String> permutationString(String str){
        if(str==null)
            return list;
        permutationStringHelper(str.toCharArray(),0,str.length()-1);
        return list;
    }

    private void permutationStringHelper(char[] chars, int low, int high) {
        if(low == high) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int k = low; k <= high; k++) {
            //添加是否能够swap的判断元素防止重复元素产生
            if(isSwap(chars,low,k)) {
                swap(chars, low, k);
                permutationStringHelper(chars, low + 1, high);
                swap(chars, k, low);
            }
        }
    }

    private void swap(char[] chars, int i, int k) {
        char temp=chars[k];
        chars[k]=chars[i];
        chars[i]=temp;
    }

    private boolean isSwap(char[] chars, int low, int k){
        //左闭又开区间
        for (int i = low; i < k; i++){
            if (chars[i] == chars[k])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationString_2 permutationString=new PermutationString_2();
        ArrayList<String> list = permutationString.permutationString("abb");
        System.out.println(list);
    }

}
