package datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description: 快速排序
 * @Author: zhangkai
 * @Date: 2020/4/22 18:35
 */
public class QuickSortxx {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int privot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < privot) {
                l += 1;
            }
            while (arr[r] > privot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == privot) {
                r -= 1;
            }
            if (arr[r] == privot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
