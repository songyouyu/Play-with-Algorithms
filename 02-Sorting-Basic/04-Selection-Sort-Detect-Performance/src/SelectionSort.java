/**
 * Created by songyouyu on 2018/5/30
 */
public class SelectionSort {

    private SelectionSort() {

    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort", arr);

        return;

    }
}
