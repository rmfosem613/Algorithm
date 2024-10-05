import java.util.Arrays;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int dp[][] = new int[triangle.length][triangle.length];
		
		dp[0][0] = triangle[0][0];
		dp[1][0] = triangle[0][0] + triangle[1][0];
		dp[1][1] = triangle[0][0] + triangle[1][1];
		
		for(int i = 2; i < triangle.length; i++) {
			for(int j = 0; j <=i; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				}
				else if(j >=1 && j < i) {
					int temp1 = dp[i-1][j-1]+triangle[i][j];
					int temp2 = dp[i-1][j]+triangle[i][j];
					
					dp[i][j] = Math.max(temp1, temp2);
				}
				else {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				}
					
			}
		}
		
		Arrays.sort(dp[triangle.length-1]);
		
		answer = dp[triangle.length-1][triangle.length-1];
		
        
        return answer;
    }
}