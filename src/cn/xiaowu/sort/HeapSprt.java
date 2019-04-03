package cn.xiaowu.sort;

import java.util.Arrays;

/**
 * @author xiaowu
 * @create 2019-04-03  14:49
 */
/*
* 1.堆是完全二叉树 2.大顶堆：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆。3.小顶堆：
*                                   每个结点的值都大于或等于其左右孩子结点的值，称为小顶堆。
*
* 如果i>1,则双亲是结点[i/2]。也就是说下标i与2i和2i+1是双亲子女关系。 当排序对象为数组时，下标从0开始，
*                                                    所以下标 i 与下标 2i+1和2i+2是双亲子女关系。
* */
public class HeapSprt {
    public static int[] heapSorts(int[] A, int n) {
        //堆排序算法

        int i;
        //先把A[]数组构建成一个大顶堆。
        //从完全二叉树的最下层最右边的非终端结点开始构建。
        for(i=n/2-1;i>=0;i--){
            HeapAdjust(A,i,n);
        }

        //开始遍历
        for(i=n-1;i>0;i--){
            swap(A,0,i);
            //每交换一次得到一个最大值然后丢弃
            HeapAdjust(A,0,i);
        }
        return A;

    }
    //A[i]代表的是下标为i的根结点
    private static void HeapAdjust(int[] A,int i,int n){
        //【注意】这里下标从0开始
        int temp;
        //存储根结点
        temp = A[i];
        //沿根结点的左右孩子中较大的往下遍历,由于完全二叉树特性 i的左子节点2i+1  i的右子节点2i+2
        for(int j=2*i+1;j<n;j=j*2+1){

            if(j<n-1&&A[j]<A[j+1]){
                ++j;
            }

            if(temp>=A[j]){
                break;
            }
            //将子节点赋值给根结点
            A[i] = A[j];
            //将子节点下标赋给i
            i = j;
        }
        //将存储的根结点的值赋给子节点
        A[i] = temp;

    }
    private static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i]=A[j];
        A[j] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println(Arrays.toString(heapSorts(arr, arr.length)));
    }
}
