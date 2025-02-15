package study.level.A_zero;

//  ⭐️⭐️
public class SafeZone {
    /**
     * 안전지대
     *
     * 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
     * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과,
     * 지뢰가 없는 지역 0만 존재합니다.
     * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때,
     * 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * board는 n * n 배열입니다.
     * 1 ≤ n ≤ 100
     * 지뢰는 1로 표시되어 있습니다.
     * board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
     */
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] danger = new boolean[n][n];
        // 지뢰가 있는 위치와 그 주변을 위험 지역으로 표시

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {  // 지뢰가 있는 곳
                    // 상 하 좌 우 대각선 체크
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int ni = i + dx;
                            int nj = j + dy;
                            // 배열 범위 내에 있으면 위험지역으로 마킹
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                danger[ni][nj] = true;
                            }
                        }
                    }
                }
            }
        }

        // 안전 지역
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !danger[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SafeZone solutionObj = new SafeZone();

        int[][] board1 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] board2 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] board3 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        System.out.println("Safe Zone Count for board1: " + solutionObj.solution(board1)); // 16
        System.out.println("Safe Zone Count for board2: " + solutionObj.solution(board2)); // 13
        System.out.println("Safe Zone Count for board3: " + solutionObj.solution(board3)); // 0
    }
}
