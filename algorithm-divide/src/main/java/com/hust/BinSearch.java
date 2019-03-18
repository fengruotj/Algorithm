package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/18.
 * 二分查找算法
 */
public class BinSearch {
    public static int binSearch(int nums[] , int target){
        return binSearchHelper(nums,target,0,nums.length-1);
    }

    public static int binSearchHelper(int[] nums, int target, int left,int right){
        if(left>right)
            return -1;
        int mid=(left+right)/2;
        //比较key值如相等，返回当前位置，否则确认新的查找空间
        if(nums[mid]==target)
            return mid;
        if(nums[mid]<target){
            return binSearchHelper(nums,target,mid+1,right);
        }else
            return binSearchHelper(nums,target,left,mid-1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int pos =binSearch(a, -100);
        System.out.println(pos);
    }
}
