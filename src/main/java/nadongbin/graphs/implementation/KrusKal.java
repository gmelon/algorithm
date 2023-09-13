package nadongbin.graphs.implementation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KrusKal {

    static class Edge {
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        int V = sc.nextInt(); // 간선 개수

        // 부모 테이블 생성 및 자기자신으로 초기화
        // (합집합 연산 전에는 각각이 원소가 하나인 서로소 집합)
        int[] parents = new int[N + 1];
        // index는 1 ~ N까지 사용
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        Edge[] edges = new Edge[V];
        int totalCost = 0;

        // 간선 입력받기
        for (int i = 0; i < V; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        sc.close();

        // 간선 정렬
        Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));

        // 크루스칼 알고리즘 수행
        for (Edge edge : edges) {
            // 사이클이 없으면 union
            if (findParent(parents, edge.from) != findParent(parents, edge.to)) {
                unionParent(parents, edge.from, edge.to);
                totalCost += edge.cost;
            }
        }

        System.out.println(totalCost);
    }

    /**
     * targetIndex의 부모를 찾아 index를 반환한다.
     */
//    public static int findParent(int[] parents, int targetIndex) {
//        if (parents[targetIndex] != targetIndex) {
//            return findParent(parents, parents[targetIndex]);
//        }
//        return targetIndex;
//    }

    public static int findParent(int[] parents, int targetIndex) {
        if (parents[targetIndex] != targetIndex) {
            parents[targetIndex] = findParent(parents, parents[targetIndex]);
        }
        return parents[targetIndex];
    }

    /**
     * 주어진 parents 배열에서 a와 b의 부모를 합친다.
     */
    public static void unionParent(int[] parents, int a, int b) {
        int parentOfA = findParent(parents, a);
        int parentOfB = findParent(parents, b);

        if (parentOfA < parentOfB) {
            parents[parentOfB] = parentOfA;
        } else {
            parents[parentOfA] = parentOfB;
        }
    }

}
