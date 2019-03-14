package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 常用于取序列中最大最小的几个数时。遍历整个序列，将最小的数放在最前面。遍历剩下的序列，将最小的数放在最前面。
 * 时间复杂度为O(n^2) 稳定的排序方式
 */
public class SelectSort {
    public void selectSort(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            int position=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[position]>nums[j]){
                    //每一轮循环选择最小的数字
                    position=j;
                }
            }

            int temp=nums[position];
            nums[position]=nums[i];
            nums[i]=temp;
        }
    }

    public void swapSort(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectSort shellSort=new SelectSort();
        int[] ints = {7, 6, 10, 2, 5};
        shellSort.selectSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
