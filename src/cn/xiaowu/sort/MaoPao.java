package cn.xiaowu.sort;

import java.util.Arrays;

/**
 * @author xiaowu
 * @create 2019-03-19  10:33
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 9, 5, 2, 8, 3};
        int[] temp = maopao(arr);
        System.out.println(Arrays.toString(temp));
    }


    /*
    *
 算法步骤：
（1）从数组中第一个数开始，依次与下一个数比较并次交换比自己小的数，直到最后一个数。如果发生交换，则继续下面的步骤，如果未发生交换，
    则数组有序，排序结束，此时时间复杂度为O(n)；
（2）每一轮”冒泡”结束后，最大的数将出现在乱序数列的最后一位。重复步骤（1）。

稳定性：稳定排序。

时间复杂度： O(n)至O(n2)，平均时间复杂度为O(n2)。

最好的情况：如果待排序数据序列为正序，则一趟冒泡就可完成排序，排序码的比较次数为n-1次，且没有移动，时间复杂度为O(n)。

最坏的情况：如果待排序数据序列为逆序，则冒泡排序需要n-1次趟起泡，每趟进行n-i次排序码的比较和移动，即比较和移动次数均达到最大值：
比较次数:Cmax=∑i=1n−1(n−i)=n(n−1)/2=O(n2)
移动次数等于比较次数，因此最坏时间复杂度为O(n2)。
    * */

    public static int[] maopao(int[] arr) {
        //外层循环是用来标识比较结束的位置，每次冒泡到最后的一个数下次就不想需要再进行比较，所以随着i的递增，比较的次数也就不断地减少
        for (int i = 0; i < arr.length; i++) {
            //内层循环是用来比较需要排序的数
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
