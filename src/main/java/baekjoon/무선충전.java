package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 무선충전 {

    // 무조건 현재 가용한 BC 중에서 많은 BC를 사용해야 이득임
    // 가용 BC가 1라면 1개만 전체 충전량에 더해줘도 무방함

    static class BC {
        int index, x, y, dist, perfomance;

        public BC(int index, String x, String y, String dist, String perfomance) {
            this.index = index;
            this.x = Integer.parseInt(y) - 1;
            this.y = Integer.parseInt(x) - 1;
            this.dist = Integer.parseInt(dist);
            this.perfomance = Integer.parseInt(perfomance);
        }
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = y;
            this.y = x;
        }

        void move(int dx, int dy) {
            this.x += dx;
            this.y += dy;
        }

        int distanceFromBc(BC bc) {
            return Math.abs(this.x - bc.x) + Math.abs(this.y - bc.y);
        }
    }

    // 이동 X, 상, 우, 하 좌 순서
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        List<BC> aBCCandidates = new ArrayList<>();
        List<BC> bBCCandidates = new ArrayList<>();

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 이동 횟수
            int A = Integer.parseInt(st.nextToken()); // BC 개수

            int[] aRoute = new int[M + 1];
            StringTokenizer aST = new StringTokenizer(br.readLine());
            int[] bRoute = new int[M + 1];
            StringTokenizer bST = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                aRoute[i] = Integer.parseInt(aST.nextToken());
                bRoute[i] = Integer.parseInt(bST.nextToken());
            }

            BC[] bcs = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bcs[i] = new BC(i, st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
            }

            // 풀이 시작
            Arrays.sort(bcs, Comparator.comparingInt((BC bc) -> bc.perfomance).reversed());

            // 이동하며 최대값 계산 수행
            int answer = 0;
            Position aPosition = new Position(0, 0);
            Position bPosition = new Position(9, 9);
            for (int curM = 0; curM <= M; curM++) {
                // BC 후보 초기화
                aBCCandidates.clear();
                bBCCandidates.clear();

                // A/B 이동
                aPosition.move(dx[aRoute[curM]], dy[aRoute[curM]]);
                bPosition.move(dx[bRoute[curM]], dy[bRoute[curM]]);

                // A/B 각각 BC와의 거리를 계산 후 가용한 BC를 모은다
                for (BC currentBc : bcs) {
                    if (aBCCandidates.size() >= 2 && bBCCandidates.size() >= 2) {
                        // 어차피 하나씩만 가능하므로 가용 BC가 각각 2개 이상이면 탐색 종료
                        break;
                    }

                    if (aPosition.distanceFromBc(currentBc) <= currentBc.dist) {
                        aBCCandidates.add(currentBc);
                    }
                    if (bPosition.distanceFromBc(currentBc) <= currentBc.dist) {
                        bBCCandidates.add(currentBc);
                    }
                }

                // 경우의 수를 따지며 가용한 BC 중 최대 2개를 선택

                // 1. 둘 중 하나만 가능하거나 둘다 불가능 한 경우
                if (aBCCandidates.isEmpty() || bBCCandidates.isEmpty()) {
                    answer += Math.max(!aBCCandidates.isEmpty() ? aBCCandidates.get(0).perfomance : 0,
                        !bBCCandidates.isEmpty() ? bBCCandidates.get(0).perfomance : 0);
                    continue;
                }

                // 2. a/b 모두 가능
                // 2-1. 두 사용자의 가용 BC 최대값이 같다면,
                if (aBCCandidates.get(0).index == bBCCandidates.get(0).index) {
                    answer += aBCCandidates.get(0).perfomance;
                    answer += Math.max(aBCCandidates.size() >= 2 ? aBCCandidates.get(1).perfomance : 0,
                        bBCCandidates.size() >= 2 ? bBCCandidates.get(1).perfomance : 0);
                    continue;
                }

                // 2-2. 두 사용자의 가용 BC 최대값이 다르다면,
                answer += aBCCandidates.get(0).perfomance + bBCCandidates.get(0).perfomance;
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

}
