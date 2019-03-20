package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/20.
 */
public class ArrayHeap {
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
}
