package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/20.
 * 有n项工作，每项工作分别在Si开始，Ti结束。例如S={1,2,4,6,8}，T={3,5,7,8,10}。
 * 对每项工作，你都可以选择与否，若选择参加，则必须至始至终参加全程参与，且参与工作的时间段不能有重叠。
 * 例如，输入n=5,S={1,2,4,6,8}，T={3,5,7,9,10};输出：3（选取工作为1,3,5）
 */
public class IntervalScheduling {
    public static void main(String[] args) {
        int S[]={1,2,4,6,8};
        int T[]={3,5,7,9,10};
        int n=5;
        int index=0;
        int jobNum=0;
        for (int i = 0; i < S.length; i++) {
            if(index<=S[i]){
                jobNum++;
                index=T[i];
            }
        }
        System.out.println(jobNum);
    }
}
