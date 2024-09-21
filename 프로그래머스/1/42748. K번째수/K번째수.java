import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

		

		for (int k = 0; k < commands.length; k++) {
			List<Integer> temp = new ArrayList<>();
			for (int i = commands[k][0] - 1; i < commands[k][1]; i++) {
				temp.add(array[i]);
			}
			Collections.sort(temp);
			answer[k] = temp.get(commands[k][2]-1);
		}
        return answer;
    }
}