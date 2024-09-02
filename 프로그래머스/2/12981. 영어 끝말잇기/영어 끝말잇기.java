import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
		
		Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        String preWord = words[0];
		
		for(int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || preWord.charAt(preWord.length()-1) != words[i].charAt(0)) {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				break;
			}
            set.add(words[i]);
            preWord = words[i];
		}
        return answer;
    }
}