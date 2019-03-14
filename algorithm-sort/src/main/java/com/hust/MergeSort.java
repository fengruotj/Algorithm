package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 速度仅次于快速排序，内存少的时候使用，可以进行并行计算的时候使用。
 * 1. 选择相邻两个数组成一个有序序列。
 * 2. 选择相邻的两个有序序列组成一个有序序列。重复第二步，直到全部组成一个有序序列。
 * 归并排序,是一种稳定的排序是算法这个算法的时间复复杂度都是O(NlogN)
 */
public class MergeSort {
   public void mergeSort(int nums[],int start,int end){
       if(start>=end)return;
       int mid=(start+end)/2;
       mergeSort(nums,start,mid);
       mergeSort(nums,mid+1,end);
       mergeSortHelper(nums,start,mid,end);
   }

    private void mergeSortHelper(int[] nums, int start, int mid, int end) {
        int low=start;
        int arr[]=new int[end+1];
        int center=mid+1;
        int left=start;
        while (left<=mid && center<=end){
            arr[low++]=nums[left]>nums[center]?nums[center++]:nums[left++];
        }

        while (left<=mid){
            arr[low++]=nums[left++];
        }

        while (center<=end){
            arr[low++]=nums[center++];
        }
        for (int i = start; i <= end; i++) {
            nums[i]=arr[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] ints = {7, 6, 10, 2, 5};
        mergeSort.mergeSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
