import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LiuWen
 * @date 2019-11-27 20:11
 * @problem 按照另一个数组排序
 * @link http://172.19.241.251/problem/sea_5
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- > 0) {
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];
            for (int i = 0; i < len1; i++) {
                arr1[i] = scanner.nextInt();
            }
            for (int i = 0; i < len2; i++) {
                arr2[i] = scanner.nextInt();
            }
            int[] res = sortedByOtherArray(arr1, arr2);
            for (int k = 0; k < res.length; k++) {
                if (k == res.length - 1) {
                    System.out.println(res[k]);
                } else {
                    System.out.print(res[k] + " ");
                }
            }
        }
        scanner.close();
    }

    private static int[] sortedByOtherArray(int[] arr1, int[] arr2) {
        // 可交换的位置
        int p = 0;
        for (int j = 0; j < arr2.length; j++) {
            // 遍历arr2查看arr1中与arr2中相同的元素
            for (int i = 0; i < arr1.length; i++) {
                // 如果arr1中有元素和arr2相同
                if (arr2[j] == arr1[i]) {
                    swap(arr1, p++, i);
                }
            }
        }
        // 对p-arr1.length之间的元素进行排序
        for (int i = arr1.length - 1; i > p; i--) {
            for (int j = p; j < i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    swap(arr1, j, j + 1);
                }
            }
        }
        return arr1;
    }
    
    /**
     * 交换数组元素
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}