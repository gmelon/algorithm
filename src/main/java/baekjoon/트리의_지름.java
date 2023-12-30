package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리의_지름 {

    static class Node {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수 (1 ~ V)

        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력받기
        for (int i = 0; i < V; i++) {
            int from = sc.nextInt();

            while (true) {
                int to = sc.nextInt();
                if (to == -1) {
                    break; // 다음 정점 진행
                }
                int distance = sc.nextInt();
                graph.get(from).add(new Node(to, distance));
            }
        }

        sc.close();

        // 풀이 시작



    }

}
