import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int w, h;
    // 왼쪽위, 위, 오른쪽위, 오른쪽, 오른쪽아래, 아래, 외쪽아래, 왼쪽
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static boolean visited[][];
    static int[][] map;
    static int count;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] split = br.readLine().split(" ");
            w = Integer.parseInt(split[0]);
            h = Integer.parseInt(split[1]);

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                split = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    if (Integer.parseInt(split[j]) == 0) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = INF;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == INF && !visited[i][j]) {
                        ++count;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = count;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
            if (!visited[nextX][nextY] && map[nextX][nextY] == INF) {
                dfs(nextX, nextY);
            }
        }
    }
}
