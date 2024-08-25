import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.offer(num);
		}
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			if(answer + queue.peek() <= 100) {
				answer += queue.poll();
			}
			else if(answer + queue.peek() > 100) {
				int temp = answer + queue.peek();
				if(Math.abs(100-answer) >= Math.abs(100-temp)) {
					answer += queue.poll();
					break;
				} else break;
			}
		}
		
		System.out.println(answer);
	}
}
