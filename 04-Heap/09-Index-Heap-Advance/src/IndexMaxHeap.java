
/**
 * 最大索引堆的优化
 * @author youyusong
 * @date 2018/8/2
 */
public class IndexMaxHeap<Item extends Comparable> {

    /**
     * 最大索引堆中的数据
     */
    private Item[] data;

    /**
     * 最大索引堆中的索引,indexes[x] = i 表示索引i在x的位置
     */
    private int[] indexes;

    /**
     * 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
     */
    private int[] reverse;

    private int count;

    private int capacity;

    /**
     * 构造一个空堆，可容纳capacity个元素
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity+1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回索引堆中的元素个数
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 索引堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 获取最大索引堆中的堆顶元素
     * @return
     */
    public Item getMax(){
        assert count > 0;
        return data[indexes[1]];
    }

    /**
     * 获取最大索引堆中的堆顶元素的索引
     * @return
     */
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1]-1;
    }

    /**
     * 获取最大索引堆中索引为i的元素
     * @param i
     * @return
     */
    public Item getItem( int i ){
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i+1];
    }

    /**
     * 向最大索引堆中插入一个元素，新元素的索引为i，元素为item
     * 传入的i对于用户而言是从0开始的
     * @param i
     * @param item
     */
    public void insert(int i, Item item) {
        i ++;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        data[i] = item;
        count ++;
        shiftUp(count);
    }

    /**
     * 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swapIndexes(k, k / 2);
        }
    }

    /**
     * 交换索引堆中的索引i和j
     * @param i
     * @param j
     */
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    /**
     * 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
     * @return
     */
    public Item extractMax() {
        Item ret = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return ret;
    }

    /**
     * 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
     */
    private void shiftDown(int k) {
        while (k / 2 <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j ++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swapIndexes(k, j);
            k = j;
        }
    }

    /**
     * 从最大索引堆中取出堆顶元素的索引
     * @return
     */
    public int extractMaxIndex(){
        assert count > 0;

        int ret = indexes[1] - 1;
        swapIndexes( 1 , count );
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return ret;
    }

    /**
     * 将最大索引堆中索引为i的元素修改为newItem
     * @param i
     * @param newItem
     */
    public void change(int i, Item newItem) {
        i ++;
        data[i] = newItem;
        // data[index[j]] 与 data[i] 相等
//        for (int j = 1; j <= count; j ++) {
//            if (indexes[j] == i) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

}
