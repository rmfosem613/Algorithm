import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			int testCase = Integer.parseInt(in.readLine());

			int[][] map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				String input_text = in.readLine();
				String[] arr = input_text.split(" ");

				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}

			int start = -1;
			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2) {
					start = i;
					break;
				}
			}
			int x = 99, y = start;

			while (x > 0) {
				if (y > 0 && map[x][y - 1] == 1) {
					while (y > 0 && map[x][y - 1] == 1) {
						y--;
					}
				} else if (y < 99 && map[x][y + 1] == 1) {
					while (y < 99 && map[x][y + 1] == 1) {
						y++;
					}
				}
				x--;
			}
			sb.append(y + "\n");
		}

		System.out.println(sb);
	}
}