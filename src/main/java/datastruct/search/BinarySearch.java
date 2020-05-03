package datastruct.search;

import java.util.ArrayList;

/**
 * @Description: 二分查找
 * @Author: zhangkai
 * @Date: 2020/5/3 14:48
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        //int result = binarySearch(arr, 0, arr.length - 1, 1234);
        ArrayList<Integer> resultList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resultList=" + resultList);
    }

    /**
     * 传统二分查找
     *
     * @param arr     有序数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 查询值
     * @return 查询值的下标
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        if (findVal < midVal) {// 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    /*
     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */
    private static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        ArrayList<Integer> resultList = new ArrayList<>();

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return resultList;
        }

        if (findVal < midVal) {// 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else {
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resultList.add(temp);
                temp -= 1;
            }

            resultList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resultList.add(temp);
                temp += 1;
            }
            return resultList;
        }
    }
}
