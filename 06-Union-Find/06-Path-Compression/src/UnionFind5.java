/**
 * @author youyusong
 * @date 2018/8/7
 */
public class UnionFind5 {

    /**
     * 使用一个数组构建一棵指向父节点的树
     * parent[i]表示第i个元素所指向的父节点
     */
    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示的树的层数
     */
    private int[] rank;

    public UnionFind5(int count) {
        parent = new int[count];
        rank = new int[count];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找过程,查找元素P所对应的根节点
     * O(h)复杂度,h为树的高度
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        // 不断去查询自己的父节点,直到到达根节点
        // 根节点的特点: parent[p] = p;
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    /**
     *  查看元素p和元素q是否属于同一个集合
     *  O(h)复杂度,h为树的高度
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * O(h)复杂度,h为树的高度
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
