/**
 * 求无权图的联通分量
 * @author youyusong
 * @date 2018/7/26
 */
public class Components {

    /**
     * 图的引用
     */
    Graph G;

    /**
     * 记录dfs的过程中节点是否被访问
     */
    private boolean[] visited;

    /**
     * 记录联通分量的个数
     */
    private int ccount;

    /**
     * 每个节点所对应的联通分量标记
     */
    private int[] id;

    /**
     * 构造函数,求无权图的联通分量
     * @param graph
     */
    public Components(Graph graph) {
        this.G = graph;
        this.visited = new boolean[G.V()];
        this.id = new int[G.V()];
        this.ccount = 0;

        for (int i = 0; i < G.V(); i ++) {
            visited[i] = false;
            id[i] = -1;
        }

        for (int i = 0; i < G.V(); i ++) {
            if (!visited[i]) {
                dfs(i);
                ccount ++;
            }
        }
    }

    /**
     * 图的深度优先遍历:
     * 遍历到一个节点,接着遍历与它相邻的第一个节点,若这个相邻节点还有相邻节点,则继续遍历,
     * 接着遍历与它相邻的第二个节点,以此类推
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    /**
     * 返回图的联通分量个数
     * @return
     */
    public int count() {
        return ccount;
    }

    /**
     * 查询点v和点w是否联通
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

}
