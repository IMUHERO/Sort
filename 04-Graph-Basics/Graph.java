package IMUHERO;

public interface Graph {
    int nodeSize();
    int edgeSize();
    boolean hasEdge(int v, int w);
    void addEdge(int v,int w);
    Iterable<Integer>adj(int v);
    void show();
}
