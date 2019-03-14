package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 */
public class SequenceSearch {
    public int sequenceSearch(int nums[],int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SequenceSearch sequenceSearch=new SequenceSearch();
        int i = sequenceSearch.sequenceSearch(new int[]{1, 2, 3, 4, 5, 68, 100, 150}, 160);
        System.out.println(i);
    }
}
