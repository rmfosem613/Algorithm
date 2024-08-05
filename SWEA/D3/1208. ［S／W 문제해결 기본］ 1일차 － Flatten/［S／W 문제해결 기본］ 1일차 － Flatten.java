import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		//System.setIn(new FileInputStream("input3.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;

		int result = 0;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// 둘째 줄 읽기
			int dump = Integer.parseInt(in.readLine());
			
			// 셋째 줄 읽기
			String line = in.readLine();
			String[] arr = line.split(" ");
			int[] intArr = new int[arr.length];
			
			for (int i = 0; i < intArr.length; i++) {
				intArr[i] += Integer.parseInt(arr[i]);
			}
			
			for(int i = 0; i < dump; i++) {
				Arrays.sort(intArr);
				intArr[intArr.length-1] -= 1;
				intArr[0] += 1;
			}
			Arrays.sort(intArr);
			result = intArr[intArr.length-1] - intArr[0];
			
			sb.append(result + "\n");

		}

		System.out.println(sb);
	}
}