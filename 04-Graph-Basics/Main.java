package IMUHERO;
public class Main {
    public static void main(String[] args) {
        /*
        * 1.以下用于测试readGraph的功能
        * */
        System.out.println("使用稠密图打印图1");
        String file1="testG1.txt";
        Graph dense1=new DenseGraph(13,false);
        readGraph readGraph1=new readGraph(dense1,file1);
        dense1.show();//稠密图展示文本一的连通情况
        System.out.println("使用稀疏图打印图1");
        /*******************************************************/
        Graph sparse1=new SparseGraph(13,false);
        readGraph readGraph12=new readGraph(sparse1,file1);
        sparse1.show();//稀疏图展示文本二的连通情况
        System.out.println();

        System.out.println("使用稠密图打印图2");
        String file2="testG2.txt";
        Graph dense2=new DenseGraph(6,false);
        readGraph readGraph2=new readGraph(dense2,file2);
        dense2.show();//稠密图展示文本一的连通情况
        System.out.println("使用稀疏图打印图2");
        /*********************************************************/
        Graph sparse2=new SparseGraph(6,false);
        readGraph readGraph22=new readGraph(sparse2,file2);
        sparse2.show();
        System.out.println();

        /*
        * 2.以下用于测试Components连通函数
        * */
        Components components1=new Components(dense1);
        System.out.println("文本1中表示的图的连通量是："+components1.getcCount());
        System.out.println("0和5是否连通? "+components1.isConnected(0,5));
        Components components2=new Components(sparse2);
        System.out.println("文本2中表示的图的连通量是："+components2.getcCount());
        System.out.println("0和3是否连通? "+components2.isConnected(0,3));
        System.out.println();

        /*
        * 3.以下用于测试path寻路函数
        * */
        System.out.println("图1中：0->5的路径为：");
        Path path1=new Path(dense1,0);
        path1.showPath(4);
        System.out.println();
        System.out.println("图2中：0->5的路径为：");
        Path path2=new Path(sparse2,0);
        path2.showPath(4);
        System.out.println();

        /*
        * 4.以下函数用于测试最短路径
        * */
        System.out.println();
        System.out.println("图1中：0->4的最短路径为：");
        ShourtestPath spath1=new ShourtestPath(dense1,0);
        spath1.showPath(4);
        System.out.println();
        System.out.println("最短路径长度为："+spath1.shortestL(4));
        System.out.println("图2中：0->4的最短路径为：");
        ShourtestPath spath2=new ShourtestPath(dense2,0);
        spath2.showPath(4);
        System.out.println();
        System.out.println("最短路径长度为："+spath2.shortestL(4));
    }
}
