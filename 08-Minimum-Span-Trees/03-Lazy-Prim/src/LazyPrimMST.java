import java.util.Vector;

/**
 * Prim算法
 * @author youyusong
 * @date 2018/7/28
 */
public class LazyPrimMST<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph<Weight> G;

    /**
     * 最小堆,算法辅助数据结构
     */
    private MinHeap<Edge<Weight>> pq;

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
     * @param graph
     */
    public LazyPrimMST(WeightedGraph<Weight> graph){
        this.G = graph;
        this.pq = new MinHeap<>(G.E());
        this.marked = new boolean[G.V()];
        this.mst = new Vector<>();

        // lazy Prim
        visit(0);
        while (! pq.isEmpty()) {
            // 使用最小堆找出已经访问的边中权值最小的
            Edge<Weight> e = pq.extractMin();
            // 如果这条边的两边都已经访问过,则不再访问
            if (marked[e.v()] && marked[e.w()]) {
                continue;
            }
            // 若两边都没有访问过,则存在最小生成树中
            mst.add(e);

            // 访问和这条边连接的还没有被访问过的节点
            if (! marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }

        // 计算最小生成树的权值
        mstWeight  = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i ++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    /**
     * 访问节点v
     * @param v
     */
    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Edge<Weight> e : G.adj(v)) {
            if (! marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    /**
     * 返回最小生成树的所有边
     * @return
     */
    public Vector<Edge<Weight>> mstEdges(){
        return mst;
    };

    /**
     * 返回最小生成树的权值
     * @return
     */
    public Number result(){
        return mstWeight;
    };

}
