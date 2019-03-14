package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 */
public class BinarySearch {
    public int binarSearch(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        int i = binarySearch.binarSearch(new int[]{1, 2, 3, 4, 5, 68, 100, 150}, 160);
        System.out.println(i);
    }
}
