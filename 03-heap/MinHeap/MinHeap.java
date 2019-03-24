package IMUHERO;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

public class MinHeap<E extends Comparable> {

    protected E[]arr;
    private int  size;
    private int capacity;

    public MinHeap(int Capacity){
        arr=(E[])new Comparable[Capacity+1];
        this.capacity=Capacity;
        size=0;
    }

    public MinHeap(){
        this(15);
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //添加一个元素
    public void add(E e){
        if (size==0) {
            arr[1] = e;
            size++;         //size=0+1
        }
        else {
            if (size+1==capacity)resize(capacity*2);
            arr[++size]=e;
            shiftUp(size);

        }
    }

    //查找最小的元素
    public E findMin(){
        if (size>0)
            return arr[1];
        else
            throw new IllegalArgumentException("There is no element exist!" );
    }

    //取出最小元素
    public E extractMin(){
        if (size==0) throw new IllegalArgumentException("There is no element exist!" );
        if (size<capacity/2) resize(capacity/2);
        E ret=findMin();
        swap(1,size);
        size--;
        shiftDown(1);
        return ret;


    }

    //辅助函数：上浮函数
    private void shiftUp(int index){
        for (int i=index;i>1&&arr[i].compareTo(arr[parent(i)])<0;i/=2){  //注意此处的i应该÷2，因为是上浮到父亲节点
            //较小的数进行上浮
                swap(parent(i),i);
        }
    }
    //下浮函数
    private void shiftDown(int i){
        while (leftChild(i)<=size){
            int j=leftChild(i); //j代表左右孩子较小那个数的下标
            if (j+1<=size&&arr[j].compareTo(arr[j+1])>0){
                j++;
            }
            if (arr[j].compareTo(arr[i])>=0)break;
                swap(i,j);
                i=j;

        }
    }

    //实现堆的数组从下标1开始
    private int parent(int index){
        return index/2;
    }
    private int leftChild(int index){
        return index*2;
    }
    private int rightChild(int index){
        return index*2+1;
    }

    //交换两个位置的元素
    private void swap(int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void resize(int newCapacity){
        E[]newArr=(E[]) new Comparable[newCapacity];
        for (int i=1;i<=size;i++){
            newArr[i]=arr[i];
        }
        capacity=newCapacity;
        arr=newArr;
    }
}
