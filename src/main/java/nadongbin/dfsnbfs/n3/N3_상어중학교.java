package nadongbin.dfsnbfs.n3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class N3_상어중학교 {

    // 검은색 -1, 무지개 0, 일반 1 ~ M
    // 그룹 -> 색이 모두 같은 일반 블록 1개 이상, 검은색 X, 무지개 무한
    // 그룹 블록 개수 -> 2개 이상
    // 기준 블럭 -> 행이 가장 작고 동일행에선 가장 작은 열번호의 블럭

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 격자 한 변의 크기
        int M = sc.nextInt(); // 색상의 개수

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        sc.close();

        System.out.println(solution(N, M, board));
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }
            Position p = (Position) o;
            return this.x == p.x && this.y == p.y;
        }
    }

    public static int solution(int N, int M, int[][] board) {
        // 크기가 가장 큰 블록 그룹 찾기
        // 블록 그룹이 없다면 종료
        int answer = 0;
        while (true) {
            List<Position> maxGroup = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxGroup = findMaxGroup(new Position(i, j), board, maxGroup);
                }
            }

            if (maxGroup.isEmpty()) {
                return answer;
                // 더 이상 블럭 그룹이 없음 -> 지금까지의 점수 반환
            }

            // 선택된 블록 그룹의 점수 획득
            // 이때 블록에 속한 좌표의 값을 -2로 만들기
            answer += (maxGroup.size() * maxGroup.size());
            for (Position position : maxGroup) {
                board[position.x][position.y] = -2;
            }

            // 보드를 90도 반시계 방향으로 회전
            rotateLeft(board);

            // 격자에 중력을 작용시키기
            // 빈 공간을 뭘로 표현할지 고민 -> -2?
            applyGravity(board);
        }
    }

    public static List<Position> findMaxGroup(Position start, int[][] board, List<Position> currentMaxGroup) {
        // 검은색 블럭인 경우 -> 불가능
        if (board[start.x][start.y] == -1) {
            return currentMaxGroup;
        }

        // 1. 블록 그룹 찾기
        boolean[][] visited = new boolean[board.length][board.length];
        Queue<Position> queue = new LinkedList<>();

        queue.offer(start); // 시작점 추가
        visited[start.x][start.y] = true; // 방문 처리

        int currentColor = 0;
        List<Position> newMaxGroup = new ArrayList<>();
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            newMaxGroup.add(current);

            // 일반 블럭이 나타나면 갱신, 이 값이 끝까지 0이면 모두 무지개 블럭
            if (board[current.x][current.y] > 0) {
                currentColor = Math.max(board[current.x][current.y], currentColor);
            }

            // 이웃한 4방향 검사
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < dx.length; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) {
                    continue;
                }
                if (board[nextX][nextY] != -1 && !visited[nextX][nextY]) {
                    queue.offer(new Position(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        // bfs 종료
        if (currentColor == 0) {
            // 그럼 일반 블럭이 없음 -> 무시
            return currentMaxGroup;
        }

        // 2. 현재의 최대 블록과 비교하기

        // 2-1. 크기
        if (newMaxGroup.size() > currentMaxGroup.size()) {
            return newMaxGroup;
        }
        if (currentMaxGroup.size() > newMaxGroup.size()) {
            return currentMaxGroup;
        }

        // 2-2. 무지개 블록 수
        int newGroupCount = 0;
        int currentGroupCount = 0;
        for (Position position : newMaxGroup) {
            if (board[position.x][position.y] == 0) {
                newGroupCount++;
            }
        }
        for (Position position : currentMaxGroup) {
            if (board[position.x][position.y] == 0) {
                currentGroupCount++;
            }
        }

        if (newGroupCount > currentGroupCount) {
            return newMaxGroup;
        }
        if (currentGroupCount > newGroupCount) {
            return currentMaxGroup;
        }

        // 2-3. 기준 블록의 행이 더 큰 것
        Position newGroupStandard = new Position(board.length - 1, board.length - 1);
        Position currentGroupStandard = new Position(board.length - 1, board.length - 1);

        for (Position position : newMaxGroup) {
            if (board[position.x][position.y] != 0) {
                if (position.x < newGroupStandard.x) {
                    newGroupStandard = position;
                } else if (position.x == newGroupStandard.x) {
                    if (position.y < newGroupStandard.y) {
                        newGroupStandard = position;
                    }
                }
            }
        }

        for (Position position : currentMaxGroup) {
            if (board[position.x][position.y] != 0) {
                if (position.x < currentGroupStandard.x) {
                    currentGroupStandard = position;
                } else if (position.x == currentGroupStandard.x) {
                    if (position.y < currentGroupStandard.y) {
                        currentGroupStandard = position;
                    }
                }
            }
        }

        if (newGroupStandard.x > currentGroupStandard.x) {
            return newMaxGroup;
        }
        if (currentGroupStandard.x > newGroupStandard.x) {
            return currentMaxGroup;
        }

        if (newGroupStandard.y > currentGroupStandard.y) {
            return newMaxGroup;
        }
        if (currentGroupStandard.y > newGroupStandard.y) {
            return currentMaxGroup;
        }

        return currentMaxGroup;
    }

    public static void applyGravity(int[][] board) {
        // 열 순회
        for (int j = 0; j < board.length; j++) {
            int count = board.length;
            while (count > 0) {
                count--;
                // 행 순회
                for (int i = 0; i < board.length - 1; i++) {
                    if (board[i][j] == -2 && board[i + 1][j] != -1) {
                        // 교환
                        int temp = board[i][j];
                        board[i][j] = board[i + 1][j];
                        board[i + 1][j] = temp;
                    }
                }
            }
        }
    }

    public static void rotateLeft(int[][] board) {
        int[][] originalBoard = board.clone();

        int maxValue = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = originalBoard[j][maxValue - i];
            }
        }
    }

}
