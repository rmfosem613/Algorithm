import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);

		int cnt = 0;
		int size = people.length - 1;

		while(cnt <= size) {
			answer++;
			if(people[cnt] + people[size] <= limit) {
				cnt++;
			}
			size--;
		}
        
        return answer;
    }
}