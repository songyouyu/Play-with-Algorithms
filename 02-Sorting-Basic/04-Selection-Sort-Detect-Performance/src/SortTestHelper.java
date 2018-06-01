import java.lang.reflect.Method;

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

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // 通过sortClass获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的类对象获得排序方法
            Method method = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            method.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
