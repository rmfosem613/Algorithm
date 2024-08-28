import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> idxMap = new HashMap<>(); // 이름을 인덱스로 매핑하기 위한 해시맵
        Map<String, Integer> profitMap = new HashMap<>(); // 이익을 저장하기 위한 해시맵

        for (int i = 0; i < enroll.length; i++) {
            idxMap.put(enroll[i], i);
            profitMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            int idx = idxMap.get(seller[i]);
            int money = amount[i] * 100;

            while (true) {
                int profit = (int) Math.ceil(money - money * 0.1); // 90% 이익
                int referralProfit = money - profit; // 추천인에게 전달할 10% 이익

                profitMap.put(enroll[idx], profitMap.get(enroll[idx]) + profit);

                if (referralProfit < 1 || referral[idx].equals("-")) {
                    break;
                }

                money = referralProfit;
                String referrer = referral[idx];
                idx = idxMap.get(referrer);
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }
}
