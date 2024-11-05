import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
	static int N, M;
	static char map[][];

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static Queue<int[]> water;
	static int[][] distance;

	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
            sb.append("#"+test_case+" ");
			String[] split = br.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);
			map = new char[N][M];
			distance = new int[N][M];

			// 다익스트라
			for (int[] d : distance) {
				Arrays.fill(d, INF);
			}

			water = new ArrayDeque<int[]>();

			// map 입력받기
			for (int i = 0; i < N; i++) {
				String split2 = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = split2.charAt(j);

					if (map[i][j] == 'W') {
						water.offer(new int[] { i, j });
						distance[i][j] = 0;
//						list.add(new int[] { i, j });
					}
				}
			}

			int sum = 0;
			bfs();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += distance[i][j];
//					System.out.print(distance[i][j] + " ");
				}
//				System.out.println();
			}
			sb.append(sum + " \n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		while (!water.isEmpty()) {
			int[] temp = water.poll();
			int cx = temp[0];
			int cy = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					
					if(distance[nx][ny] > distance[cx][cy] + 1 && map[nx][ny] == 'L') {
						distance[nx][ny] = distance[cx][cy] + 1;
						water.offer(new int[] {nx,ny});
					}
				}
			}
		}

	}

//	private static int bfs(int x, int y) {
//		Queue<int[]> queue = new ArrayDeque<>();
//		queue.offer(new int[] { x, y, 0 });
//
//		boolean[][] visited = new boolean[N][M];
//		visited[x][y] = true;
//
//		int ans = Integer.MAX_VALUE;
//		while (!queue.isEmpty()) {
//			int[] temp = queue.poll();
//			int cx = temp[0];
//			int cy = temp[1];
//			int cd = temp[2];
//
//			if (map[cx][cy] == 'W') {
//				ans = Math.min(ans, cd);
//				return ans;
//			}
//
//			for (int i = 0; i < 4; i++) {
//				int nx = cx + dx[i];
//				int ny = cy + dy[i];
//
//				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
//					visited[nx][ny] = true;
//					queue.offer(new int[] { nx, ny, cd + 1 });
//				}
//			}
//
//		}
//		return 0;
//	}
}
