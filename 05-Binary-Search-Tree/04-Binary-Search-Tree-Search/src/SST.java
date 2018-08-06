/**
 * 顺序查找表
 * @author youyusong
 * @date 2018/8/6
 */
public class SST<Key extends Comparable<Key>, Value> {

    /**
     * 此顺序查找表，内部本质是一个链表
     */
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    /**
     * 表头
     */
    private Node head;

    /**
     * 顺序查找表中的节点个数
     */
    private int count;

    public SST(){
        head = null;
        count = 0;
    }

    /**
     * 返回顺序查找表中的节点个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回顺序查找表是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 向顺序查找表中插入一个新的 (key, value) 数据对
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {

        // 查看顺序表中是否存在相同大小的 key
        Node node = head;
        while (node != null) {
            // 若找到相同大小的 key,则在顺序表中直接覆盖 value 即可,不需要重新插入
            if (node.key.compareTo(key) == 0) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // 若顺序表中没有同样大小的key，则创建新节点，将新节点直接插在表头
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        count ++;
    }

    /**
     * 查看顺序表中是否包含键为 key 的节点
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        Node node = head;
        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                return true;
            }
            node =node.next;
        }
        return false;
    }

    /**
     * 在顺序表中查找 key 所对应的 value,若 value 不存在，则返回 null
     * @param key
     * @return
     */
    public Value search(Key key) {
        Node node = head;
        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 在顺序查找表中删除键 key 所对应的节点
     * @param key
     */
    public void remove(Key key) {
        if (head == null) {
            return;
        }

        // 若待删除的节点为头节点
        if (key.compareTo(head.key) == 0) {
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            count --;
            return;
        }

        Node node = head;
        while (node.next != null && key.compareTo(node.next.key) != 0) {
            node = node.next;
        }

        // 当代码执行到这一步，并且能够进入 if 条件，则说明 node.next 一定为 key 所对应的节点
        if (node.next != null) {
            Node delNode = node.next;
            node.next = delNode.next;
            delNode.next = null;
            count --;
            return;
        }

    }
}
