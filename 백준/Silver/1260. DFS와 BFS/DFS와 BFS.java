import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, V;
	static boolean visited[];
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		V = Integer.parseInt(split[2]);

		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);

			// 무향 그래프
			adjList[from].add(to);
			adjList[to].add(from);
		}

		// 인접 리스트 정렬 (오름차순)
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}

		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
		System.out.println();
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (int l : adjList[current]) {
				if (!visited[l]) {
					visited[l] = true;
					queue.offer(l);
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int l : adjList[v]) {
			if (!visited[l]) {
				dfs(l);
			}
		}
	}
}
