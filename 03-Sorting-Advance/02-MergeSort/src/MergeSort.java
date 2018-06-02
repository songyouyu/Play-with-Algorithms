import java.util.Arrays;

/**
 * 归并排序
 * Created by songyouyu on 2018/6/1
 */
public class MergeSort {

    private MergeSort() {

    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序，对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid + 1...r]进行归并
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // i为左半部分起始索引的位置,j为右半部分起始索引的位置
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k ++) {
            if (i > mid) {              //若左半部分元素已全部处理完
                arr[k] = aux[j - l];
                j ++;
            } else if (j > r) {         // 若右半部分元素已全部处理完
                arr[k] = aux[i - l];
                i ++;
            } else if (aux[i - l] < aux[j - l]) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i ++;
            } else {                              // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 5, 6, 9, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }




}
