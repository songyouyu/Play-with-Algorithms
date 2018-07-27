/**
 * 图的接口
 * @author youyusong
 * @date 2018/7/25
 */
public interface Graph {

    int V();
    int E();
    void addEdge( int v , int w);
    boolean hasEdge( int v , int w );
    void show();
    Iterable<Integer> adj(int v);

}
