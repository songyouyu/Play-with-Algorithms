/**
 * 稠密图 - 临接矩阵
 * @author youyusong
 * @date 2018/7/25
 */
public class DenseGraph {

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
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        // 初始化时没有任何边
        m = 0;
        this.directed = directed;
        // g初始化为 n*n 的布尔型矩阵,每一个g[i][j]均为false,表示没有任何边
        g = new boolean[n][n];
    }

    /**
     * 返回节点的个数
     */
    public int V() {
        return n;
    }

    /**
     * 返回边的个数
     */
    public int E() {
        return m;
    }

    /**
     * 向图中添加一个边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (! directed) {
            g[w][v] = true;
        }
        m ++;
    }

    /**
     * 图中是否已经有v 到 w的边
     * @param v
     * @param w
     * @return
     */
    private boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
