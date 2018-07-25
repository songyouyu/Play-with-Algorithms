/**
 * 插入排序
 * Created by songyouyu on 2018/5/31
 */
public class InsertionSort {

    private InsertionSort() {

    }

    /**
     * 插入排序算法思想:
     * 每趟将一个元素,按数据的大小插入到它前面已排好序的数据中,依次重复,直到插入全部元素
     *
     * 插入排序包括:
     * 直接插入排序 二分插入排序 希尔排序
     */

    /**
     * 实时交换相邻元素的位置
     */

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (arr[j] - arr[j -1 ] < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }

//        for (int i = 1; i < arr.length; i ++) {
//            for (int j = i; j > 0 && arr[j] - (arr[j - 1]) < 0; j --) {
//                swap(arr, j, j - 1);
//            }
//        }

    }

    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 8, 7, 6};
        sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

}
