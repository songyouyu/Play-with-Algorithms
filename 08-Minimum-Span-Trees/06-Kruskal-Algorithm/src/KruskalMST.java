import java.util.Vector;

/**
 * Kruskal算法求最小生成树
 * @author youyusong
 * @date 2018/7/28
 */
public class KruskalMST<Weight extends Number & Comparable> {

    /**
     * 最小生成树所包含的所有边
     */
    private Vector<Edge<Weight>> mst;

    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    public KruskalMST(WeightedGraph graph) {
        mst = new Vector<>();

        // 将图中的所有边存放到一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<>( graph.E());
        for (int i = 0; i < graph.V(); i ++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (e.v() <= e.w()) {
                    pq.insert(e);
                }
            }
        }
        // 创建一个并查集, 来查看已经访问的节点的联通情况
        UnionFind uf = new UnionFind(graph.V());
        while (! pq.isEmpty() && mst.size() < graph.V() - 1) {
            // 从最小堆中依次从小到大取出所有的边
            Edge<Weight> e = pq.extractMin();
            // 如果该边的两个点是联通的,则说明加入这条边会产生环,需要丢弃
            if (uf.isConnected(e.v(), e.w())) {
                continue;
            }
            // 不是联通的,则把这条边添加进最小生成树,并记录这条边的两个点为联通状态
            mst.add(e);
            uf.unionElements(e.v(), e.w());
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ ) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    /**
     * 返回最小生成树的所有边
     * @return
     */
    public Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    /**
     * 返回最小生成树的权值
     * @return
     */
    public Number result(){
        return mstWeight;
    }

}
