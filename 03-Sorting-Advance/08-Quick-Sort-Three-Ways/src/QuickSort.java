/**
 * 三路快速排序
 * Created by songyouyu on 2018/6/1
 */
public class QuickSort {

    private QuickSort() {

    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    /**
     * 递归使用快速排序，对arr[l...r]的范围进行排序
     */
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l, (int)(Math.random()*(r - l + 1) + l));
        int v = arr[l];
        // arr[l+1...lt] < v
        int lt = l;
        // arr[gt...r] > v
        int gt = r + 1;
        // arr[lt+1...i) == v
        int i = l + 1;
        while (l < gt) {
            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                lt ++;
                i ++;
            } else if (arr[i] == v) {
                i ++;
            } else {
                swap(arr, i, gt - 1);
                gt --;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
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
