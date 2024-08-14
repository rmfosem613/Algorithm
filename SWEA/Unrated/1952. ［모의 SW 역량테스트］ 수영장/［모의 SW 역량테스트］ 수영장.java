import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input2.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String[] split = in.readLine().split(" ");
            int oneDay = Integer.parseInt(split[0]);
            int oneMonth = Integer.parseInt(split[1]);
            int threeMonth = Integer.parseInt(split[2]);
            int oneYear = Integer.parseInt(split[3]);

            split = in.readLine().split(" ");
            int[] plan = new int[12];
            int[] dp = new int[13];  // dp[12]까지 이용하여 연간 요금과 비교할 것임.

            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(split[i]);
            }

            for (int i = 1; i <= 12; i++) {
                int dailyCost = plan[i - 1] * oneDay;
                dp[i] = dp[i - 1] + Math.min(dailyCost, oneMonth);
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + threeMonth);
                }
            }

            // 최종적으로 12월까지 계산한 결과와 연간 요금을 비교하여 최소값 선택
            int minCost = Math.min(dp[12], oneYear);
            sb.append(minCost).append("\n");
        }
        System.out.print(sb);
    }
}