class Solution {
    static boolean visited[];
	static int cnt;
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i,n, computers);
			}
		}
		
		answer = cnt;
        
        return answer;
    }
    private static void dfs(int node, int n, int[][] computers) {
		visited[node] = true;

		for (int i = 0; i < n; i++) {
			if (computers[node][i] == 1 && !visited[i]) {
				dfs(i,n,computers);
			}
		}
	}
}