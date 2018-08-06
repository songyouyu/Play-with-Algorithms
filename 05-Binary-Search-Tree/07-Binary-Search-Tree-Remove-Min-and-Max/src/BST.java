import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树删除最大值 最小值
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

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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

    /**
     * 二分搜索树的层序遍历
     * 从根开始，依次向下，对于每一层从左向右遍历。
     * 层序遍历与先序、中序、后序遍历不同。层序遍历用到了队列，而先、中、后序需要用到栈。
     * 因此，先、中、后序遍历 可以 采用递归方式来实现，而层序遍历则没有递归方式。
     */
    public void levelOrder() {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (! q.isEmpty()) {
            Node remove = q.remove();
            System.out.println(remove.key);

            if (remove.left != null) {
                q.add(remove.left);
            }
            if (remove.right != null) {
                q.add(remove.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小的键值
     * @return
     */
    public Key minimum() {
        Node minNode = minimum(root);
        return minNode.key;
    }

    /**
     * 返回以node为根的二分搜索树的最小键值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大的键值
     * @return
     */
    public Key maximum() {
        Node maximum = maximum(root);
        return maximum.key;
    }

    /**
     * 返回以node为根的二分搜索树的最大键值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node removeNode = node.right;
            node.right = null;
            count --;
            return removeNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node removeNode = node.left;
            node.left = null;
            count --;
            return removeNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
}
