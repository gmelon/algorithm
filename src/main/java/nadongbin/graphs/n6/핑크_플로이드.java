package nadongbin.graphs.n6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 핑크_플로이드 {

    static class MinEdge implements Comparable<MinEdge> {

        int from;
        int to;
        int cost;

        public MinEdge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(MinEdge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<MinEdge> minEdges = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                minEdges.add(new MinEdge(i, j, sc.nextInt()));
            }
        }

        sc.close();

        // 풀이 시작
        Collections.sort(minEdges);
        int[] parents = new int[N + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            answers.add(new ArrayList<>());
        }
        int count = 0;
        for (MinEdge minEdge : minEdges) {
            if (count == N - 1) {
                break;
            }

            if (findParent(parents, minEdge.from) == findParent(parents, minEdge.to)) {
                continue;
            }

            unionParent(parents, minEdge.from, minEdge.to);
            answers.get(minEdge.from).add(minEdge.to);
            answers.get(minEdge.to).add(minEdge.from);
            count++;
        }

        for (int i = 1; i < answers.size(); i++) {
            System.out.print(answers.get(i).size() + " ");
            Collections.sort(answers.get(i));
            for (int neighbor : answers.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static int findParent(int[] parent, int target) {
        if (parent[target] != target) {
            parent[target] = findParent(parent, parent[target]);
        }
        return parent[target];
    }

    public static void unionParent(int[] parent, int a, int b) {
        int parentA = findParent(parent, a);
        int parentB = findParent(parent, b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

}
