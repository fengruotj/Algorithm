package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 序列中所有元素两两比较，将最大的放在最后面。将剩余序列中所有元素两两比较，将最大的放在最后面。重复第二步，直到只剩下一个数。
 * 冒泡排序的时间复杂度为O(n^2) 冒泡排序是一个稳定的排序
 */
public class BubbleSort {
    public void bubbleSort(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort=new BubbleSort();
        int[] ints = {7, 6, 10, 2, 5};
        bubbleSort.bubbleSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
