import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			map = new int[N][N];

			result = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String split[] = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(split[j]);
				}
			}

			bfs(0, 0);

			System.out.println("Problem " + (cnt++) + ": " + result);
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		queue.add(new int[] { 0, 0, map[0][0] });
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			int cd = temp[2];

			if (cx == N - 1 && cy == N - 1) {
				result = Math.min(result, cd);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, cd + map[nx][ny] });
				}
			}
		}

	}
}
