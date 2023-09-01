package nadongbin.shortest_path.n2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {

    public static final int INF = 1_000_000_000;

    static class Node implements Comparable<Node> {

        int number;
        int time;

        public Node(int number, int time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 통로 개수
        int C = sc.nextInt(); // 메시지를 보내려는 도시

        List<List<Node>> graph = new ArrayList<>();
        // 그래프 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
        }

        sc.close();

        // 풀이 시작
        // PQ를 사용한 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] times = new int[N + 1];
        Arrays.fill(times, INF);

        // 초기 정점 설정
        pq.offer(new Node(C, 0));
        times[C] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (times[cur.number] < cur.time) {
                continue;
            }

            for (Node neighbor : graph.get(cur.number)) {
                int newTime = times[cur.number] + neighbor.time;

                if (times[neighbor.number] > newTime) {
                    times[neighbor.number] = newTime;
                    pq.offer(new Node(neighbor.number, newTime));
                }
            }
        }

        // 정답 만들기
        int count = 0;
        int timeSum = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i == C) {
                continue;
            }
            if (times[i] < INF) {
                count++;
                timeSum = Math.max(times[i], timeSum);
            }
        }

        System.out.println(count + " " + timeSum);
    }

}
