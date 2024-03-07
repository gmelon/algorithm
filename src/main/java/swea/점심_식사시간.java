package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점심_식사시간 {

    static class Person {

        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Waiting toWaiting(Stair stair) {
            return new Waiting(Math.abs(this.x - stair.x) + Math.abs(this.y - stair.y), stair.k - 1);
        }
    }

    static class Waiting implements Comparable<Waiting> {

        int distance, leftK;

        public Waiting(int distance, int leftK) {
            this.distance = distance;
            this.leftK = leftK;
        }

        @Override
        public int compareTo(Waiting o) {
            return this.distance - o.distance;
        }
    }

    static class Stair {

        int x, y, k;

        public Stair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    static List<Person> people;
    static List<Stair> stairs;
    static int N;

    static boolean[] selected; // 부분 집합 구성용
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            people = new ArrayList<>();
            stairs = new ArrayList<>(2);
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        people.add(new Person(i, j));
                    } else if (value >= 2) {
                        stairs.add(new Stair(i, j, value));
                    }
                }
            }

            // 입력 완료
            minTime = Integer.MAX_VALUE;
            selected = new boolean[people.size()];

            powerSet(0);
            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    static void powerSet(int index) {
        if (index == selected.length) {
            // 부분 집합 구성 완료, 현재 부분 집합으로 돌려보기.
            down();
            return;
        }

        selected[index] = true;
        powerSet(index + 1);
        selected[index] = false;
        powerSet(index + 1);
    }

    static void down() {
        List<Waiting> trueWaitings = new ArrayList<>();
        List<Waiting> falseWaitings = new ArrayList<>();

        // 선택된 부분 집합에 따라 나누어 담기
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                trueWaitings.add(people.get(i).toWaiting(stairs.get(0)));
            } else {
                falseWaitings.add(people.get(i).toWaiting(stairs.get(1)));
            }
        }

        // 계단에서 거리가 가까운 순으로 정렬
        Collections.sort(trueWaitings);
        Collections.sort(falseWaitings);

        // 부분 집합 별로 돌려보고 정답 갱신
        minTime = Math.min(minTime, Math.max(calcTime(trueWaitings), calcTime(falseWaitings)));
    }

    static int calcTime(List<Waiting> waitings) {
        // 현재 내려가는 사람을 담는 큐
        Queue<Waiting> currentQueue = new ArrayDeque<>();
        int frontIndex = 0;

        // 모든 사람이 내려갈 때 까지 반복
        int time = 0;
        while (frontIndex < waitings.size() || !currentQueue.isEmpty()) {
            // 기존에 큐에 있던 사람 내려 보내기
            for (int i = 0, size = currentQueue.size(); i < Math.min(3, size); i++) {
                Waiting current = currentQueue.poll();
                current.leftK -= 1; // 내려가라
                if (current.leftK >= 0) {
                    // 계속 내려가라
                    currentQueue.offer(current);
                }
            }

            // 큐에 자리가 있으면 추가로 내려보내기
            if (currentQueue.size() < 3) {
                // 대기열에 사람이 남아있으면서 큐의 남은 크기만큼 반복
                for (int i = 0, size = 3 - currentQueue.size(); i < size && frontIndex < waitings.size(); i++) {
                    if (time <= waitings.get(frontIndex).distance) {
                        // 아직 우선 순위 1번인 사람이 내려갈 수 없음
                        break; // 멈추기
                    }

                    // 우선 순위 1번 내려보내기
                    currentQueue.offer(waitings.get(frontIndex++));
                }
            }

            time++;
        }

        return time - 1; // 마지막에 더해지는 시간 빼주기
    }

}
