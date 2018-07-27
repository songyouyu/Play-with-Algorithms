import java.util.Stack;
import java.util.Vector;

/**
 * 寻路算法
 * @author youyusong
 * @date 2018/7/27
 */
public class Path {

    /**
     * 图的引用
     */
    private Graph G;

    /**
     * 起始点
     */
    private int s;

    /**
     * 记录dfs过程中节点是否被访问
     */
    private boolean[] visited;

    /**
     * 记录路径,from[i]表示查找的路径上i的上一个节点
     */
    private int[] from;

    /**
     * 寻路算法,寻找图graph从s点到其他点的路径
     * @param graph
     * @param s
     */
    public Path(Graph graph, int s) {
        this.G = graph;

        assert s >= 0 && s < G.V();
        this.s = s;
        // 图中的每一个节点进行初始化
        this.visited = new boolean[G.V()];
        this.from = new int[G.V()];

        for (int i = 0; i < G.V(); i ++) {
            visited[i] = false;
            from[i] = -1;
        }
        // 寻路算法
        dfs(s);
    }

    /**
     * 图的深度优先遍历
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            if (! visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    /**
     * 查询从s点到w点是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    /**
     * 查询从s点到w点的路径,存放在vector中
     * @param w
     * @return
     */
    public Vector<Integer> path(int w) {
        // 确定从s点到w点有路径
        assert hasPath(w);

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        // 从栈中一次取出元素,获得的顺序即为从s点到w点的路径
        Vector<Integer> res = new Vector<>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }

    /**
     * 打印出从s点到w点的路径
     * @param w
     */
    public void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vec = path(w);

        for (int i = 0; i < vec.size(); i ++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1) {
                System.out.println();
            } else {
                System.out.println(" -> ");
            }
        }
    }

}
