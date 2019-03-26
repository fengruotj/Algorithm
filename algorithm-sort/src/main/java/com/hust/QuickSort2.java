package com.hust;

/**
 * locate com.hust
 * Created by mastertj on 2019/3/26.
 */
public class QuickSort2 {
    public void quickSortHelper(int[] nums,int start,int end){
        if(start<end)return;
        int low=start;
        int high=end;
        int target=nums[start];
        while (low<high){
            while (low<high && nums[high]>target)
                high--;
            nums[low]=nums[high];
            while (low<high && nums[low]>target)
                low++;
            nums[high]=nums[low];
        }
        nums[low]=target;
        quickSortHelper(nums,start,low-1);
        quickSortHelper(nums,low+1,end);
    }
}
