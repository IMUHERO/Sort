package IMUHERO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShourtestPath {
    Graph G;//使用接口，可以的同时应用在稠密图和稀疏图中
    private boolean visited[];//记录是否被遍历过
    private int from[];
    private int start;//表示路径的起始点
    private int []ord;//用来记录当前节点所在的层数，比如：1->6->7,1->2,1就是第一层，6、2是第二层，7是第三层

    public ShourtestPath(Graph graph, int s){
        assert s >= 0 && s < G.nodeSize();
        this.G=graph;
        this.visited=new boolean[G.nodeSize()];
        this.from=new int[G.nodeSize()];
        this.ord=new int [G.nodeSize()];
        this.start=s;
        for (int i=0;i<G.nodeSize();i++){
            visited[i]=false;//初始时，默认全部都没有遍历过
            from[i]=-1;
            ord[i]=-1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s]=true;
        ord[s]=1;
        while (!q.isEmpty()){
            int begin=q.remove();//表示起始点，先移除
            for (int a:G.adj(begin)){
                if (visited[a]!=true){
                    q.add(a);
                    visited[a]=true;
                    from[a]=begin;//a的上一个连接元素是begin
                    ord[a]=ord[begin]+1;//层数+1
                }
            }
        }
    }


    //查找从s到w的路径，将路径存入Vector中
    public Vector<Integer> findPath(int w){
        assert hasPath(w);//确保有路径才能去寻路
        Vector<Integer>retPath=new Vector<>();
        Stack<Integer>stack=new Stack<>();
        int p=w;//用一个替换，最好不要直接用w，会改变他的初始值
        while (p!=-1) {
            stack.push(p);
            p=from[p];
        }

        while (!stack.isEmpty()) {
            retPath.add(stack.pop());
        }
        return retPath;
    }

    public boolean hasPath(int w){
        assert w>0&&w<=G.nodeSize();
        return visited[w];
    }

    public void showPath(int w){
        Vector<Integer>show=new Vector<>();
        show=findPath(w);
        for (int i=0;i<show.size();i++){
            System.out.print(show.get(i));
            if (i<show.size()-1){
                System.out.print("->");
            }
        }
    }

    public int shortestL(int w){
        assert w>=0&&w<G.nodeSize();
        return ord[w];
    }



}
