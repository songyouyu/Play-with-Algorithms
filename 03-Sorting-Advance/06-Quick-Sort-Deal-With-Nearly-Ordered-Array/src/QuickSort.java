/**
 * 随机化快速排序
 * Created by songyouyu on 2018/6/1
 */
public class QuickSort {

    private QuickSort() {

    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用快速排序，对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r) {

        /*
         * 优化部分：随机选取一个值作为v
         * 若需要排序的数组近乎有序，则快速排序发性能很差
         */
        // 随机在arr[l...r]范围中，选择一个数值作为v的值
        swap(arr, l, (int)(Math.random()*(r - l + 1) + l));
        int v = arr[l];

//        // 取数组中第一个元素作比较
//        int v = arr[l];


        int j = l;  // arr[l + 1...j] < v; arr[j + 1...i) > v
        for (int i = l + 1; i <= r; i ++) {
            if (arr[i] < v) {
                j ++;
                if (i != j) {
                    swap(arr, j, i);
                }
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 7, 5, 6, 9, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

    }
}
