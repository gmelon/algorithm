package nadongbin.sort.n1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N1_위에서아래로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int[] sortedArray = Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();

        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

}
