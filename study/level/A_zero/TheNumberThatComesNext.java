package study.level.A_zero;

//  ⭐️⭐️
public class TheNumberThatComesNext {
    /**
     * 다음에 올 숫자
     *
     * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때,
     * 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 < common의 길이 < 1,000
     * -1,000 < common의 원소 < 2,000
     * common의 원소는 모두 정수입니다.
     * 등차수열 혹은 등비수열이 아닌 경우는 없습니다.
     * 등비수열인 경우 공비는 0이 아닌 정수입니다.
     *
     * common	      result
     * [1, 2, 3, 4]	        5
     * [2, 4, 8]	       16
     */
    public int solution(int[] common) {
        int answer = 0;

        if (common[1] - common[0] == common[2] - common[1]) {
            // 등차수열 : 공차가 일정한지 확인
            // 등차수열이면 공차를 구하고 마지막 원소에 공차를 더하기
            int commonDifference = common[1] - common[0];
            answer = common[common.length - 1] + commonDifference;
        } else {
            // 등비수열 확인: 공비가 일정한지 확인
            // 등비수열이면 공비를 구하고 마지막 원소에 공비를 곱하기
            int commonRatio = common[1] / common[0];
            answer = common[common.length - 1] * commonRatio;
        }

        return answer;
    }

    public static void main(String[] args) {
        TheNumberThatComesNext solutionObj = new TheNumberThatComesNext();

        System.out.println(solutionObj.solution(new int[]{1, 2, 3, 4}));  // 등차수열
        System.out.println(solutionObj.solution(new int[]{2, 4, 8}));     // 등비수열
    }
}
