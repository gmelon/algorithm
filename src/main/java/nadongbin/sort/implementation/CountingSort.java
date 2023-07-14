package nadongbin.sort.implementation;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 5, 0, 1, 3, 4, 5, 3};
        System.out.println(Arrays.toString(arr));

        sort(arr);
    }

    public static void sort(int[] arr) {
        int max = Arrays.stream(arr)
            .max()
            .orElse(0);
        int[] count = new int[max + 1];

        for (int number : arr) {
            count[number]++;
        }

        System.out.print("[");
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println("]");
    }

}
