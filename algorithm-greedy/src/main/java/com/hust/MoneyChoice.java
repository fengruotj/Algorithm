package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/20.
 * 货币选择问题
 * 分别有1,5,10,50,100元，分别有5,2,2,3,5张纸币。问若要支付k元，则需要多少张纸币？
 */
public class MoneyChoice {
    public static int solve(int k,int[] Money, int []Vaule){
        if(k==0)
            return 0;

        int sum=0;
        for (int i = Vaule.length-1; i >=0 ; i--) {
            int c=Math.min(k/Money[i],Vaule[i]);
            Vaule[i]=Vaule[i]-c;
            k-=c*Money[i];
            sum+=c;
        }
        if(k<0)
            return -1;
        return sum;
    }

    public static void main(String[] args) {
        int Value[]={5,2,2,3,5};
        int Money[]={1,5,10,50,100};
        int solve = solve(200, Money, Value);
        System.out.println(solve);
    }
}
