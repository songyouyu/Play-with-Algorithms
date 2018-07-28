import java.util.Vector;

/**
 * 稀疏图 - 临接表
 * @author youyusong
 * @date 2018/7/28
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    /**
     * 节点数
     */
    private int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任何边
        g = (Vector<Edge<Weight>>[])new Vector[n];
        for (int i = 0; i < n; i ++) {
            g[i] = new Vector<Edge<Weight>>();
        }
    }

    /**
     * 返回节点的个数
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 返回边的个数
     */
    @Override
    public int E() {
        return m;
    }

    /**
     * 向图中添加一个边,权值为weight
     * @param e
     */
    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        /*
         * 由于在邻接表的情况, 查找是否有重边需要遍历整个链表.我们的程序允许重边的出现
         */
//        if (hasEdge(v, w)) {
//            return;
//        }

        g[e.v()].add(new Edge<>(e));
        if (e.v() != e.w() && !directed) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m ++;
    }

    /**
     * 图中是否已经有v 到 w的边
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i ++) {
            if (g[v].elementAt(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回图中一个顶点的所有临边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销
     * @param v
     * @return
     */
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >=0 && v < n;
        return g[v];
    }

    /**
     * 显示图的信息
     */
    @Override
    public void show(){
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ) {
                Edge e = g[i].elementAt(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }


}
