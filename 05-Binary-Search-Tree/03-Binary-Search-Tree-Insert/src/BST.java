
/**
 * 二分搜索树节点的插入
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

    /**
     * 向二分搜索树中插入一个新的(key, value)数据对
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 向node为根的节点中，插入新节点
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }
}
