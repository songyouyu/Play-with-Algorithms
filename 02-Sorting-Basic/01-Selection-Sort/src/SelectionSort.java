/**
 * 选择排序
 * Created by songyouyu on 2018/5/30
 */
public class SelectionSort {

    private SelectionSort() {

    }

    /**
     * 几种排序算法的比较:
     * 冒泡排序: 比较相邻元素,直到序列变为有序为止
     *           第一轮中,第一项元素和第二项元素比较,将大的元素放在后面,然后比较第二项和第三项,将大的放在后面,
     *           以此类推,在首轮结束后,最大的元素已经在最后一项了
     *           随着轮数的越来越多,后面排好序的元素会越来越多,需要排序的元素越来越少,直到排序完成
     *
     * 选择排序: 改进了冒泡排序,减少了交换次数
     *          在第一轮循环中,选择出最小的元素,放在第一个位置,第一轮循环结束后,数据的第一项有序,
     *          第二轮从第二项元素开始,选择最小的元素放在第二项,以此类推
     *
     * 插入排序: 将无序的元素插入到有序的元素序列中,插入后仍然有序,和前两种排序不同,插入排序在排序过程中是
     *          局部排序,随着插入项的增多,有序部分元素的位置会发生改变,而冒泡排序和选择排序每轮确定的元素的位置
     *          是不会发生改变的.
     *          从第二项元素开始,与它前面的元素比较,如果比前一项元素小,则交换他们的位置,保证每一次循环结束后,
     *          此项元素前的元素有序.
     */

    /**
     * 直接选择排序:
     * 第一趟从n个元素中选出元素最小/最大的一个元素放在最前/最后位置,
     * 下一趟从 n-1 元素中选出元素最小/最大的一个元素放在最前/最后位置,
     * 以此类推,经过 n-1 此完成排序
     */

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
