import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y, distance;
        List<Character> keys;

        Node(int x, int y, List<Character> keys, int distance) {
            this.x = x;
            this.y = y;
            this.keys = new ArrayList<>(keys);
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64]; // 여전히 64개의 상태를 관리하지만 비트마스크 대신 List<Character>로 상태 관리

        int startX = 0, startY = 0;

        // 맵 입력 및 시작 위치 탐색
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = bfs(startX, startY);
        System.out.println(result);
    }

    private static int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, new ArrayList<>(), 0)); // 시작 위치와 초기 상태 (키 없음) 설정
        visited[startX][startY][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                List<Character> nextKeys = new ArrayList<>(current.keys);

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue; // 맵을 벗어난 경우
                }

                char point = map[nextX][nextY];

                if (point == '#') {
                    continue; // 벽인 경우
                }

                // 문인 경우
                if (point >= 'A' && point <= 'F') {
                    if (!nextKeys.contains(Character.toLowerCase(point))) {
                        continue; // 해당 문을 열 수 있는 키가 없는 경우
                    }
                }

                // 키인 경우
                if (point >= 'a' && point <= 'f') {
                    if (!nextKeys.contains(point)) {
                        nextKeys.add(point); // 키를 획득
                    }
                }

                int keyState = convertKeysToState(nextKeys);

                if (!visited[nextX][nextY][keyState]) {
                    visited[nextX][nextY][keyState] = true;
                    if (point == '1') {
                        return current.distance + 1; // 목표 지점에 도달한 경우
                    }
                    queue.offer(new Node(nextX, nextY, nextKeys, current.distance + 1));
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }

    // 열쇠 리스트를 상태 값으로 변환하는 함수
    private static int convertKeysToState(List<Character> keys) {
        int state = 0;
        for (Character key : keys) {
            state |= (1 << (key - 'a'));
        }
        return state;
    }
}
