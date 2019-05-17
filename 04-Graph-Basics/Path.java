package IMUHERO;

import java.util.Stack;
import java.util.Vector;

public class Path {
    Graph G;//使用接口，可以的同时应用在稠密图和稀疏图中
    private boolean visited[];//记录是否被遍历过
    private int from[];
    private int start;//表示路径的起始点

    public Path(Graph graph, int s){
        assert s >= 0 && s < G.nodeSize();
        this.G=graph;
        this.visited=new boolean[G.nodeSize()];
        this.from=new int[G.nodeSize()];
        this.start=s;
        for (int i=0;i<G.nodeSize();i++){
            visited[i]=false;//初始时，默认全部都没有遍历过
            from[i]=-1;
        }
        dfs(start);
    }
    private void dfs(int n){
        assert n>=0&&n<G.nodeSize();
        visited[n]=true;
        //遍历n所连接的所有节点，如果没有被visited，则进行dfs
        for (int a:G.adj(n)){
            if (!visited[a]){
                from[a]=n;
                dfs(a);
            }
        }
        //这个遍历方法体现了迭代器的好处，可以不了解底层，对稠密图和稀疏图使用同一种方法进行遍历
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



}
