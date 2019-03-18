package com.hust;

import java.util.ArrayList;
import java.util.Collections;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/18.
 * 给10个数，再给目标数，让找出10个数中和为目标数的下标
 */
public class FindArraySum {
    private ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    private ArrayList<Integer> path=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findArraySum(int nums[],int target){
        ArrayList<Integer> numsList=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
        findArraySumHelper(numsList,visited,target);
        return result;
    }

    public void findArraySumHelper(ArrayList<Integer> numsList, boolean[] visited,int target){
        if(target<numsList.get(0))
            return;
        int index=0;
        ArrayList<Integer> nums=new ArrayList<>();
        while (numsList.get(index)<target && !visited[index]){
            nums.add(index);
            index++;
        }

        for (Integer num : nums) {
            if(!visited[num]) {
                path.add(numsList.get(num));
                visited[num] = true;
                findArraySumHelper(numsList, visited, target - numsList.get(num));
                path.remove(path.size() - 1);
                visited[num] = false;
            }
        }

        if(numsList.get(index)==target && !visited[index]){
            path.add(target);
            result.add(new ArrayList<>(path));
            visited[index]=false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        FindArraySum findArraySum=new FindArraySum();
        ArrayList<ArrayList<Integer>> arraySum = findArraySum.findArraySum(new int[]{2, 3, 4, 5, 6, 7, 8, 10, 20}, 16);
        System.out.println(arraySum);
    }
}
