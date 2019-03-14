package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/14.
 * 动态规划解决01背包问题
 */
public class FindMax01Bag {

    public int findMax01Bag(int[] weights,int[] values, int capacity){
        //获取物品个数
        int N=weights.length;
        int C=capacity;
        //维护一个二维矩阵
        int[][] maxvaule=new int[N][C+1];
        int columns=C+1;
        int rows=N;
        for (int i = 0;i < rows;i++){
            for (int j = 0;j < columns;j++) {
                if (i == 0)
                {//第一行特殊处理，容量能装下，就取当前值。装不下，则取值为0;
                    if (j >= weights[i])
                    {//当前容量能装下第一件物品
                        maxvaule[i][j] = values[i];
                    }
                    else
                    {//当前容量不能装下第一件物品
                        maxvaule[i][j] = 0;
                    }
                }
                else if (j == 0)
                {
                    //因为第一列容量为0，所以也全部置为0
                    maxvaule[i][j] = 0;
                }
                else
                {//后面的值可以用来比较

                    if (j < weights[i])
                    {//如果容量装不下新物品，则当前值直接取上一行当前列的值
                        maxvaule[i][j] = maxvaule[i-1][j];
                    }
                    else
                    {//比较 (装当前物品+剩余容量最大值) 与 (该位置上一行的值) 取最大值为当前值

                        ////分割写法
                        int value1 = values[i] + maxvaule[i - 1][j - weights[i]];//(装当前物品+剩余容量最大值)
                        int value2 = maxvaule[i - 1][j];//(该位置上一行的值)
                        maxvaule[i][j] = value1 > value2 ? value1 : value2;//取最大值为当前值
                    }

                }
            }
        }
        //返回矩阵最后的值
        return maxvaule[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int w[] = new int[]{4, 5, 6, 2, 2};
        int v[] = new int[]{ 6, 4, 5, 3, 6 };
        int capactiy=10;
        FindMax01Bag max01Bag=new FindMax01Bag();
        System.out.println(max01Bag.findMax01Bag(w,v,10));
    }
}
