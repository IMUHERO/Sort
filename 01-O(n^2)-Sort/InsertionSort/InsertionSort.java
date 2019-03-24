package IMUHERO;
import java.util.*;
public class InsertionSort {
    public InsertionSort(){};
    public static void Sort(Comparable[]array){
        for (int i=1;i<array.length;i++){
            //判断i之前的元素是否比i大，如果有则交换位置
//            for (int j=i-1;j>=0;j--){
//                if (array[j].compareTo(array[j+1])>0){
//                    swap(array,j,j+1);
//                }
//                else break;
//            }
            //另一种方法(改进)：
            Comparable e=array[i];
            int j=i;
            for (;j>0&&array[j-1].compareTo(e)>0;j--   ){
                    array[j]=array[j-1];
            }
            array[j]=e;
        }
    }

    public static void swap(Object []arr,int i,int j){
        Object tamp=arr[i];
        arr[i]=arr[j];
        arr[j]=tamp;
    }

}
