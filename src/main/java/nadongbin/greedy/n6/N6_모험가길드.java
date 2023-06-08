package nadongbin.greedy.n6;

import java.util.Arrays;
import java.util.Scanner;

public class N6_모험가길드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        System.out.println(solution(N, arr));
    }

    public static int solution(final int N, final int[] arr) {

        // 오름차순 정렬
        Arrays.sort(arr);

        int groupCount = 0;
        int currentGroupCount = 0;
        for (int fearValue : arr) {
            currentGroupCount++;
            if (fearValue == currentGroupCount) {
                groupCount++;
                currentGroupCount = 0;
            }
        }
        return groupCount;
    }

}
