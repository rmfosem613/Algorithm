import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 여러분의 알고리즘 코드 작성하기
			// 둘째 줄 읽기
			int testCase = Integer.parseInt(in.readLine());
			int max = 0;
			int score = 0;
			int[] list = new int[101];
			
			// 셋째 줄 읽기
			String line = in.readLine();
			String[] arr = line.split(" ");
			int[] intArr = new int[arr.length];
			
			for(int i = 0; i < 1000; i++) {
				list[Integer.parseInt(arr[i])] += 1;
//				sb.append());
			}
			
			for(int i = 0; i < list.length; i++) {
				if(list[i] >= max) {
					max = list[i];
					score = i;
				}
			}
			
			sb.append(score + "\n");

		}
		System.out.println(sb);
	}
}