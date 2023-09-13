package nadongbin.shortest_path.n7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 면접보는_승범이네 {

    public static final int INF = 1_000_000_000;

    static class City implements Comparable<City> {

        int number;
        int distance;

        public City(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(City o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시의 수
        int M = sc.nextInt(); // 도로의 수
        int K = sc.nextInt(); // 면접장의 수

        List<List<City>> graph = new ArrayList<>();
        // 그래프 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 간선 입력
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();

            // from-to를 반대로 입력
            graph.get(to).add(new City(from, distance));
        }

        // 면접장 정보
        int[] interviewLocations = new int[K];
        for (int i = 0; i < K; i++) {
            interviewLocations[i] = sc.nextInt();
        }

        sc.close();

        // 풀이 시작
        int[] globalShortest = new int[N + 1];
        Arrays.fill(globalShortest, INF);

        for (int interviewLocation : interviewLocations) {
            // 다익스트라 수행
            PriorityQueue<City> pq = new PriorityQueue<>();
            int[] localShortest = new int[N + 1];
            Arrays.fill(localShortest, INF);

            // 초기값 설정
            pq.offer(new City(interviewLocation, 0));
            localShortest[interviewLocation] = 0;

            while (!pq.isEmpty()) {
                City current = pq.poll();

                if (localShortest[current.number] < current.distance) {
                    continue;
                }

                for (City neighbor : graph.get(current.number)) {
                    if (localShortest[neighbor.number] > localShortest[current.number] + neighbor.distance) {
                        localShortest[neighbor.number] = localShortest[current.number] + neighbor.distance;
                        pq.offer(new City(neighbor.number, localShortest[current.number] + neighbor.distance));
                    }
                }
            }

            // 최소값 갱신
            for (int i = 1; i < N + 1; i++) {
                globalShortest[i] = Math.min(globalShortest[i], localShortest[i]);
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 1; i < N + 1; i++) {
            if (globalShortest[i] > maxValue) {
                maxValue = globalShortest[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
        System.out.println(maxValue);
    }

}
