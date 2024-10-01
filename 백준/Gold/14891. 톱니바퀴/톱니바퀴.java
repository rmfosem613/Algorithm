import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] map;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][8]; // 1번 톱니바퀴부터 시작

		for (int i = 1; i <= 4; i++) {
			String split = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = split.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			String[] split = br.readLine().split(" ");
			int num = Integer.parseInt(split[0]); // 몇 번 째 톱니바퀴가
			int Dir = Integer.parseInt(split[1]); // 시계방향회전 : 1 , 반시계방향회전 : -1
			int oDir = 0;

			if (Dir == 1) {
				oDir = -1;
			} else {
				oDir = 1;
			}

			switch (num) {
			case 1:
				if (map[1][2] != map[2][6]) {
					if (map[2][2] != map[3][6]) {
						if (map[3][2] != map[4][6]) {
							rotate(4, oDir);
						}
						rotate(3, Dir);
					}
					rotate(2, oDir);
				}
				rotate(1, Dir);
				break;
			case 2:
				if (map[1][2] != map[2][6]) {
					rotate(1, oDir);
				}
				if (map[2][2] != map[3][6]) {
					if (map[3][2] != map[4][6]) {
						rotate(4, Dir);
					}
					rotate(3, oDir);
				}
				rotate(2, Dir);
				break;
			case 3:
				if (map[3][6] != map[2][2]) {
					if (map[1][2] != map[2][6]) {
						rotate(1, Dir);
					}
					rotate(2, oDir);
				}
				if (map[3][2] != map[4][6]) {
					rotate(4, oDir);
				}
				rotate(3, Dir);
				break;
			case 4:
				if (map[4][6] != map[3][2]) {
					if (map[2][2] != map[3][6]) {
						if (map[1][2] != map[2][6]) {
							rotate(1, oDir);
						}
						rotate(2, Dir);
					}
					rotate(3, oDir);
				}
				rotate(4, Dir);
				break;
			}
		}

		int result = 0;

		if (map[1][0] == 1)
			result += 1;
		if (map[2][0] == 1)
			result += 2;
		if (map[3][0] == 1)
			result += 4;
		if (map[4][0] == 1)
			result += 8;

		System.out.println(result);

	}

	private static void rotate(int num, int dir) {
		// 시계 방향으로 회전시키기
		if (dir == 1) {
			int temp = map[num][7];
			for (int i = 7; i > 0; i--) {
				map[num][i] = map[num][i - 1];
			}
			map[num][0] = temp;
		}
		// 반시계 방향으로 회전시키기
		else {
			int temp = map[num][0];
			for (int i = 0; i < 7; i++) {
				map[num][i] = map[num][i + 1];
			}
			map[num][7] = temp;
		}
	}
}
