import java.util.Arrays;

/**
 * 自底向上的归并排序
 * Created by songyouyu on 2018/6/1
 */
public class MergeSortBU {

    private MergeSortBU() {

    }

    public static void sort(int[] arr) {
        int n = arr.length;

        /*
         * 当sz = 1进行第一轮循环时，arr[0]和arr[1]比较，arr[2]和arr[3]比较...
         * 当sz = 2进行第二轮循环时，arr[0],arr[1]和arr[2],arr[3]比较，arr[4],arr[5]和arr[6],arr[7]比较...
         */
        // 对进行merge的元素个数进行遍历
        for (int sz = 1; sz < n; sz += sz) {
            // 每一轮在归并的过程中，起始的元素位置
            for (int i = 0; i < n - sz; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }

        // 对于小数组, 使用插入排序优化
//        for( int i = 0 ; i < n ; i += 16 )
//            InsertionSort.insertionSort(arr, i, Math.min(i+15, n-1) );
//        for( int sz = 16; sz < n ; sz += sz )
//            for( int i = 0 ; i < n - sz ; i += sz+sz )
//                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
//                if( arr[i+sz-1] - arr[i+sz] > 0 )
//                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }


    // 将arr[l...mid]和arr[mid + 1...r]进行归并
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // i为左半部分起始索引的位置,j为右半部分起始索引的位置
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {              //若左半部分元素已全部处理完
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {         // 若右半部分元素已全部处理完
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {                              // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        int[] arr = {1, 3, 2, 4, 7, 5, 6, 9, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
