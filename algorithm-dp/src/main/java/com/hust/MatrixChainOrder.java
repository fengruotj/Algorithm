package com.hust;

/**
 * locate com.hust
 * Created by mastertj on 2019/3/18.
 * 矩阵链乘法 动态规划
 * 给定n个矩阵构成的一个链<A1,A2,A3,.......An>，其中i=1,2,...n，矩阵A的维数为p(i-1)p(i)，
 * 对乘积 A1A2...An 以一种最小化标量乘法次数的方式进行加全部括号。
 */
public class MatrixChainOrder {
    public static int[] atest ={30,35,15,5,10,20,25};
    public static int[] a={3, 5, 2, 1, 10};
    public static int[] b={2, 7, 3, 6, 10};
    public static int[] c={10, 3, 15, 12, 7, 2};
    public static int[] d={7, 2, 4, 15, 20, 5};
    public static void main(String[] args)
    {
        System.out.println("<3, 5, 2, 1,10>");
        Matrix_Chain_Order(a);
        System.out.println("<2, 7, 3, 6, 10>");
        Matrix_Chain_Order(b);
        System.out.println("<10, 3, 15, 12, 7, 2>");
        Matrix_Chain_Order(c);
        System.out.println("<7, 2, 4, 15, 20, 5>");
        Matrix_Chain_Order(d);

    }

    public static void Matrix_Chain_Order(int[] a){
        int n = a.length-1;
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1];
        int i,j,k,t;

        for (i=0;i<=n;i++)
            m[i][i] = 0;
        for (i=0;i<=n;i++)
            s[i][i] = 0;
        for(t=2; t<=n; t++) //t is the chain length
        {
            for(i=1;i<=n-t+1;i++)//从第一矩阵开始计算，计算长度为t的最小代价
            {
                j = i+t-1;//长度为t时候的最后一个元素
                m[i][j] = 1000000;//初始化为最大代价
                for(k=i;k<=j-1;k++)//寻找最优的k值，使得分成两部分k在i与j-1之间
                {
                    int temp = m[i][k]+m[k+1][j] + a[i-1]*a[k]*a[j];
                    if(temp < m[i][j])
                    {
                        m[i][j] = temp;   //记录下当前的最小代价
                        s[i][j] = k;      //记录当前的括号位置，即矩阵的编号
                    }
                }
            }
        }
        System.out.println("一个最优解为：");
        Display(s,1,n);
        System.out.println("\n计算的次数为：");
        System.out.println(m[1][n]);
    }
    public static void Display(int[][] s,int i,int j)
    {
        if( i == j)
        {
            System.out.print('A');
            System.out.print(i);
        }
        else
        {
            System.out.print('(');
            Display(s,i,s[i][j]);
            Display(s,s[i][j]+1,j);
            System.out.print(')');
        }

    }

}
