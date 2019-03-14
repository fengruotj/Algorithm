package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 1. 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 2. 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 * 快速排序是由一种不稳定的排序算法，最好的时间复杂度是O(nLogN)，最差时间复杂度是O(n^2)
 * 快速排序不是一个稳定的排序
 */
public class QuickSort {
    public void quickSort(int nums[]){
        quickSortHelper(nums,0,nums.length-1);
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if(start>=end)
            return;
        int low=start;
        int high=end;
        int target=nums[start];
        while (low<high){
            while (low<high && nums[high]>=target){
                high--;
            }
            nums[low]=nums[high];
            while (low<high && nums[low]<=target){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=target;
        quickSortHelper(nums,start,low-1);
        quickSortHelper(nums,low+1,end);
    }

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        int[] ints = {7, 6, 10, 2, 5};
        quickSort.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
