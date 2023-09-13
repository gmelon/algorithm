package nadongbin.graphs.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 노드 개수
        int E = sc.nextInt(); // 간선 개수

        List<List<Integer>> graph = new ArrayList<>();
        // 그래프 초기화
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        int[] indegree = new int[V + 1]; // 진입 차수 기록
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            indegree[to] += 1; // 받는 쪽의 진입 차수 1씩 증가
        }

        sc.close();

        // 풀이 시작
        List<Integer> sortedResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            // 초기 진입 차수가 0인 노드들 큐에 넣기
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐에 노드가 존재하는 동안 계속 반복
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            sortedResult.add(curNode);

            // curNode와 연결된 간선 제거
            for (int neighbor : graph.get(curNode)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    // 이번 간선 제거로 진입차수가 0이 되었다면 큐에 넣기
                    queue.offer(neighbor);
                }
            }
        }

        // 결과 출력
        System.out.println(sortedResult);

    }

}
