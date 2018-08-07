/**
 * @author youyusong
 * @date 2018/8/7
 */
public class UnionFind2 {

    /**
     * 使用一个数组构建一颗指向父节点的树
     * parent[i]表示第 i 个元素所指向的父节点
     */
    private int[] parent;

    /**
     * 元素个数
     */
    private int count;

    public UnionFind2(int count) {
        this.parent = new int[count];
        this.count = count;

        // 初始化时，每一个元素指向自己
        for (int i = 0; i < count; i ++) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素 p 所对应的集合编号
     * @param p
     * @return
     */
    public int find(int p) {
        // 不断查询自己的父亲节点，直到到达根节点
        // 根节点的特征：parent[p] = p
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

        parent[pRoot] = qRoot;
    }
}
