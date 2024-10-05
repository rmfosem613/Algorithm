import java.util.Arrays;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

int n = land.length;
		int dp[][] = new int[n][4];

		// 4열로 이루어져 있음
		dp[0][0] = land[0][0];
		dp[0][1] = land[0][1];
		dp[0][2] = land[0][2];
		dp[0][3] = land[0][3];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					if(j != k) {
						if(dp[i][j] < dp[i-1][k] + land[i][j]) {
							dp[i][j] = dp[i-1][k] + land[i][j];
						}
					}	
				}
				
			}
		}
		
		Arrays.sort(dp[land.length-1]);
		
		answer = dp[n-1][3];

        return answer;
    }
}