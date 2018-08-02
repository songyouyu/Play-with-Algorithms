/**
 * 优化的堆排序：不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
 * @author youyusong
 * @date 2018/8/2
 */
public class HeapSort3 {

    private HeapSort3(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;

        // 此时我们的堆是从0开始索引的,从(最后一个元素的索引-1)/2开始,最后一个元素的索引 = n-1
        // 将数组构建成了一个堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i --) {
            shiftDown(arr, n ,i);
        }

        for (int i = n - 1; i > 0; i --) {
            swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];
        // 此时该节点一定有孩子节点
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            // j + 1 <= count,此时节点k所在的位置一定有右孩子节点
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0) {
                // 此时 k 需要与data[j + 1]进行交换
                j ++;
            }
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

}
