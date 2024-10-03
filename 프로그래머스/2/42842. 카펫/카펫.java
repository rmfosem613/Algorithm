class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

		int total = yellow + brown;

		for (int i = 1; i < total + 1; i++) {
			int j = total / i;
			if (j >= i) {
				if (2 * i + 2 * j == brown + 4) {
					answer[0] = j;
					answer[1] = i;
				}
			}
		}
        return answer;
    }
}