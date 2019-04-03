package cn.xiaowu.sort;

/**
 * @author xiaowu
 * @create 2019-04-02  10:56
 */


/*
*
* 冒泡排序是在相邻的两个记录进行比较和交换，每次交换只能上移或下移一个位置，导致总的比较与移动次数较多。
* 快速排序又称分区交换排序，是对冒泡排序的改进，快速排序采用的思想是分治思想。。

算法原理：
(1)从待排序的n个记录中任意选取一个记录（通常选取第一个记录）为分区标准;

(2)把所有小于该排序列的记录移动到左边，把所有大于该排序码的记录移动到右边，中间放所选记录，称之为第一趟排序；

(3)然后对前后两个子序列分别重复上述过程，直到所有记录都排好序。

稳定性：不稳定排序。

时间复杂度： O（nlog2n）至O(n2)，平均时间复杂度为O（nlgn）。

最好的情况：是每趟排序结束后，每次划分使两个子文件的长度大致相等，时间复杂度为O（nlog2n）。

最坏的情况：是待排序记录已经排好序，第一趟经过n-1次比较后第一个记录保持位置不变，并得到一个n-1个元素的子记录；第二趟经过n-2次比较，将第二个记录定位在原来的位置上，并得到一个包括n-2个记录的子文件，依次类推，这样总的比较次数是：

Cmax=∑i=1n−1(n−i)=n(n−1)/2=O(n2)
*
*
* */
public class quick {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //快速排序
        quick(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void quick(int[] a) {
        if(a.length>0){
            quickSort(a,0,a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a,low,high);
            quickSort(a, 0, middle-1);
            quickSort(a, middle+1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基准元素
        while(low<high){
            //找到比基准元素小的元素位置
            while(low<high && a[high]>=temp){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low]<=temp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
}
