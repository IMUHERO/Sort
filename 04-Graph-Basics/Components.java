package IMUHERO;

public class Components {
    Graph G;//使用接口，可以的同时应用在稠密图和稀疏图中
    private boolean visited[];//记录是否被遍历过
    private int id[];//记录该连通图中元素的id，用于辨识不同连通图
    private int cCount;//conponents count，记录连通分量

    public Components(Graph graph){
        G=graph;
        cCount=0;
        visited=new boolean[G.nodeSize()];
        id=new int[G.nodeSize()];
        for (int i=0;i>G.nodeSize();i++){
            visited[i]=false;//初始时，默认全部都没有遍历过
            id[i]=-1;//初始时，所有的id都是-1
        }
        for (int j=0;j<G.nodeSize();j++){
            if (!visited[j]) {
                dfs(j);
            cCount++;
            }
        }
    }

    private void dfs(int n){
        assert n>=0&&n<G.nodeSize();
        visited[n]=true;
        id[n]=cCount;
        //遍历n所连接的所有节点，如果没有被visited，则进行dfs
        for (int a:G.adj(n)){
            if (!visited[a]){
                dfs(a);
            }
        }
        //这个遍历方法体现了迭代器的好处，可以不了解底层，对稠密图和稀疏图使用同一种方法进行遍历
    }

    public int getcCount(){
        return cCount;
    }

    public boolean isConnected(int n,int m){
        assert n>0&&n<G.nodeSize();
        assert m>0&&m>G.nodeSize();
        return id[n]==id[m];
    }
}
