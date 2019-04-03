package cn.xiaowu.sort;

/**
 * @author xiaowu
 * @create 2019-04-02  11:51
 */

/*
*
* 算法分析
最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　

归并排序（Merge Sort）
和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
若将两个有序表合并成一个有序表，称为2-路归并。

算法描述
1.把长度为n的输入序列分成两个长度为n/2的子序列；
2.对这两个子序列分别采用归并排序；
3.将两个排序好的子序列合并成一个最终的排序序列


* */
public class mergeSort {
    //稳定
        public static void main(String[] args) {
            int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
            System.out.println("排序之前：");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }
            //归并排序
            mergeSort(a,0,a.length-1);
            System.out.println();
            System.out.println("排序之后：");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }
        }

        private static void mergeSort(int[] a, int left, int right) {
            if(left<right){
                int middle = (left+right)/2;
                //对左边进行递归
                mergeSort(a, left, middle);
                //对右边进行递归
                mergeSort(a, middle+1, right);
                //合并
                merge(a,left,middle,right);
            }
        }

        private static void merge(int[] a, int left, int middle, int right) {
            int[] tmpArr = new int[a.length];
            int mid = middle+1; //右边的起始位置
            int tmp = left;
            int third = left;
            while(left<=middle && mid<=right){
                //从两个数组中选取较小的数放入中间数组
                if(a[left]<=a[mid]){
                    tmpArr[third++] = a[left++];
                }else{
                    tmpArr[third++] = a[mid++];
                }
            }
            //将剩余的部分放入中间数组
            while(left<=middle){
                tmpArr[third++] = a[left++];
            }
            while(mid<=right){
                tmpArr[third++] = a[mid++];
            }
            //将中间数组复制回原数组
            while(tmp<=right){
                a[tmp] = tmpArr[tmp++];
            }
        }
}
