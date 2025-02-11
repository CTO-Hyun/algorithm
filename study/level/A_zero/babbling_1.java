package study.level.A_zero;

//  ⭐️⭐⭐️ 복습 필요.
public class babbling_1 {

    /**
     * 옹알이(1)
     * 문제 설명
     * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
     * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
     * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     * <p>
     * 제한사항
     * 1 ≤ babbling의 길이 ≤ 100
     * 1 ≤ babbling[i]의 길이 ≤ 15
     * babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
     * 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
     * 문자열은 알파벳 소문자로만 이루어져 있습니다.
     * <p>
     * babbling	                                  result
     * ["aya", "yee", "u", "maa", "wyeoo"]              	    1
     * ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	    3
     */

    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};

        babbling_1 solutionObj = new babbling_1();
        int result = solutionObj.solution(babbling);
        System.out.println("result : " + result);
    }

    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            // aya, woo, ye, ma를 1로 변환
            babbling[i] = babbling[i].replace("aya", "1");  //  매칭 있음
            babbling[i] = babbling[i].replace("woo", "1");  // 매칭 없음
            babbling[i] = babbling[i].replace("ye", "1");   // 매칭 없음
            babbling[i] = babbling[i].replace("ma", "1");   // 매칭 없음

            // 1을 공백으로 변환
            babbling[i] = babbling[i].replace("1", "");
            // aya = 1   ''
            // yee = 1  ye 지워지니까 1e
            // ma = 1 ma 지워지니까 1a
            // u = 1 u는 지울게 없으니까 1u
            // ma = 1 ma 지워지니까 1a
            // wyeoo = 1 ye 지워지니까 w1oo

            // babbling빈 문자열이면  answer 1증가
            if (babbling[i].isEmpty()) {
                // 빈 문자열이 aya 이것뿐이니까
                answer = answer + 1;
            }
        }
        // answer = 1
        return answer;
    }
}
