package nadongbin.n9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N9_산책_small {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수

        // 그래프 초기화 (1번 vertex부터 사용)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 간선 정보 추가 (양방향, 길이 1)
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int S = sc.nextInt(); // 출발 지점
        int E = sc.nextInt(); // 도착 지점

        sc.close();

        solution(N, M, graph, S, E);
    }

    public static void solution(int N, int M, List<List<Integer>> graph, int S, int E) {
        // graph 간선 오름차순 정렬 -> 먼저 찾은 경로가 오름차순 경로

        // S -> E에서 찾은 경로 길이 더해주기

        // S -> E에서 찾은 경로를 visited에 true 처리해주고 E -> S 경로 찾기
        // 동일하게 오름차순된 graph에서 찾으면 오름차순이 보장됨

        // E -> S 경로 길이 더해주기

    }


}
