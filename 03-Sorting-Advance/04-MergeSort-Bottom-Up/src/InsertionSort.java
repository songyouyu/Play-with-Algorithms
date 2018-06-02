public class InsertionSort {

    private InsertionSort() {

    }

    public static void insertionSort(int[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i ++) {
            int e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1] - e > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
}
