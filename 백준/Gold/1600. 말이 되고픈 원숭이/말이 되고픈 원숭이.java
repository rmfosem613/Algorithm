import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] hy = { -1, 1, -2, 2, -2, 2, -1, 1 };
    static int[][] map;
    static int K, W, H;
    static boolean[][][] visit;  // 말 점프 횟수를 고려한 방문 배열
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][K + 1];  // K+1을 사용하는 이유는 말 점프가 0번일 때도 고려해야 하기 때문

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 최단 경로 탐색
        bfs();

        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0, 0, K });  // 시작점 (0,0)에서 시작, 거리 0, 말 점프 K번 사용 가능
        visit[0][0][K] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int k = current[3];

            // 도착 지점에 도달하면 최소 거리 갱신
            if (x == H - 1 && y == W - 1) {
                min = distance;
                return;
            }

            // 말 점프 이동
            if (k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = x + hx[i];
                    int nextY = y + hy[i];

                    if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && !visit[nextX][nextY][k - 1]
                            && map[nextX][nextY] == 0) {
                        visit[nextX][nextY][k - 1] = true;
                        queue.offer(new int[] { nextX, nextY, distance + 1, k - 1 });
                    }
                }
            }

            // 네 방향 이동
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && !visit[nextX][nextY][k]
                        && map[nextX][nextY] == 0) {
                    visit[nextX][nextY][k] = true;
                    queue.offer(new int[] { nextX, nextY, distance + 1, k });
                }
            }
        }
    }
}
