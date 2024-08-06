import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int N;
	private static int M;
	private static boolean[] isSelected; // 선택한 원소 관리
	private static int[] numbers; // 선택한 하나의 경우의 수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		isSelected = new boolean[N+1]; // 0번 인덱스는 사용 안함
		permutation(0);
	}

	
	// cnt : 현재까지 뽑은 수의 개수
	private static void permutation(int cnt) {
		// 기저부분
		if(cnt == M) {
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println("");
			return;
		}
		
		// 유도부분
		for(int i = 1; i <= N; i++) { // 가능한 모든 수 시도
			if(isSelected[i]) {
				continue;
			}
			
			numbers[cnt] = i; // 숫자뽑기
			isSelected[i] = true; // 뽑은 숫자 체크
			permutation(cnt + 1); // 다음 숫자 뽑으러 가기
			isSelected[i] = false; // 리턴하고 돌아왔을 때 뽑지 않은 상태로 되돌림
		}
	}
}