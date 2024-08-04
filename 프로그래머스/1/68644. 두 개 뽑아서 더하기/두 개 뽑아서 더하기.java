import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sum = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for (int j=i+1; j < numbers.length; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[sum.size()];
        int cnt = 0;
        
        for(int s : sum) {
            answer[cnt++] = s;
            
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}