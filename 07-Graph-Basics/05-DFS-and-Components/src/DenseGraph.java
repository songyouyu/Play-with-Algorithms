import java.util.Vector;

/**
 * 稠密图 - 临接矩阵
 * @author youyusong
 * @date 2018/7/25
 */
public class DenseGraph implements Graph{

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
    @Override
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
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    /**
     * 返回图中一个顶点的所有临边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i ++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }

    /**
     * 显示图的信息
     */
    @Override
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ) {
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
