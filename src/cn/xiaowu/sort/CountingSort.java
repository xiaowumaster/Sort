package cn.xiaowu.sort;

import java.util.Arrays;

/**
 * @author xiaowu
 * @create 2019-04-03  15:11
 */

/*
*
* 计数排序算法（实际上就是桶排序算法）
*
* 1. 提前必须是已知待排序的关键字为整型且范围已知。
2. 时间复杂度为O(n+k)，n指的是桶的个数，k指的是待排序数组的长度，不是基于比较的排序算法，因此效率非常之高。
3. 稳定性好，这个是计数排序非常重要的特性，可以用在后面介绍的基数排序中。
4. 但需要一些辅助数组，如C[0..k]，因此待排序的关键字范围0~k不宜过大。
* */
public class CountingSort {
    public static int[] countingSorts(int[] A, int n) {
        if(A==null ||n<2){
            return A;
        }
        //找出桶的范围,即通过要排序的数组的最大最小值来确定桶范围
        int min=A[0];
        int max=A[0];
        for(int i=0;i<n;i++){
            min=Math.min(A[i],min);
            max=Math.max(A[i],max);
        }
        //确定桶数组，桶的下标即为需排序数组的值，桶的值为序排序数同一组值出现的次数
        int[] arr = new int[max-min+1];
        //往桶里分配元素
        for(int i=0;i<n;i++){
            arr[A[i]-min]++;
        }

        //从桶中取出元素
        int index=0;
        for(int i=0;i<arr.length;i++){
            while(arr[i]-->0){
                A[index++]=i+min;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println(Arrays.toString(countingSorts(arr, arr.length)));
    }
}
