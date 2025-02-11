package study.level.A_zero;

//  ⭐️️ 복습 필요.(gcd)
public class Addition_Of_Fractions {
    /** 분수의 덧셈
     *
     * 문제 설명
     * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
     * 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
     * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < numer1, denom1, numer2, denom2 < 1,000
     *
     * numer1	denom1  numer2	denom2	result
     *     1	        2	          3	        4	        [5, 4]
     *     9	        2	          1	        3	       [29, 6]
     */

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 두 분수를 더한 새로운 분자와 분모 계산
        // 공통분모는 denom2 * denom1 = 8
        // 분수는 x자로 곱하기때문에 numer1 * denom2 = 4
        // 분수는 x자로 곱하기때문에 numer2 * denom1 = 6
        // 이걸 더하면 10
        // 그럼 10/8 이니까 GCD 계산해서 5/4가 나오려면 나누기 2

        int numerator = numer1 * denom2 + numer2 * denom1; // 분자
        int denominator = denom1 * denom2; // 분모
        System.out.println("numer1 * denom2  : " + numerator);
        System.out.println("numer1 * denom2  : " + numer1 * denom2 );
        System.out.println("numer2 * denom1  : " + numer2 * denom1 );


        // GCD로 나누어 기약 분수로 변환
        int gcd = gcd(numerator, denominator);  // GCD 계산

        // 분자와 분모를 GCD로 나누기
        int[] answer = {numerator / gcd, denominator / gcd}; // answer 배열에 담기
        return answer;
    }

    // GCD 계산 함수
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;  // GCD 반환
    }

    public static void main(String[] args) {
        Addition_Of_Fractions solutionObj = new Addition_Of_Fractions();
        int numer1 = 1, denom1 = 2, numer2 = 3, denom2 = 4;
        int[] result = solutionObj.solution(numer1, denom1, numer2, denom2);
        System.out.println("Result: " + result[0] + "/" + result[1]);
    }

}
