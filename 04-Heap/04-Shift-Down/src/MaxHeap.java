/**
 * 从最大堆中取出堆顶元素
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

    /**
     * 从最大堆中取出堆顶元素
     * 取出元素后，直接交换该元素和最后一个元素的位置，此时再确定堆顶元素的位置
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        // 取出的元素
        Item ret = data[1];
        swap(1, count);
        count --;

        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        // 此时该节点一定有孩子节点
        while (2 * k <= count) {
            int j = 2 * k;
            // j + 1 <= count,此时节点k所在的位置一定有右孩子节点
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0) {
                // 此时 k 需要与data[j + 1]进行交换
                j ++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
}
