package collections.graph;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5, 4, 5,
            new int[][]{
                {1, 9, 7, 2},
                {3, 1, 4, 6},
                {5, 2, 8, 3},
                {8, 4, 6, 1},
                {4, 9, 10, 6}
        }));
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 각성 순서 기록
    static class Awaken {
        int count = 1; // 각성한 순서 (1부터, 0이면 각성한 적 X)
        int[][] orderArray;

        int n, m;

        public Awaken(int n, int m) {
            orderArray = new int[n][m];
            this.n = n;
            this.m = m;
        }

        public void awake(Position position, int[][] power) {
            power[position.x][position.y] += (n + m);

            orderArray[position.x][position.y] = count;
            count++;
        }

        public int checkCount(Position position) {
            return orderArray[position.x][position.y];
        }

        // 다음 각성할 신 찾기
        public Position nextAwake(final int[][] powers) {
            // 1. 힘이 가장 약한 신
            int min = Arrays.stream(powers)
                .flatMapToInt(Arrays::stream)
                .min()
                .getAsInt();

            List<Position> candidates = new ArrayList<>();
            for (int i = 0; i < powers.length; i++) {
                for (int j = 0; j < powers[0].length; j++) {
                    // 최솟값이면 후보 리스트에 추가
                    if (powers[i][j] == min) {
                        candidates.add(new Position(i, j));
                    }
                }
            }

            // 1-1. 후보가 한명이면 바로 반환
            if (candidates.size() == 1) {
                return candidates.get(0);
            }

            // 2. 가장 최근에 각성한 신
            Position step2Candidate = null;

            for (Position candidate : candidates) {
                if (checkCount(candidate) == 0) {
                    continue;
                }

                if (step2Candidate == null) {
                    step2Candidate = candidate;
                    continue;
                }

                // 더 최근에 각성한 경우에만 갱신
                if (checkCount(candidate) > checkCount(step2Candidate)) {
                    step2Candidate = candidate;
                }
            }

            if (step2Candidate != null) {
                return step2Candidate;
            }

            // 3. row, col의 합이 가장 작은 신
            int step3Min = candidates.stream().mapToInt(p -> p.x + p.y).min().getAsInt();
            List<Position> step3Cadidates = new ArrayList<>();

            for (Position candidate : candidates) {
                if (candidate.x + candidate.y == step3Min) {
                    step3Cadidates.add(candidate);
                }
            }

            if (step3Cadidates.size() == 1) {
                return step3Cadidates.get(0);
            }

            // 4. col의 값이 가장 작은 신
            int step4Min = step3Cadidates.stream().mapToInt(p -> p.y).min().getAsInt();
            for (Position candidate : step3Cadidates) {
                if (candidate.y == step4Min) {
                    return candidate;
                }
            }

            throw new IllegalStateException("각성 대상을 찾을 수 없습니다.");
        }

        // 다음 공격할 신 찾기
        public Position nextAttack(final int[][] powers, final Position awaken) {
            // 1. 힘이 가장 강한 신
            int max = Arrays.stream(powers)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i != powers[awaken.x][awaken.y]) // 각성신 제외
                .max()
                .getAsInt();

            List<Position> candidates = new ArrayList<>();
            for (int i = 0; i < powers.length; i++) {
                for (int j = 0; j < powers[0].length; j++) {
                    // 각성신과 같으면 패스
                    if (awaken.x == i && awaken.y == j) {
                        continue;
                    }

                    // 최댓값이면 후보 리스트에 추가
                    if (powers[i][j] == max) {
                        candidates.add(new Position(i, j));
                    }
                }
            }

            // 1-1. 후보가 한명이면 바로 반환
            if (candidates.size() == 1) {
                return candidates.get(0);
            }

            // 2. 가장 오래전에 각성한 신
            Position step2Candidate = null;

            for (Position candidate : candidates) {
                // 각성한 적이 없거나 각성신과 같으면 패스
                if (checkCount(candidate) == 0 || candidate.equals(awaken)) {
                    continue;
                }

                if (step2Candidate == null) {
                    step2Candidate = candidate;
                    continue;
                }

                // 더 오래전에 각성한 경우에만 갱신
                if (checkCount(candidate) < checkCount(step2Candidate)) {
                    step2Candidate = candidate;
                }
            }

            if (step2Candidate != null) {
                return step2Candidate;
            }

            // 3. row, col의 합이 가장 큰 신
            int step3Max = candidates.stream().mapToInt(p -> p.x + p.y).max().getAsInt();
            List<Position> step3Cadidates = new ArrayList<>();

            for (Position candidate : candidates) {
                if (candidate.x + candidate.y == step3Max) {
                    step3Cadidates.add(candidate);
                }
            }

            if (step3Cadidates.size() == 1) {
                return step3Cadidates.get(0);
            }

            // 4. col의 값이 가장 큰 신
            int step4Max = step3Cadidates.stream().mapToInt(p -> p.y).max().getAsInt();
            for (Position candidate : step3Cadidates) {
                if (candidate.y == step4Max) {
                    return candidate;
                }
            }

            throw new IllegalStateException("공격 대상을 찾을 수 없습니다.");
        }
    }


    public static int solution(int n, int m, int k, int[][] powers) {
        Awaken awaken = new Awaken(n, m);

        // k번 플레이
        for (int count = 0; count < k; count++) {
            // 각성 대상 찾기
            Position nextAwaken = awaken.nextAwake(powers);
            // 각성 시키기
            awaken.awake(nextAwaken, powers);
            System.out.println("각성대상 - x : " + nextAwaken.x + ", y : " + nextAwaken.y);


            // 공격 대상 신 찾기
            Position nextAttack = awaken.nextAttack(powers, nextAwaken);
            System.out.println("공격대상 - x : " + nextAttack.x + ", y : " + nextAttack.y);
            // 공격
        }
        return 0;
    }

}