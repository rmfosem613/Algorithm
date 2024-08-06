import java.util.*;
import java.awt.Point;
import java.io.FileInputStream;

class Solution
{
    static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static char map[][] = new char[100][100];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			visited = new boolean[100][100];

			for (int i = 0; i < 100; i++) {
				String tmp = sc.next();
				map[i] = tmp.toCharArray();
			}
			System.out.println("#" + test_case + " " + bfs(1, 1));

		}
		sc.close();
	}

	private static int bfs(int x, int y) {
		visited[x][y] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = currentPoint.x + dx[i];
				int nextY = currentPoint.y + dy[i];

				// 1. 범위 이내에 있는가?
				if (nextX < 0 || nextX >= 98 || nextY < 0 || nextY >= 98)
					continue; // 범위에서 나가면 제끼기
				// 2. 막힌 길인가?
				if (map[nextX][nextY] == '1')
					continue; // 막힌 길이면 제끼기
				// 3. 이미 방문 했나?
				if (visited[nextX][nextY])
					continue; // 방문했으면(true 이면) 제끼기

				// 방문하지 않은 길이라면 큐에 삽입하고 방문처리
				queue.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = true;

				// 목표 지점 도달 시 최소 칸 수 반환
				if (map[nextX][nextY] == '3') {
					return 1;
				}
			}
		}
		return 0; // 목표 지점에 도달할 수 없는 경우 -1 반환
	}
}