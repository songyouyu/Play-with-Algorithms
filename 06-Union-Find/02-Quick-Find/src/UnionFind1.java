/**
 * @author youyusong
 * @date 2018/8/7
 */
public class UnionFind1 {

    private int[] id;
    private int count;

    public UnionFind1(int n) {
        id = new int[n];
        count = n;
        // 初始化时，每一个 id[i] 指向自己，没有合并的元素
        for (int i = 0; i < n; i ++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * 查看元素 p 和元素 q 是否属于同一个集合
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
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < count; i ++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

}
