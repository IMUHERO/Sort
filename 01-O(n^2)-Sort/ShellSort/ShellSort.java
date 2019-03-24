package IMUHERO;

public class ShellSort {

    // 我们的算法类不允许产生任何实例
    private ShellSort(){}

    public static void sort(Comparable[] arr){
        int n=arr.length;   //数组长度为n；
        int h=1;    //用来记录步长，步长逐步减小
        while(h<n/3)h=h*3+1;    //1,4,13...
        while(h>=1) {       //注意最小步长为1
            for (int i = h; i < n; i++) {     //从h~n向下遍历元素，逐渐减小步长
                Comparable temp=arr[i];
                int j=i;
                for (;j>=h&&temp.compareTo(arr[j-h])<0;j-=h){
                    arr[j]=arr[j-h];        //将下标为j-h位置的元素移动到j 的位置
                }
                arr[j]=temp;        //注意此处的arr[j]是在j-=h的基础上进行的，将temp存入合适的位置，完成直接插入排序
            }
            h=h/3; //逐渐减小步长，直至h=1；
        }
    }
}
