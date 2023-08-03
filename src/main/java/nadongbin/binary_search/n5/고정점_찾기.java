package nadongbin.binary_search.n5;

import java.util.Scanner;

public class 고정점_찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // 풀이 시작
        int start = 0;
        int end = arr.length - 1;
        int fixedPoint = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == mid) {
                fixedPoint = mid;
                break;
            }
            if (arr[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(fixedPoint);
    }

}
