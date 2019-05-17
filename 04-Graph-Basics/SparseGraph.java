package IMUHERO;

import java.util.Vector;

public class SparseGraph implements Graph{
    Vector<Integer>[]graph;//二维动态数组的初始化
    int n;//节点node
    int e;//边edge
    boolean isDirected;

    SparseGraph(int size, boolean isDirected){
        assert size>=0;
        n=size;
        graph=(Vector<Integer>[]) new Vector[n];
        e=0;
        this.isDirected=isDirected;
        for (int i=0;i<n;i++){
            graph[i]=new Vector<Integer>();
        }
    }

    public int nodeSize(){
        return n;
    }

    public int edgeSize(){
        return e;
    }

    public void addEdge(int v,int w){
        assert (v>0&&v<n&&w>0&&w<n);
            graph[v].add(w);
            if (v!=w&&!isDirected){
                graph[w].add(v);
            }
            e++;
    }

    public boolean hasEdge(int v, int w){
        assert (v>0&&v<n&&w>0&&w<n);
        for (int i:graph[v]){
            if (i==w)return true;
        }
        return false;
    }

    public void  show(){
        for (int i=0;i<n;i++){
            System.out.print("Vertex"+i+":");
            for (int v:graph[i]) System.out.print(v+" ");
            System.out.println();
        }

    }
    public Iterable<Integer>adj(int v){
        assert v>=0&&v<n;
        return graph[v];
    }
}
