package nadongbin.binary_search.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[]{1, 4, 6, 10, 15, 22, 26, 30, 31}, 15, 0, 8));
        System.out.println(loopBinarySearch(new int[]{1, 4, 6, 10, 15, 22, 26, 30, 31}, 10, 0, 8));

        // java api
        List<Integer> list = new ArrayList<>(List.of(1, 4, 6, 10, 15, 22, 26, 30, 31));
        System.out.println(Collections.binarySearch(list, 10)); // 3
        System.out.println(Collections.binarySearch(list, 13)); // -5 (-(insertion point) - 1)

        list.sort(Comparator.reverseOrder());
        System.out.println(Collections.binarySearch(list, 10, Comparator.reverseOrder())); // 5
        System.out.println(Collections.binarySearch(list, 13, Comparator.reverseOrder())); // -6 (-(insertion point) - 1)


    }

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return recursiveBinarySearch(arr, target, mid + 1, end);
        } else {
            return recursiveBinarySearch(arr, target, start, mid - 1);
        }
    }

    public static int loopBinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
