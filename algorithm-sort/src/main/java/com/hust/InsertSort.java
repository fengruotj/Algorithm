package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 直接插入排序（Straight Insertion Sorting）的基本思想：在要排序的一组数中，
 * 假设前面(n-1) [n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 最好的情况时间复杂度O(n),最差情况时间复杂度为O(n^2) 稳定的排序方式
 */
public class InsertSort {
    public void insertSort(int nums[]){
        for (int i = 1; i < nums.length; i++) {
            int j=i;
            while (j>0 && nums[j]<nums[j-1]){
                int temp=nums[j-1];
                nums[j-1]=nums[j];
                nums[j]=temp;
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort=new InsertSort();
        int[] ints = {7, 6, 10, 2, 5};
        insertSort.insertSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
