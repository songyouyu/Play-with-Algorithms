/**
 * 冒泡排序
 * Created by songyouyu on 2018/5/31
 */
public class BubbleSort {

    private BubbleSort() {

    }

    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i ++) {
//            for (int j = i + 1; j < arr.length; j ++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

//        boolean flag = false;
//        int n = arr.length;
//        do {
//            flag = false;
//            for (int i = 1; i < n ; i ++) {
//                if (arr[i - 1] > arr[i]) {
//                    swap(arr, i - 1, i);
//                    flag = true;
//                }
//            }
//            // 每一趟排序都将最大元素放在了最后一个位置，
//            // 所以下一次排序时，最后的元素可以不用考虑
//            n--;
//        } while (flag);

        int n = arr.length;
        int last; // 最后一次的交换位置
        do {
            last = 0;
            for (int i = 1; i < n; i ++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    // 最后一次交换元素时的位置，下一轮交换中在此之后的元素不再考虑
                    last = i;
                }
            }
            n = last;
        } while (last > 0);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 4, 8, 7, 6};
        sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
