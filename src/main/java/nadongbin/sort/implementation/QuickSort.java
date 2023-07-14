package nadongbin.sort.implementation;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 0, 1, 3, 4, 5, 3};
        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            // 원소가 하나일 경우 종료
            return;
        }
        int pivot = start; // 피벗은 첫번째 원소
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // left는 pivot보다 큰 값을 찾는다
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            // right는 pivot보다 작은 값을 찾는다
            while (start < right && arr[right] >= arr[pivot]) {
                right--;
            }
            // left, right모두 탐색 종료
            if (left > right) {
                // 둘이 어긋난 경우
                // pivot과 작은 쪽을 바꾼다
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                // 어긋나지 않은 경우
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 나누어진 부분에 대해 재귀적으로 퀵 소트 수행
        sort(arr, start, right - 1);
        sort(arr, right + 1, end);
    }

}
