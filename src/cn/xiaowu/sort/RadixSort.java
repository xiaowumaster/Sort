package cn.xiaowu.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiaowu
 * @create 2019-04-03  15:04
 */


/*
*
* 基数排序（Radix sort）是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
* 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。

将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。

*
*
* 基数排序的时间复杂度是O(k·n)，其中n是排序元素个数，k是数字位数。注意这不是说这个时间复杂度一定优于O(n·log(n))，
* k的大小取决于数字位的选择和待排序数据所属数据类型的全集的大小；k决定了进行多少轮处理，而n是每轮处理的操作数目。

基数排序基本操作的代价较小，k一般不大于logn，所以基数排序一般要快过基于比较的排序，比如快速排序。

最差空间复杂度是O(k·n)
*
* */
public class RadixSort {
    public static int[] radixSorts(int[] A, int n) {
        //基于桶排序的基数排序

        //确定排序的趟数，即排序数组中最大值为809时，趟数为3
        int max=A[0];
        for(int i=0;i<n;i++){
            if(A[i]>max){
                max= A[i];
            }
        }
        //算出max的位数
        int time=0;
        while(max>0){
            max/=10;
            time++;
        }
        //【桶】初始化十个链表作为桶，用户分配时暂存
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<10;i++){
            ArrayList<Integer> Item = new ArrayList<Integer>();
            list.add(Item);
        }

        //进行time次分配和收集
        for(int i=0;i<time;i++){

            //分配元素，按照次序优先，从个位数开始
            for(int j=0;j<n;j++){
                int index = A[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
                list.get(index).add(A[j]);
            }
            //收集元素，一个一个桶地收集
            int count=0;
            //10个桶
            for(int k=0;k<10;k++){
                //每个桶收集
                if(list.get(k).size()>0){

                    for(int a: list.get(k)){
                        A[count]=a;
                        count++;
                    }
                    //清除数据，以便下次收集
                    list.get(k).clear();
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println(Arrays.toString(radixSorts(arr, arr.length)));
    }
}
