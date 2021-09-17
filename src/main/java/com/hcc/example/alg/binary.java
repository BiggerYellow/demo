package com.hcc.example.alg;

/**
 * @author huangchunchen
 * @date 2020/9/8 9:09
 * @description
 */
public class binary {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,5,7};
        System.out.println(binarySearch(array, 3));
    }

    public static int binarySearch(int[] array, int num){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (array[mid] < num){
                start = mid + 1;
            }else if (array[mid] > num){
                end = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
