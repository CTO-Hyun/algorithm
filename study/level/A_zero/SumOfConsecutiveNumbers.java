package study.level.A_zero;

//  ⭐️⭐️
public class SumOfConsecutiveNumbers {
    /**
     * 안전지대
     *
     * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
     * 두 정수 num과 total이 주어집니다. 연속된 수 num개를 더한 값이 total이 될 때,
     * 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ num ≤ 100
     * 0 ≤ total ≤ 1000
     * num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
     *
     * num	    total	   result
     *   3	    12	[3, 4, 5]
     *   5	    15	[1, 2, 3, 4, 5]
     *   4	    14	[2, 3, 4, 5]
     *   5	     5	    [-1, 0, 1, 2, 3]
     */
    public int[] solution(int num, int total) {
        int x = (total - (num * (num - 1)) / 2) / num;

        // 결과 배열 생성
        int[] answer = new int[num];

        // 연속된 수들 배열에 저장
        for (int i = 0; i < num; i++) {
            answer[i] = x + i;
        }

        return answer;
    }

    public static void main(String[] args) {
        SumOfConsecutiveNumbers solutionObj = new SumOfConsecutiveNumbers();
        int[] result1 = solutionObj.solution(3, 12);
        int[] result2 = solutionObj.solution(5, 15);
        int[] result3 = solutionObj.solution(4, 14);
        int[] result4 = solutionObj.solution(5, 5);

        // 결과 출력
        System.out.println("result1: " + java.util.Arrays.toString(result1));
        System.out.println("result2: " + java.util.Arrays.toString(result2));
        System.out.println("result3: " + java.util.Arrays.toString(result3));
        System.out.println("result4: " + java.util.Arrays.toString(result4));
    }
}
