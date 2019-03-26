package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by mastertj on 2019/3/26.
 */
//初始化最大堆
public class HeapSort2 {
    private boolean isLeaf(int[] nums,int pos,int length){
        return 2*pos+1>=length;
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
    private void shiftDown(int[] nums,int pos, int length){
        while (!isLeaf(nums,pos,length)){
            int left=2*pos+1;
            int right=2*pos+2;
            if(right<length)
                left=nums[left]>nums[right]?left:right;

            if(nums[left]<=nums[pos])return;

            swap(nums,left,pos);
            pos=left;
        }
    }

    private void buildHeap(int[] nums,int length){
        for (int i = length/2-1; i >=0 ; i--) {
            shiftDown(nums,i,length);
        }
    }

    public void sortHeap(int[] nums){
        for (int i = nums.length; i >0 ; i--) {
            buildHeap(nums,i);
            swap(nums,0,i-1);
            System.out.println(nums[i-1]);
        }
    }

    public static void main(String[] args) {
        HeapSort2 heapSort=new HeapSort2();
        int[] nums={0,18,79,53,2,87,0,53,199};
        heapSort.sortHeap(nums);
        System.out.println(Arrays.toString(nums));
    }
}
