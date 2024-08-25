class Solution {
    static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					bfs(i,j, N);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					answer++;
				}
			}
		}

		return answer;
	}

	private static void bfs(int x, int y, int size) {
		if(!visited[x][y]) {
			visited[x][y] = true;
		}
		for(int i = 0; i < 8; i++) {		
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) continue;
			if(!visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
			}
		}
	}
}