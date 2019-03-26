package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by mastertj on 2019/3/27.
 */
public class MergeSort2 {
    public void mergetSort(int[]nums,int start,int end){
        if(start>=end)return;
        int mid=(start+end)/2;
        mergetSort(nums,start,mid);
        mergetSort(nums,mid+1,end);
        mergetSortHelper(nums,start,mid,end);
    }

    private void mergetSortHelper(int[] nums, int start, int mid, int end) {
        int[] arr=new int[end+1];
        int index=start;

        int low=start;
        int center=mid+1;
        while (low<=mid && center<=end){
            arr[index++]=nums[low]>nums[center]?nums[center++]:nums[low++];
        }

        while (low<=mid)
            arr[index++]=nums[low++];
        while (center<=end)
            arr[index++]=nums[center++];
        for (int i = start; i <=end ; i++) {
            nums[i]=arr[i];
        }
    }

    public static void main(String[] args) {
        MergeSort2 mergeSort=new MergeSort2();
        int[] ints = {7, 6, 10, 2, 5};
        mergeSort.mergetSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
