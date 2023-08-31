package nadongbin.shortest_path.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FastDijkstra {

    private static final int INF = 1_000_000_000;

    static class Node implements Comparable<Node> {

        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        int m = sc.nextInt(); // 간선 개수
        int startNodeNumber = sc.nextInt(); // 탐색 시작 노드

        List<List<Node>> graph = new ArrayList<>();
        // 그래프 초기화
        for (int i = 0; i < n + 1; i++) { // 인덱스로 1 ~ n 까지 사용
            graph.add(new ArrayList<>());
        }

        // 인접 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(from).add(new Node(to, distance));
        }

        sc.close();

        // 풀이 시작
        int[] distances = new int[n + 1]; // 최단 거리 테이블
        dijkstra(graph, distances, startNodeNumber);

        // 각 노드의 최단 경로 출력
        for (int i = 1; i < distances.length; i++) {
            int distance = distances[i];
            if (distance == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(distance);
            }
        }
    }

    public static void dijkstra(List<List<Node>> graph, int[] distances, int startNodeNumber) {
        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 최초에는 최단 거리를 모두 무한으로 설정
        Arrays.fill(distances, INF);

        // 시작 노드에 대해 초기화
        pq.offer(new Node(startNodeNumber, 0));
        distances[startNodeNumber] = 0;
        // 시작 노드의 인접 노드 거리 갱신
        for (Node neighbor : graph.get(startNodeNumber)) {
            distances[neighbor.number] = neighbor.distance;
            pq.offer(new Node(neighbor.number, distances[neighbor.number]));
        }

        // pq가 이어있지 않으면 계속 반복 수행
        while (!pq.isEmpty()) {
            // 현재 방문하지 않은 정점 중 가장 거리가 짧은 노드 찾기
            Node minNode = pq.poll();

            // 이미 방문한 노드라면 무시
            // (테이블의 값이 우선순위 큐에서 빼낸 값보다 작은 경우 이미 처리가 완료된 상태)
            // (만약 두 값이 같다면, 현재 처리해야될 차례이므로 계속해서 진행해야 함)
            if (minNode.distance > distances[minNode.number]) {
                continue;
            }

            for (Node neighbor : graph.get(minNode.number)) {
                int newCost = distances[minNode.number] + neighbor.distance;

                // 현재 최단 거리 노드를 거쳐서 인접 노드에 방문하는게 더 최단 경로이면
                // 테이블 값을 갱신, pq에도 추가
                if (newCost < distances[neighbor.number]) {
                    distances[neighbor.number] = newCost;
                    pq.offer(new Node(neighbor.number, newCost));
                }
            }
        }
    }

}
