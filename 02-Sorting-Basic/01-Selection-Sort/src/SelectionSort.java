/**
 * 选择排序
 * Created by songyouyu on 2018/5/30
 */
public class SelectionSort {

    private SelectionSort() {

    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }



    public static void main(String[] args) {
        int[] arr = {10,9,8,7,5,6,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }



}
