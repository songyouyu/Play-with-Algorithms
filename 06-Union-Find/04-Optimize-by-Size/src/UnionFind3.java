/**
 * 基于 size 的优化
 * @author youyusong
 * @date 2018/8/7
 */
public class UnionFind3 {

    private int[] parent;

    /**
     * size[i]表示以 i 为根的集合中元素的个数
     */
    private int[] size;

    private int count;

    public UnionFind3(int count) {
        this.parent = new int[count];
        this.size = new int[count];
        this.count = count;

        for (int i = 0; i < count; i ++) {
            parent[i] = i;
            size[i] = 1;
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
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
