package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 * 希尔排序是一种非常不稳定的排序方法，它的时间复杂度为O(n^（1.3—2）)
 */
public class ShellSort {
    public void shellSort(int nums[]){
        for (int i = nums.length/2; i >0 ; i/=2) {
            shellSortHelper(nums,i);
        }
    }

    private void shellSortHelper(int[] nums, int gep) {
        for (int i = gep; i < nums.length; i+=gep) {
            int j=i;
            while (j>0 && nums[j]<nums[j-gep]){
                int temp=nums[j-gep];
                nums[j-gep]=nums[j];
                nums[j]=temp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort=new ShellSort();
        int[] ints = {7, 6, 10, 2, 5};
        shellSort.shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
