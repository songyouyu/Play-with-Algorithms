/**
 * @author youyusong
 * @date 2018/7/28
 */
public interface WeightedGraph<Weight extends Number & Comparable> {

     int V();

     int E();

     void addEdge(Edge<Weight> e);

     boolean hasEdge( int v , int w );

     void show();

     Iterable<Edge<Weight>> adj(int v);

}
