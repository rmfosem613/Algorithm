class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int NX = board[0] / 2; // x축 최대 좌표
		int NY = board[1] / 2; // y축 최대 좌표

		int curX = 0;
		int curY = 0;

		for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("left")) {
				if(curX > -(NX)) curX--; 
			} else if (keyinput[i].equals("right")) {
				if(curX < NX) curX++;
			} else if (keyinput[i].equals("down")) {
				if(curY > -NY) curY--;
			} else if (keyinput[i].equals("up")) {
				if(curY < NY) curY++;
			}
		}
		
		answer[0] = curX;
		answer[1] = curY;
        
        return answer;
    }
}