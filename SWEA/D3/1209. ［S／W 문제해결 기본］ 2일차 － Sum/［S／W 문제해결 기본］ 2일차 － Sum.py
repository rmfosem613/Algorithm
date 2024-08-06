import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static char map[][];
	static int line[];
	static int[][] intArr;

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 여러분의 알고리즘 코드 작성하기
			// 둘째 줄 읽기
			int num = Integer.parseInt(in.readLine());

			intArr = new int[100][100]; // for문에서 밖으로 꺼내야 함
			
			for (int i = 0; i < 100; i++) {
				// 셋째 줄 읽기
				String line = in.readLine();
				String[] arr = line.split(" ");
				

				for (int j = 0; j < 100; j++) {
					intArr[i][j] += Integer.parseInt(arr[j]);
				}
			}
			
			int rowSum, colSum;
			int high = 0;
			int x = 0;
			int x1 = 0;
			
			// 세로 길이 총합
			for(int i = 0; i < 100; i++) {
				rowSum = 0;
				colSum = 0;
				for(int j = 0; j < 100; j++) {
					rowSum += intArr[i][j];
					colSum += intArr[j][i];
				}
				high = Math.max(high, rowSum);
				high = Math.max(high, colSum);
				
				x += intArr[i][i];
				x1 += intArr[i][99-i];
				
			}
			high = Math.max(high, x);
			high = Math.max(high, x1);
			

//			map = new char[100][100];
			
			sb.append(high + "\n");

		}
		System.out.println(sb);
	}
}