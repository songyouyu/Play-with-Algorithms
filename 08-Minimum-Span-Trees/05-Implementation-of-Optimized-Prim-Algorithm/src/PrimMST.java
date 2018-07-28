import java.util.Vector;

/**
 * 使用优化的Prim算法求图的最小生成树
 * @author youyusong
 * @date 2018/7/28
 */
public class PrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph<Weight> G;

    /**
     * 最小索引堆,算法辅助数据结构
     */
    private IndexMinHeap<Weight> ipq;

    /**
     *  访问的点所对应的边, 算法辅助数据结构
     */
    private Edge<Weight>[] edgeTo;

    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;

    /**
     * 最小生成树所包含的所有边
     */
    private Vector<Edge<Weight>> mst;

    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    /**
     * 构造函数, 使用Prim算法求图的最小生成树
     */
    public PrimMST(WeightedGraph graph) {
        this.G = graph;
        assert( graph.E() >= 1 );
        ipq = new IndexMinHeap<>(graph.V());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i ++) {
            edgeTo[i] = null;
            marked[i] = false;
        }
        mst = new Vector<>();

        // prim
        visit(0);
        while (! ipq.isEmpty()) {
            // 使用最小索引堆找出已经访问的边中权值最小的边
            // 最小索引堆中存储的是点的索引, 通过点的索引找到相对应的边
            int v = ipq.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ ) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    /**
     * 访问节点v
     * @param v
     */
    private void visit(int v) {
        assert marked[v] = false;
        marked[v] = true;

        // 将和节点v相连接的未访问的另一节点,和与之相连的边,放入最小堆中
        for (Object item : G.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item;
            int w = e.other(v);
            if (! marked[w]) {
                // 如果从来没有访问过这个节点,那么直接将这个节点和与之相连的边放入索引堆
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    ipq.insert(w, e.wt());
                }
                // 如果访问过,但是现在的边和之前的比较更短,则进行替换
                else if (e.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    /**
     * 返回最小生成树的所有边
     * @return
     */
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    /**
     * 返回最小生成树的权值
     * @return
     */
    Number result(){
        return mstWeight;
    }
}
