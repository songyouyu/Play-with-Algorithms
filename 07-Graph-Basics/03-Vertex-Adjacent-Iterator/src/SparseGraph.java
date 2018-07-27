import java.util.Iterator;
import java.util.Vector;

/**
 * 稀疏图 - 临接表
 * @author youyusong
 * @date 2018/7/25
 */
public class SparseGraph {

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
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任何边
        g = (Vector<Integer>[])new Vector[n];
        for (int i = 0; i < n; i ++) {
            g[i] = new Vector<Integer>();
        }
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

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
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

        for (int i = 0; i < g[v].size(); i ++) {
            if (g[v].elementAt(i) == w) {
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
    public Iterable<Integer> adj(int v) {
        assert v >=0 && v < n;
        return g[v];
    }
}
