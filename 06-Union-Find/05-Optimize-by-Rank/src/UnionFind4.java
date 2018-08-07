/**
 * 基于 rank 的优化
 * @author youyusong
 * @date 2018/8/7
 */
public class UnionFind4 {

    /**
     * rank[i]表示以 i 为根的集合所表示的树的层数
     */
    private int[] rank;

    private int[] parent;

    private int count;

    public UnionFind4(int count) {
        this.rank = new int[count];
        this.parent = new int[count];
        this.count = count;

        for (int i = 0; i < count; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找元素 p 所对应的集合编号
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素 p 和元素 q 是否所属同一个集合
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素 p 和元素 q 所属的集合
     * @param p
     * @param q
     */
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 将元素个数少的集合合并到元素个数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = parent[qRoot];
            rank[qRoot] += 1;
        }
    }
}
