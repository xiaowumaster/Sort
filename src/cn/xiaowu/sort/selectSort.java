package cn.xiaowu.sort;

import java.util.Arrays;

/**
 * @author xiaowu
 * @create 2019-04-02  11:06
 */
/*
* 算法分析
最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)

2、选择排序（Selection Sort）
表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。

选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

2.1 算法描述
n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

1.初始状态：无序区为R[1..n]，有序区为空；
2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
    将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
3.n-1趟结束，数组有序化了
*
* */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 9, 5, 2, 8, 3};
        int[] temp = select(arr);
        System.out.println(Arrays.toString(temp));
    }

    public static int[] select(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //内层遍历是从第i个位置开始判断一直到最后一个，从中选出最小或者最大的数，并将索引赋给minindex
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //得到了最小或者最大数的索引再将该位置的数与i位置的数进行交换，然后i++继续往后寻找
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
