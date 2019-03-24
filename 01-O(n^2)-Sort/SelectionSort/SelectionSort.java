package IMUHERO;
/*
* @作者：IMUHERO
* @选择排序的基本原理：
* 遍历选择最小值排序在数组最左边，然后逐渐增加数组下标，数组内的值也逐渐变大，完成排序
* @时间复杂度：O（n^2）
*
* */
import java.util.*;
public class SelectionSort {
    public SelectionSort(){};
    public static void sort(Comparable [] array){
        //第一层循环
        for (int i=0;i<array.length;i++){
            int minIndex=i;
            for (int j=i+1;j< array.length;j++){
                if (array[j].compareTo(array[minIndex])<0)minIndex=j;
            }
            swap(array,minIndex,i);
        }
    }

    public static void swap(Object []arr,int i,int j){
        Object tamp=arr[i];
        arr[i]=arr[j];
        arr[j]=tamp;
    }


}
