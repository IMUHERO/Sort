package IMUHERO;
import java.util.*;
public class BubbleSort {
    //冒泡排序，每次跟下一位进行对比，将大的元素逐渐浮出
    public BubbleSort (){};
    public static void Sort(Comparable[]arr){
        //i 用作于表示目前已排好的元素
        for (int i=1;i<arr.length;i++){
            //j 用来遍历尚未排序的元素
            for (int j=0;j<arr.length-i;j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(Object []arr,int i,int j){
        Object tamp=arr[i];
        arr[i]=arr[j];
        arr[j]=tamp;
    }
}
