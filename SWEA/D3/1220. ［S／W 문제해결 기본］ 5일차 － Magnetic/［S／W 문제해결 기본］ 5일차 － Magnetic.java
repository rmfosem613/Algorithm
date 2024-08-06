import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
    static int[][] map;
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int size = Integer.parseInt(in.readLine());
			map = new int[100][100];

			for (int i = 0; i < size; i++) {

				String line = in.readLine();
				String[] arr = line.split(" ");

				for (int j = 0; j < 100; j++) {
					map[i][j] += Integer.parseInt(arr[j]);
				}
			}
			sb.append(solve(size, map) + "\n");
		}

		System.out.println(sb);
	}

	private static int solve(int size, int[][] map) {
		int cnt = 0;

		// 빨:1, 파:2
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(map[j][i] == 0 || map[j][i] == 2) {
					continue;
				}
				for(int k = j+1; k < size; k++) {
					j = k;
					if(map[k][i] == 2) {
						cnt++;
						break;
					}
				}
			}
		}

		return cnt;
	}
}
