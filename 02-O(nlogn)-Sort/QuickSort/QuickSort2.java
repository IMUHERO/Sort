package IMUHERO;

import java.util.*;

public class QuickSort2 {

   public  QuickSort2(){ }  //构造方法，什么都不做

    //这个方法是公用的，给用户用
    public static void sort(Comparable []arr){
       int length=arr.length;
       sort(arr,0,length-1);
    }

    //这个方法是私有的，程序员在此设计内部函数
    private static void sort(Comparable []arr,int begin,int end){
//        if(begin>=end)return;           //递归结束条件，bengin和end是同一个元素，也就无需排序
        if(end-begin<=15)
        {InsertionSort.sort(arr,begin,end);
        return;}
       int div=parttion(arr,begin,end);     //找到V应该放在的位置
       sort(arr,begin,div-1);             //对前半部分进行递归排序
       sort(arr,div+1,end);      //对后半部分进行递归排序
    }

    //这个方法用于找到V应该放的位置（从小到大）
    private static int  parttion(Comparable[]arr,int begin,int end){
        //@函数使用：Math.random() 方法生成[0, 1)范围内的double类型随机数；
        // @如无特殊需求，则使用(int)(Math.random()*n)的方式生成随机数即可
        swap(arr,begin,(int)(Math.random()*(end-begin+1))+begin ) ;       //将随机选择的数存入当前数组段的头位置中
        Comparable V=arr[begin];     //V作为标记来比较大小

        int i=begin+1;  //i用于从begin到div向后遍历数组
        int j=end;    //j用于从end到向前遍历数组

        while(true){
            while (i<=end&&arr[i].compareTo(V)<0){      //特别注意，此处应该包含=的情况
                i++;
            }

            while (j>begin&&arr[j].compareTo(V)>0){    //特别注意，此处应该包含=的情况
                j--;
            }

            if (i>j)break;

            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,begin,j);              //特别注意，此处应该交换j的值，因为上面swap后i++,j--，此时i指向目标位置的下一个位置，j指向目标位置！
        return j;

    }

    //这个方法用于交换数组中的元素
    private static void swap(Comparable[]arr,int i,int j){
       Comparable temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
    }


}