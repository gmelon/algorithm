package nadongbin.sort.implementation;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 0, 1, 3, 4, 5, 3};
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // i번째 원소를 정렬하려고 함
            int curMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // i + 1 ~ 끝 까지 원소 중 가장 작은 원소를 찾음
                if (arr[j] < arr[curMinIndex]) {
                    curMinIndex = j;
                }
            }
            // i + 1 ~ 끝까지 원소 중 가장 작은 원소를 i번째에 넣기
            int temp = arr[curMinIndex];
            arr[curMinIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
