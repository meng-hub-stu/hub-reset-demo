package com.mdx.algorithm;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/14 11:36
 **/
public class AlgorithmTest {
    public static void main(String[] args) {
        int[] srcArray = new int[]{1,2,3,4, 10, 12, 32, 21};
        int des = 2;
        binarySearch(srcArray, des);
        bubbleSort(srcArray);
    }

    /**
     * 二分查找法
     * @param srcArray
     * @param des
     * @return
     */
    public static int binarySearch(int[] srcArray, int des) {
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            int middle = (end + start) >>> 1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
            } else if (des < srcArray[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡算法
     * @param arr
     */
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i< arr.length-1; i++) {
            for (int j = 0; j< arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @param arr
     */
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                //将把 arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }

}
