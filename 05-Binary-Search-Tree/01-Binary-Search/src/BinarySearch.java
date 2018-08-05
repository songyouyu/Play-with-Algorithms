/**
 * 二分查找算法
 * @author youyusong
 * @date 2018/8/5
 */
public class BinarySearch {

    /**
     * 非递归方式
     * @param arr
     * @param target
     * @return
     */
    public int find1(Comparable[] arr, Comparable target) {

        // 在arr[l...r中查找target
        int n = arr.length;
        int l = 0;
        int r = n -1;
        while (l <= r) {
            // int mid = (r + l) / 2, 避免出现 l + r 超出Int类型范围
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式
     * @param arr
     * @param target
     * @return
     */
    public int find2(Comparable[] arr, Comparable target) {
        return find2(arr, 0, arr.length - 1, target);
    }

    private int find2(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target.compareTo(arr[mid]) < 0) {
            return find2(arr, l, mid - 1, target);
        } else {
            return find2(arr, mid + 1, r, target);
        }
    }

}
