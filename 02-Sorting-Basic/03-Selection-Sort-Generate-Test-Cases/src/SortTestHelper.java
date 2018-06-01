/**
 * Created by songyouyu on 2018/5/31
 */
public class SortTestHelper {

    /**
     * 算法不允许产生实例
     */
    private SortTestHelper() {

    }

    /**
     * 生成有n个元素的随机数组，每个元素的随机范围为[rangeL, rangeR]
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = new Integer((int)(Math.random()*(rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    /**
     * 输出数组
     * @param arr
     */
    public static void printArr(Object arr[]) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        return;
    }

}
