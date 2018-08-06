/**
 * 二分搜索树前中后序遍历(深度优先遍历)
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

    /**
     * 查看二分搜索树中是否包含key
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 查看二分搜索树中是否包含以node为根的节点，使用递归算法
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key) {
        if (node == key) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 在二分搜索树中搜索键 key 所对应的值，如果该值不存在则返回 null
     * @param key
     * @return
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 在以 node 为根的二分搜索树中搜索键 key 所对应的值，如果该值不存在则返回 null
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行前序遍历, 递归算法(根 左 右)
     * @param node
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历, 递归算法(左 根 右)
     * @param node
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行前序遍历, 递归算法(左 右 根)
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
}
