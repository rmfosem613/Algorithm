import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		
		for (int test_case = 0; test_case < t; test_case++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][2];
			visited = new boolean[N + 2];
			
			for (int i = 0; i < N + 2; i++) {
				String[] split = br.readLine().split(" ");
				map[i][0] = Integer.parseInt(split[0]);
				map[i][1] = Integer.parseInt(split[1]);
			}

			boolean check = search();

			if (check)
				System.out.println("happy");
			else
				System.out.println("sad");

		}

	}

	private static boolean search() {
//		int distance = 0;
		visited[0] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { map[0][0], map[0][1] });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			
			if (cx == map[N + 1][0] && cy == map[N + 1][1]) {
//				System.out.println("여긴다");
				return true;
			}

			for (int i = 1; i < N + 2; i++) {
				if (!visited[i]) {
					int distance = Math.abs(cx - map[i][0]) + Math.abs(cy - map[i][1]);
					if (distance <= 1000) {
						visited[i] = true;
						queue.offer(new int[] { map[i][0], map[i][1] });
					}
				}
			}
			
			
		}

		return false;
	}
}
