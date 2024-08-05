import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("input2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 둘째 줄 읽기
			int testCase = Integer.parseInt(in.readLine());

			// 셋째 줄 읽기
			String line = in.readLine();
			String[] arr = line.split(" ");
			int[] intArr = new int[arr.length];
			
			for(int i = 0; i < intArr.length; i++) {
				intArr[i] += Integer.parseInt(arr[i]);
			}

			int high = 0;
			int result = 0;
			
			for(int i = 2; i < intArr.length-2; i++) {

				if(intArr[i] > intArr[i+1] && intArr[i] > intArr[i-1]) {

					high = Math.max(intArr[i+1], intArr[i-1]);
					if(intArr[i+2] < intArr[i]) {
						high = Math.max(high, intArr[i+2]);
						if(intArr[i-2] < intArr[i]) {
							high = Math.max(high, intArr[i-2]);

							result += intArr[i] - high;
						}
					}
				}
				
				high = 0;
				
			}
			sb.append(result + "\n");

		}

		System.out.println(sb);
	}
}