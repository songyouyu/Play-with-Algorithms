/**
 * Created by songyouyu on 2018/6/1
 */
public class ShellSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        /* 关于步长，取值没有统一标准，必须小于size，最后一次步长要为1 */
        int h = 1;
        /* 计算首次步长 */
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                /* 将a[i]插入到a[i-h]、a[i-2h]、a[i-3h]...中 */
                int e = arr[i];
                int j = i;
                for ( ; j >= h && e - arr[j-h] < 0 ; j -= h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }
            /* 计算下一轮步长 */
            h /= 3;
        }
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
