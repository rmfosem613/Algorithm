import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환한 리스트
        List<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }

        // 정렬: 두 문자열을 합친 결과를 비교하여 큰 쪽이 앞으로 오게 함
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        // 가장 큰 숫자를 저장할 변수
        String answer = "";

        // 정렬된 리스트에서 숫자를 이어 붙임
        for (String num : list) {
            answer+=num;
        }

        // 숫자가 0으로 시작하면 "0" 출력
        if (answer.charAt(0) == '0') {
            answer = 0+"";
        } 
        
        return answer;   
	}
}