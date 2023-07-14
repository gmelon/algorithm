package nadongbin.sort.implementation;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 0, 1, 3, 4, 5, 3};
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j > 0; j--) { // j는 1까지만 와야함 -> arr[0] <-> arr[1]과의 비교를 마지막으로 수행 후 종료
                // 현재 값이 이전 원소보다 작으면, 교체하면서 앞으로 나아감
                if (arr[j - 1] > arr[j]) {
                    // swap
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
