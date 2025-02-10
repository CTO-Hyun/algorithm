package study.level.A_zero;

import java.util.Arrays;

//  ⭐️⭐⭐️⭐️⭐️ 복습 필요.(이해 부족.... ㅠㅠ)
public class Parallel {
    /**     평행
     * 문제 설명
     * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
     *
     * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * dots의 길이 = 4
     * dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
     * 0 ≤ x, y ≤ 100
     * 서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
     * 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
     * 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
     *
     * dots	                         result
     * [[1, 4], [9, 2], [3, 8], [11, 6]]	        1
     * [[3, 5], [4, 1], [2, 4], [5, 10]]	        0
     */
    int[][] dots;

    public int solution(int[][] dots) {
        this.dots = dots;
        // dots 배열에 있는 점 4개를 이용
        // 가능한 모든 직선 조합에 대해 평행 여부를 확인
        if (parallel(0, 1, 2, 3)) return 1;  // (0번째 점, 1번째 점)을 이은 직선과 (2번째 점, 3번째 점) 확인
        if (parallel(0, 2, 1, 3)) return 1;  // (0번째 점, 2번째 점)을 이은 직선과 (1번째 점, 3번째 점) 확인
        if (parallel(0, 3, 1, 2)) return 1;  // (0번째 점, 3번째 점)을 이은 직선과 (1번째 점, 2번째 점) 확인

        return 0;
    }

    boolean parallel(int a, int b, int c, int d) {
        // 두 직선의 기울기를 비교하여 평행한지 확인하기 위한 계산
        int x = (dots[a][0] - dots[b][0]) * (dots[c][1] - dots[d][1]);  // 직선 AB의 기울기 계산
        int y = (dots[a][1] - dots[b][1]) * (dots[c][0] - dots[d][0]);  // 직선 CD의 기울기 계산
        // 두 직선이 평행하려면 기울기가 같거나 (x == y), 기울기의 부호가 반대여야 하므로 (x == -y)
        return x == y || x == -y;  // 두 직선의 기울기가 같거나 부호가 반대이면 평행하다고 판단
    }


    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};

        Parallel solutionObj = new Parallel();
        int result = solutionObj.solution(dots);
        for (int i = 0; i < dots.length; i++) {
            System.out.println(Arrays.toString(dots[i]));
        }
        System.out.println("result : " + result);
    }

}
