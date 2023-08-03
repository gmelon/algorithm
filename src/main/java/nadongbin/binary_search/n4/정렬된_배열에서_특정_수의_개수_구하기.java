package nadongbin.binary_search.n4;

import java.util.Scanner;

public class 정렬된_배열에서_특정_수의_개수_구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // 풀이 시작

        int start = 0;
        int end = arr.length - 1;
        int startIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                startIndex = mid;
                // x의 가장 좌측 원소를 찾으면 종료
                if (mid == 0 || arr[mid - 1] < x) {
                    break;
                }
            }

            // 시작 범위 찾기
            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = arr.length - 1;
        int endIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                endIndex = mid;
                // x의 가장 우측 원소를 찾으면 종료
                if (mid == arr.length - 1 || arr[mid + 1] > x) {
                    break;
                }
            }

            if (arr[mid] <= x) {
                // 끝 범위 찾기
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (startIndex == -1) {
            System.out.println(-1);
        } else {
            System.out.println(endIndex - startIndex + 1);
        }
    }

}
