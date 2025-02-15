package study.level.A_zero;

import java.util.Arrays;

//  ⭐️⭐⭐️⭐️⭐
public class Overlapping {
    /**
     * 겹치는 선분의 길이
     * <p>
     * 문제 설명
     * 선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가
     * [[start, end], [start, end], [start, end]]
     * 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
     * 두 개 이상의 선분이 겹치는 부분의 길이를
     * return 하도록 solution 함수를 완성해보세요.
     *
     * lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
     * 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.
     *
     * 제한사항
     * lines의 길이 = 3
     * lines의 원소의 길이 = 2
     * 모든 선분은 길이가 1 이상입니다.
     * lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
     * -100 ≤ a < b ≤ 100
     *
     * lines	                       result
     * [[0, 1], [2, 5], [3, 9]]           2
     * [[-1, 1], [1, 3], [3, 9]]          0
     * [[0, 5], [3, 9], [1, 10]]          8
     *
     */

    public int solution(int[][] lines) {
        int[] lineMap = new int[201]; // 좌표 -100 ~ 100 == 0 ~ 200
        // new int[201];  new라 시작은 계속 0
        for (int[] line : lines) {

            // -100 ≤ a < b ≤ 100
            int start = line[0] + 100;  //100을 더해 양수 변환
            int end = line[1] + 100;      // 동일하게 100을 더해 양수 변환
            for (int i = start; i < end; i++) {
                lineMap[i]++;
            }
        }

        System.out.println("lineMap.length : " + lineMap.length); //  = 201
        int overlap = 0;
        for (int number : lineMap) {
            // 2개 이상 겹친 부분
            // lineMap 위에서 말 한것처럼 0부터 시작이고 제한사항에 있는 "모든 선분은 길이가 1 이상입니다." 로 조건걸기
            if (number > 1) {
                overlap++;
            }
        }
        return overlap;
    }

    public static void main(String[] args) {
        int[][] lines = {{0, 2}, {-3, -1}, {-2, 1}};

        Overlapping solutionObj = new Overlapping();
        int result = solutionObj.solution(lines);
        for (int i = 0; i < lines.length; i++) {
            System.out.println(Arrays.toString(lines[i]));
        }
        System.out.println("result : " + result);
    }

}
