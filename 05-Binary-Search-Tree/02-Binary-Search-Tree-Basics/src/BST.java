/**
 * 二分搜索树
 * @author youyusong
 * @date 2018/8/5
 */
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 树的根节点
     */
    private Node root;

    /**
     * 树中元素的个数
     */
    private int count;

    public BST() {
        this.root = null;
        this.count = 0;
    }

    /**
     * 二分搜索树中的节点个数
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 二分搜索树是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
