/**
 * 插入排序算法的改进
 * Created by songyouyu on 2018/5/31
 */
public class InsertionSort {

    private InsertionSort() {

    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i ++) {
            int k = arr[i];
            int j;
            for (j = i; j > 0; j --) {
                if (arr[j - 1] > k) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = k;
        }

//        for (int i = 1; i < arr.length; i ++) {
//            int e = arr[i];
//            int j = i;
//            for( ; j > 0 && arr[j-1] - e > 0 ; j--)
//                arr[j] = arr[j-1];
//            arr[j] = e;
//        }
    }

    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
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
