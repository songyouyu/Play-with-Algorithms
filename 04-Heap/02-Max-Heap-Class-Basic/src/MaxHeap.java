
/**
 * 堆的基本结构
 * @author youyusong
 * @date 2018/8/1
 */
public class MaxHeap<Item> {

    private Item[] data;
    private int count;

    /**
     * 构造函数，构造一个空堆，可容纳capacity个元素
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity + 1];
        count = 0;
    }

    /**
     * 返回堆中元素的个数
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 表示堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
