package IMUHERO;
import java.util.*;
public class QuickSort3Way {
    public QuickSort3Way(){}

    public static void sort(Comparable[]arr){
        int length=arr.length;
        sort(arr,0,length-1);
    }

    private static void sort(Comparable[]arr,int begin,int end){
        if(end-begin<=15) {
            InsertionSort.sort(arr, begin, end);     //优化方法，当数值小于15的时候使用插入排序
            return;
        }
        int ran=(int)Math.random()*(end-begin)+begin;       //优化方法是，选择随机值作为标定值
        swap(arr,begin,ran);
        Comparable V=arr[begin];    //头元素用于比较
        int lt=begin;       //arr[begin+1...lt]<v
        int gt=end+1;       //arr[gt...end]>v
        int i=begin+1;      //arr[lt+1...i)=v

        while(i<gt){
            if (arr[i].compareTo(V)<0){
                swap(arr,lt+1,i);
                i++;
                lt++;

            }

            if (arr[i].compareTo(V)>0){
                swap(arr,i,gt-1);
                gt--;
            }
            else{
                i++;
            }

        }
        swap(arr,begin,lt);
        //递归调用，排序左右两边的元素
        sort(arr,begin,lt);
        sort(arr,gt,end);
    }

    //这个方法用于交换数组中的元素
    private static void swap(Comparable[]arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
