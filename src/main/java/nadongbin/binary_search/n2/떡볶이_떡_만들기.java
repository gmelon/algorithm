package nadongbin.binary_search.n2;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이_떡_만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 떡의 개수
        int M = sc.nextInt(); // 요청한 떡의 길이

        int[] arr = new int[N]; // 떡의 개별 높이
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // 풀이 시작
        Arrays.sort(arr); // 떡 오름차순 정렬

        int height = 0;
        int start = 0; // 절단기 최소 높이
        int end = arr[arr.length - 1]; // 최초 end는 마지막 떡의 길이

        while (start <= end) {
            // 이분 탐색
            int mid = (start + end) / 2;

            // 현재 mid로 고객이 받아가게 될 떡 길이 계산
            int sum = 0;
            for (int i : arr) {
                int temp = i - mid;
                if (temp > 0) {
                    sum += temp;
                }
            }

            // 고객이 요청한 떡 길이보다 길면
            if (sum >= M) {
                start = mid + 1;

                // 이때는 height도 갱신해준다
                // 무조건 가장 큰 && 조건에 부합하는 mid가 마지막에 선택되므로 Math.max() 필요 없음
                height = mid;
            } else {
                // 고객이 요청한 떡 길이보다 작으면
                end = mid - 1;
            }
        }

        System.out.println(height);
    }

}
