package com.hust;

import java.util.Arrays;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 对简单选择排序的优化。
 * 1. 将序列构建成大顶堆。
 * 2. 将根节点与最后一个节点交换，然后断开最后一个节点。
 * 3. 重复第一、二步，直到所有节点断开。
 * 算法的时间复复杂度都是O(NlogN) 是一个不稳定的排序方式
 */
public class HeapSort {

    public boolean isLeaf(int length,int pos)
    {
        return pos>length/2-1;
    }

    public void shiftdown(int nums[],int length,int pos)
    {
        while(!isLeaf(length,pos))
        {
            int left=2*pos+1,right=2*pos+2;
            if(right<length)
                left=nums[left]>nums[right]?right:left;

            //需要删除
            if(nums[left]>nums[pos]) return ;
            swap(nums,pos,left);
            pos=left;
        }
    }

    private void swap(int[] nums, int pos, int left) {
        int tmp=nums[pos];
        nums[pos]=nums[left];
        nums[left]=tmp;
    }

    public void buildHeap(int nums[],int length)
    {
        for(int i=length/2-1;i>=0;i--)
        {
            shiftdown(nums,length,i);
        }
    }

    public void heapSort(int nums[])
    {
        for(int i=nums.length;i>0;i--)
        {
            buildHeap(nums,i);
            swap(nums,0,i-1);
            System.out.println(nums[i-1]);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] nums={0,18,79,53,2,87,0,53,199};
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
