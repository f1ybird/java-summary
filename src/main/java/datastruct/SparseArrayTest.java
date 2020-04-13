package datastruct;

/**
 * @Description: 数组 -> 稀疏数组
 * @Author: zhangkai
 * @Date: 2020/4/13 22:19
 */
public class SparseArrayTest {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[0][2] = 1;
        arr[3][1] = 1;

        for (int[] a : arr) {
            for (int item : a) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        //不同值的元素个数
        int sum = 0;
        for (int[] a : arr) {
            for (int item : a) {
                if (item != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("sum元素个数：" + sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }

        for (int[] a : sparseArr) {
            for (int item : a) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
