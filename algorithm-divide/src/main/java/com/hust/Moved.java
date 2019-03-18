package com.hust;

/**
 * locate com.hust
 * Created by MasterTj on 2019/3/18.
 * 汉诺塔　问题
 */
public class Moved {
    private static int count=1;

    /**
     *
     * @param nums 圆盘数量
     * @param a 圆盘初始所在塔座
     * @param b 圆盘将要移动到的塔座
     * @param c 辅助圆盘移动的塔座
     */
    public static void moved(int nums, String a, String b, String c){
        if(nums==1){
            display(1,a,b);
        }else {
            //将i-1根圆盘由A移动到C
            moved(nums-1,a,c,b);
            //将圆盘i 由A移动到B
            display(nums,a,b);
            //将i-1根圆盘由C移动到B
            moved(nums-1,c,b,a);
        }

    }

    public static void display(int nums,String from, String to){
        System.out.println("第"+count+"步：移动第"+nums+"个塔从"+from+"到"+to);
        count++;
    }

    public static void main(String[] args) {
        moved(4, "第一根柱子", "第二根柱子", "第三根柱子");
    }
}
