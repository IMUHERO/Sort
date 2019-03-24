package IMUHERO;
import java.util.*;
public class MergeSort {

    public MergeSort(){};
    //此处定义的插入排序用来优化归并排序
    private static void insertionSort(Comparable[]arr,int left,int right){
        for (int i=left+1;i<=right;i++){
            Comparable temp=arr[i];
            int j=i;
            for (;j>left&&temp.compareTo(arr[j-1])<0;j--){
                    arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
    }
    //用户使用的静态函数，用来归并排序
    public static void  sort(Comparable[]arr){
        int len=arr.length;
        sort(arr,0,len-1);
    }
    //该函数用来向下分割，向上归并，分割到最后一个元素后向上排序和归并
    private static void sort(Comparable[]arr,int left,int right){
        if (right-left<=15){
            insertionSort(arr,left,right);
            return;
        }
        int mid =(left+right)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        if (arr[mid].compareTo(arr[mid+1])>0) {
            merge(arr, left, mid, right);
        }
    }

//    merge方法用于实现归并的排序功能
//    基本的方法是先复制想要排序的两个数组为一个数组，同时定义左半边数组的第一个元素为i,右半边数组的第一个元素为j
//    然后定义原来两个数组最左边第一个元素为K，逐步增大K，比较复制的数组两者的大小，将比较中较小的元素逐渐添加进当前数组
//    完成排序
    private static void merge (Comparable[]arr,int left,int mid,int right){
        //下面的方法将arr中的元素复制到copy中；
        int len=right-left+1;
        Comparable [] copy=new Comparable[len];
        for (int c=left;c<=right;c++){
            copy[c-left]=arr[c];
        }
        //定义k为当前数组的第一个下标，i为复制数组左半边第一个下标，j为复制数组右半边第一个下标：
        //注意右半边第一个元素是mid+1-left；
        int k=left,i=0,j=mid+1-left;
        int copyMid=mid-left;
        int copyRight=right-left;
        //@实现排序：
        //如果左边的下标已经超过了mid，则之间将剩余右边元素拷贝进原数组剩余位置就行
        for (;k<=right;k++) {       //最外层循环判断当前排序是否完成
            if (i > copyMid) {
                arr[k]=copy[j];
                j++;
            }
            else if (j>copyRight){  //注意此处要用else if 不要用if，因为这四种情况是互相排斥的，发生了其中一种；另一种就不会发生
                arr[k]=copy[i];
                i++;
            }
            else if (copy[i].compareTo(copy[j])<0){
                arr[k]=copy[i];
                i++;
            }
            else {
                arr[k]=copy[j];
                j++;
            }
        }

    }


}


