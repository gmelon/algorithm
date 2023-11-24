package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 방_번호 {

    static List<Integer> costs;
    static int N;
    static String answer = "0";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 구매 가능한 번호의 개수 (0 ~ N-1)
        costs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            costs.add(sc.nextInt()); // 방 번호들의 구매 비용
        }
        int M = sc.nextInt(); // 가지고 있는 비용
        sc.close();

        // 풀이 시작
        for (int i = N - 1; i >= 1; i--) { // 큰 번호부터 순회
            int cost = costs.get(i);
            if (cost <= M) {
                dfs(1, M - cost, String.valueOf(i));
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int index, int restMoney, String currentRoomNumber) {
        if (currentRoomNumber.length() < answer.length() && currentRoomNumber.compareTo(answer) < 0) {
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            int cost = costs.get(i);
            if (cost <= restMoney) {
                dfs(index + 1, restMoney - cost, currentRoomNumber + i);
            }
        }

        if (currentRoomNumber.length() > answer.length() || currentRoomNumber.compareTo(answer) > 0) {
            answer = currentRoomNumber;
        }
    }

}
