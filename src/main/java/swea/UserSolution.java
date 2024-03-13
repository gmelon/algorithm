package swea;

class UserSolution {

    static Node[][] heads;
    static Node[][] tails;
    static int[] currentVersion;
    static int[] teamIds;

    static class Node {

        int id, version;
        Node next;

        public Node(int id, int version, Node next) {
            this.id = id;
            this.version = version;
            this.next = next;
        }
    }

    public void init() {
        // table[i][j] -> i번째 팀에서 평판이 j인 병사 리스트
        heads = new Node[6][6];
        tails = new Node[6][6];
        // currentVersion[i] = id가 i인 병사의 최신 버전
        currentVersion = new int[100_001];
        // 병사들의 teamId를 기록
        teamIds = new int[100_001];
    }

    // 병사를 고용한다
    // 100_000번 호출
    public void hire(int id, int teamId, int score) {
        currentVersion[id]++;
        teamIds[id] = teamId;

        Node current = new Node(id, currentVersion[id], heads[teamId][score]);
        heads[teamId][score] = current;

        if (tails[teamId][score] == null) {
            tails[teamId][score] = heads[teamId][score];
        }
    }

    // 병사를 해고한다
    // 100_000번 호출
    public void fire(int id) {
        // 병사의 id를 증가시켜서 기존 병사 리스트의 node를 무력화 시킨다
        currentVersion[id]++;
    }

    // id 병사의 평판 점수를 score로 변경한다
    // 100_000번 호출
    public void updateSoldier(int id, int score) {
        currentVersion[id]++; // 기존 점수 무력화

        Node current = new Node(id, currentVersion[id], heads[teamIds[id]][score]);
        heads[teamIds[id]][score] = current;

        if (tails[teamIds[id]][score] == null) {
            tails[teamIds[id]][score] = heads[teamIds[id]][score];
        }
    }

    // teamId 팀의 모든 병사 점수에 scoreDelta를 더한다
    // 100_000번 호출
    public void updateTeam(int teamId, int scoreDelta) {
        if (scoreDelta == 0) {
            return;
        }

        if (scoreDelta < 0) {
            // 음수
            for (int i = 2; i <= 5; i++) {
                int targetScore = Math.max(1, i + scoreDelta);

                if (heads[teamId][i] == null) {
                    continue;
                }

                // TODO 연결이 잘못됨


                tails[teamId][i].next = heads[teamId][targetScore];
                heads[teamId][targetScore] = heads[teamId][i];
                tails[teamId][i] = heads[teamId][i] = null;
            }
            return;
        }



        // 양수
        for (int i = 4; i >= 1; i--) {
            int targetScore = Math.min(5, i + scoreDelta);

            if (heads[teamId][i] == null) {
                continue;
            }

            tails[teamId][i].next = heads[teamId][targetScore];
            heads[teamId][targetScore] = heads[teamId][i];
            tails[teamId][i] = heads[teamId][i] = null;
        }
    }

    // teamId 팀의 병사 중 최고 병사의 id를 반환한다
    // 100번 호출
    public int bestSoldier(int teamId) {
        int bestId = 0;
        int currentScore = 5;
        while (bestId == 0) {
            Node current = heads[teamId][currentScore];
            while (current != null) {
                if (currentVersion[current.id] == current.version) {
                    // 최신버전이므로 정답 갱신
                    bestId = Math.max(bestId, current.id);
                }
                current = current.next;
            }
            currentScore--;
        }
        return bestId;
    }
}
