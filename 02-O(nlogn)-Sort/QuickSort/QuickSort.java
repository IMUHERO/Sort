package IMUHERO;
import java.util.*;
public class QuickSort {
    public QuickSort(){}

    public static void sort(Comparable []arr){
        int n=arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(Comparable[]arr,int left,int right){
        if (left>=right)return;

        int middle=parttion(arr,left,right);//parttion的功能是找到当前元素应该放的位置下标
        sort(arr,left,middle);
        sort(arr,middle+1,right);
    }

    private static int parttion(Comparable[]arr,int left,int right){
        //方法中：i是用来知识当前遍历到的元素，最终遍历整个数组
        //v 表示我们选择的元素下标，比如选择第一个元素，那么下标为0
        //j 表示小于v的元素集合的最右边元素
        int v=left;
        Comparable e=arr[v];//存储选择的选择的元素内容
        int j=left;
        //整个排序是：v~j~i~right,其中
        // v+1~j存贮小于e的元素，
        // j+1~i存储大于e的元素，
        // i~right是还没有经过比较的元素
        for (int i=left+1;i<=right;i++){
            if (arr[i].compareTo(e)<0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,v,j);
        return j;
    }

    private static void swap(Comparable []arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
