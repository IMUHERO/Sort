package IMUHERO;

import java.util.Vector;
public class DenseGraph implements Graph{
    private boolean [][]graph;
    private int n;//节点node
    private int e;//边edge
    private boolean isDirected;

    DenseGraph(int size,boolean isDirected){
        assert size>=0;//保证输入无误
        n=size;
        graph=new boolean[n][n];
        e=0;
        this.isDirected=isDirected;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                graph[i][j]=false;
            }
        }
    }

    public int nodeSize(){
        return n;
    }

    public int edgeSize(){
        return e;
    }

    public void addEdge(int v,int w){
        assert (v>=0&&v<n&&w>=0&&w<n);
        if (!hasEdge(v,w)) {
            graph[v][w] = true;
            if (!isDirected){
                graph[w][v]=true;
            }
            e++;//判断是否已经有连接，以防边的数量统计有误
        }
    }

    public boolean hasEdge(int v, int w){
        assert (v>=0&&v<n&&w>=0&&w<n);
        return graph[v][w];
    }
    public void show(){
        for (int i=0;i<n;i++){
            System.out.print(i+": ");
            for (int j=0;j<n;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < n ; i ++ )
            if( graph[v][i] )
                adjV.add(i);
        return adjV;
    }
}
