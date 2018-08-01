/**
 * 向堆中插入元素
 * @author youyusong
 * @date 2018/8/1
 */
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 向最大堆中插入一个元素
     * 直接添加到数组的末尾，然后进行上浮操作
     * @param item
     */
    public void insert(Item item) {
        data[count + 1] = item;
        // 数组中元素的个数，新插入元素的索引
        count ++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        // 当k的值为1时，此时k为最数组中最大值，不需要再比较
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
