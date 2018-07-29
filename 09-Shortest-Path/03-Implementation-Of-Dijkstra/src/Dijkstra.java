import java.util.Stack;
import java.util.Vector;

/**
 * Dijkstra算法求最短路径
 * @author youyusong
 * @date 2018/7/29
 */
public class Dijkstra<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph G;

    /**
     * 起始点
     */
    private int s;

    /**
     * distTo[i]存储从s到i的最短路径
     */
    private Number[] distTo;

    /**
     * 算法运行过程中,标记节点是否被访问
     */
    private boolean[] marked;

    /**
     * form[i]记录最短路径中,到达i点的路径是哪一条
     */
    private Edge<Weight>[] from;

    /**
     * 使用Dijkstra算法求最短路径
     * @param graph
     * @param s
     */
    public Dijkstra(WeightedGraph graph, int s) {
        this.G = graph;
        assert s > 0 && s < G.V();
        this.s = s;
        this.distTo = new Number[G.V()];
        this.marked = new boolean[G.V()];
        this.from = new Edge[G.V()];

        for (int i = 0; i < G.V(); i ++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }

        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());

        // 对起始点s进行初始化
        distTo[s] = 0.0;
        from[s] = new Edge(s, s, (Weight)(Number)0.0);
        ipq.insert(s, (Weight) distTo[s]);
        marked[s] = true;
        while (! ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            for (Object item : G.adj(v)) {
                Edge<Weight> e = (Edge<Weight>) item;
                int w = e.other(v);
                // 如果从s到w的最短距离没有找到
                if (! marked[w]) {
                    // 如果w节点以前没有被访问过,或者被访问过,但是通过当前节点的v到w的距离更短
                    // distTo[v]就是s到v的最短距离
                    if (from[w] == null | distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if (ipq.contain(w)) {
                            ipq.change(w, (Weight) distTo[w]);
                        } else {
                            ipq.insert(w, (Weight) distTo[w]);
                        }
                    }
                }
            }

        }
    }

    /**
     * 返回从s点到w点的最短路径长度
     * @param w
     * @return
     */
    public Number shortestPathTo( int w ){
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    /**
     * 判断从s点到w点是否联通
     * @param w
     * @return
     */
    public boolean hasPathTo( int w ){
        assert w >= 0 && w < G.V() ;
        return marked[w];
    }

    /**
     * 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
     * @param w
     * @return
     */
    public Vector<Edge<Weight>> shortestPath( int w){

        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Weight>> s = new Stack<>();
        Edge<Weight> e = from[w];
        while( e.v() != this.s ){
            s.push(e);
            e = from[e.v()];
        }
        s.push(e);

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Edge<Weight>> res = new Vector<>();
        while( !s.empty() ){
            e = s.pop();
            res.add( e );
        }
        return res;
    }

    /**
     * 打印出从s点到w点的路径
     * @param w
     */
    public void showPath(int w){

        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        Vector<Edge<Weight>> path =  shortestPath(w);
        for( int i = 0 ; i < path.size() ; i ++ ){
            System.out.print( path.elementAt(i).v() + " -> ");
            if( i == path.size()-1 )
                System.out.println(path.elementAt(i).w());
        }
    }
}
