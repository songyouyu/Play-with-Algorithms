import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * 最短路径
 * @author youyusong
 * @date 2018/7/27
 */
public class ShortestPath {

    /**
     * 图的引用
     */
    private Graph G;

    /**
     * 起始点
     */
    private int s;

    /**
     * 记录dfs的过程中节点是否被访问
     */
    private boolean[] visited;

    /**
     * 记录路径, from[i]表示查找的路径上i的上一个节点
     */
    private int[] from;

    /**
     * 记录路径中节点的次序,ord[i]表示i节点在路径中的次序
     */
    private int[] ord;

    /**
     * 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
     * @param graph
     * @param s
     */
    public ShortestPath(Graph graph, int s) {
        this.G = graph;
        assert s >= 0 && s < graph.V();
        this.visited = new boolean[G.V()];
        this.from = new int[G.V()];
        this.ord = new int[G.V()];
        this.s = s;
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }

        /*
         * 无向图最短路径算法,从s开始广度优先遍历所有图
         * 广度优先遍历:
         * 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
         */
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (! q.isEmpty()) {
            int v = q.remove();
            for (int i : G.adj(v)) {
                if (! visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
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

    /**
     * 查看从s点到w点的最短路径的长度,
     * 若从s点到w点不可达,返回-1
     * @param w
     * @return
     */
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
