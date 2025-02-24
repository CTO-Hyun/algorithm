package study.Past_Questions.Kakao;

import java.util.HashMap;
import java.util.Map;

// ⭐️⭐️⭐️⭐️⭐️
// 이게 Lv.1 이라니.... 설명부터 이해하느라 땀흘렸네.......
// 그래도 정답률 26%라 다들 어렵긴 한가보다...
// 예를 왜 자꾸 드는거야... 헷갈리게... 안그래도 이해력 좀 부족한데....
public class MostReceivedGift {
    /** 2024 KAKAO WINTER INTERNSHIP > 가장 많이 받은 선물
     *  문제 설명
     * 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다.
     * 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.
     *
     *      두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
     *             예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
     *      두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
     *             선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
     *             예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다.
     *             B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면,
     *             다음 달엔 B가 A에게 선물을 하나 받습니다.
     *             만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
     * 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
     *
     * 친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다.
     * 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 2 ≤ friends의 길이 = 친구들의 수 ≤ 50
     *      friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
     *      이름이 같은 친구는 없습니다.
     * 1 ≤ gifts의 길이 ≤ 10,000
     *      gifts의 원소는 "A B"형태의 문자열입니다. A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
     *      A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않습니다.
     *
     *                          friends	                                                                                                 gifts	                           result
     * ["muzi", "ryan", "frodo", "neo"]	                 ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]	  2
     * ["joy", "brad", "alessandro", "conan", "david"]	  ["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]	          4
     * ["a", "b", "c"]	                                  ["a b", "b a", "c a", "a c", "a c", "c a"]	                                                                  0
     */

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;  // 친구의 수
        Map<String, Integer> map = new HashMap<>();  // 친구 이름을 인덱스로 매핑

        // 친구 이름을 인덱스로 매핑 (예: "muzi" -> 0, "ryan" -> 1)
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);  // 친구의 이름을 그 친구의 인덱스로 저장
        }

        // 선물 주고받은 기록을 저장할 2차원 배열
        int[][] history = new int[n][n];

        // 각 친구가 준 선물 수를 저장할 배열
        int[] given = new int[n];

        // 각 친구가 받은 선물 수를 저장할 배열
        int[] received = new int[n];

        // 선물 주고받은 기록
        for (String gift : gifts) {
            String[] parts = gift.split(" ");  // 공백을 기준으로 선물을 준 사람과 받은 사람을 나누기
            int giver = map.get(parts[0]);  // 선물을 준 사람의 인덱스
            int receiver = map.get(parts[1]);  // 선물을 받은 사람의 인덱스

            // 선물 주고받은 횟수 증가
            history[giver][receiver]++;

            // 선물을 준 사람의 선물 준 횟수 증가
            given[giver]++;

            // 선물을 받은 사람의 선물 받은 횟수 증가
            received[receiver]++;
        }

        // 각 친구의 선물 지수 계산 (준 선물 수 - 받은 선물 수)
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = given[i] - received[i];
        }

        // 각 친구가 다음 달에 받을 선물 수를 저장
        int[] nextMonth = new int[n];
        // 선물 주고받은 기록으로 다음 달 받을 선물 수 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // i 랑 j가 서로 다른 친구일 때만 비교
                if (i == j) continue;  // 같은 사람끼리는 비교하지 않음 (건너뛰기)

                int giftsIJ = history[i][j];  // i가 j에게 준 선물 수
                int giftsJI = history[j][i];  // j가 i에게 준 선물 수


                if (giftsIJ > giftsJI) { // i가 j에게 준 선물이 더 많으면 i가 선물 받음
                    nextMonth[i]++;  // i가 j에게 선물을 많이 줬으니까 i가 선물 받음

                } else if (giftsJI > giftsIJ) { // j가 i에게 준 선물이 더 많으면 j가 선물 받음
                    nextMonth[j]++;  // j가 i에게 선물을 많이 줬으니까 j가 선물 받음

                } else {  // 선물을 주고받은 횟수가 같으면 선물 지수로 비교
                    if (scores[i] > scores[j]) { // 선물 수가 더 큰 사람이 선물 받음
                        nextMonth[i]++;  // i의 선물 지수가 더 크면 i가 선물 받음

                    } else if (scores[i] < scores[j]) {
                        nextMonth[j]++;  // j의 선물 지수가 더 크면 j가 선물 받음
                    }
                    // 선물 지수가 같으면 아무도 선물을 받지 않음
                }
            }
        }

        // 가장 많은 선물을 받을 사람의 선물 수 찾기
        int maxGifts = 0;  // 가장 많은 선물 수
        for (int i = 0; i < n; i++) {
            // 가장 많은 선물을 받는 사람을 찾음
            if (nextMonth[i] > maxGifts) {
                maxGifts = nextMonth[i];
            }
        }

        answer = maxGifts;
        return answer;
    }


    public static void main(String[] args) {
        MostReceivedGift sol = new MostReceivedGift();

        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(sol.solution(friends1, gifts1)); // 2

        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {"alessandro brad", "alessandro joy", "alessandro conan",
                "david alessandro", "alessandro david"};
        System.out.println(sol.solution(friends2, gifts2)); // 4

        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(sol.solution(friends3, gifts3)); // 0
    }
}
