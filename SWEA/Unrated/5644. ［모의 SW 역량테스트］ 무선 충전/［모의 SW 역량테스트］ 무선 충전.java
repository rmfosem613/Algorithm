import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//좌표 클래스
class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 좌표 움직이는 함수
	public void move(int dir) {
		switch (dir) {
		case 1:
			y--;
			break; // 상
		case 2:
			x++;
			break; // 우
		case 3:
			y++;
			break; // 하
		case 4:
			x--;
			break; // 좌
		}
	}
}

//BC(Battery Charger) 클래스
class BC {
	Point point; // 좌표
	int C, P; // 충전 범위, 처리량

	public BC(Point point, int C, int P) {
		this.point = point;
		this.C = C;
		this.P = P;
	}
}
class Solution
{
	static int M, A, res; // 총 이동시간(M), BC 개수(A), 최대값 결과(res)
	static int[] dirA, dirB; // A, B 이동정보
	static BC[] BCs; // BC 배열

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			String[] split = br.readLine().split(" ");
			M = Integer.parseInt(split[0]);
			A = Integer.parseInt(split[1]);

			BCs = new BC[A];
			res = 0;

			// A,B 이동정보 저장
			dirA = new int[M];
			dirB = new int[M];
			split = br.readLine().split(" ");
			String[] split2 = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				dirA[i] = Integer.parseInt(split[i]);
				dirB[i] = Integer.parseInt(split2[i]);
			}

			for (int i = 0; i < A; i++) {
				split = br.readLine().split(" ");
				// BC 정보 (x, y, c, p 저장)
				BCs[i] = new BC(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])),
						Integer.parseInt(split[2]), Integer.parseInt(split[3]));
			}

			solution();
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}

	private static void solution() {
		// 초기 좌표 입력
		Point userA = new Point(1, 1);
		Point userB = new Point(10, 10);

		// 처음 좌표에서 충전 가능한지 판단
		charge(userA, userB);

		for (int i = 0; i < M; i++) {
			// A와 B 움직인후 충전 가능한지 판단
			userA.move(dirA[i]);
			userB.move(dirB[i]);
			charge(userA, userB);
		}
	}

	private static void charge(Point userA, Point userB) {
		// A와 B 위치의 접속 가능한 BC 리스트
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		// BC 개수만큼 반복
		for (int i = 0; i < A; i++) {
			// A와 각 BC와의 거리가 접속 가능하다면 ( 충전범위 C >= 거리 D )
			if (BCs[i].C >= (Math.abs(BCs[i].point.x - userA.x)) + Math.abs(BCs[i].point.y - userA.y)) {
				listA.add(i);
			}
			// B와 각 BC와의 거리가 접속 가능하다면 ( 충전범위 C >= 거리 D )
			if (BCs[i].C >= (Math.abs(BCs[i].point.x - userB.x)) + Math.abs(BCs[i].point.y - userB.y)) {
				listB.add(i);
			}
		}

		int max = 0, temp = 0;

		// A와 B가 접속 가능한 모두 1개 이상이라면
		if (listA.size() > 0 && listB.size() > 0) {
			// 완전 탐색으로 가능한 조합을 모두 비교하여 최대 처리량P 구하기
			for (int i : listA) {
				for (int j : listB) {
					temp = 0;
					if (i == j) { // 같은 BC인 경우 처치량 나눠가지므로 한개만 더하기
						temp = BCs[i].P;
					} else { // 같은 BC가 아닌 경우 각각 처리량 더하기
						temp += BCs[i].P;
						temp += BCs[j].P;
					}
					max = Math.max(max, temp);
				}
			}
			// A가 접속 가능한 BC가 1개 이상이라면
		} else if (listA.size() > 0) {
			// 접속 가능한 BC중 최대 처리량P 구하기
			for (int i : listA) {
				if (max < BCs[i].P)
					max = BCs[i].P;
			}
			// B가 접속 가능한 BC가 1개 이상이라면
		} else if (listB.size() > 0) {
			// 접속 가능한 BC중 최대 처리량P 구하기
			for (int i : listB) {
				if (max < BCs[i].P)
					max = BCs[i].P;
			}
		}
		res += max; // 결과 누적
	}
}