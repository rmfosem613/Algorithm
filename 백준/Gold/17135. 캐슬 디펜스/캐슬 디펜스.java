import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	private static class Enemy implements Comparable<Enemy> {
		
		public int r;  // 행
		public int c;  // 열
		public int damage;  // 화살 맞은 횟수
		
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + ", damage=" + damage + "]";
		}

		@Override
		public int compareTo(Enemy o) {
			// 열 기준 오름차순 정렬
			return this.c - o.c;
		}
		
	}
	
	private static class Archer {
		
		public int r;  // 행
		public int c;  // 열
		
		public Archer(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Archer [r=" + r + ", c=" + c + "]";
		}
	}

	
	private static int N;  // 격자판의 행의 수
	private static int M;  // 격자판의 열의 수
	private static int D;  // 궁수의 공격 거리 제한
	private static List<Enemy> enemies;  // 적들의 정보 저장
	
	private static int R = 3;
	private static int[] numbers;  // 궁수의 열 위치
	private static int max;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 입력파일 객체화
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		D = Integer.parseInt(split[2]);

		// 적들의 정보 저장
		enemies = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				if (split[j].equals("1")) {
					enemies.add(new Enemy(i, j));
				}
			}
		}

		max = Integer.MIN_VALUE;
		numbers = new int[R];  // 궁수 3명 고정
		combination(0, 0);
		System.out.println(max);
	}

	// cnt: 직전까지 뽑은 조합에 포함된 수의 개수
	// start: 시도할 수의 시작 위치
	private static void combination(int cnt, int start) {

		// 기저 부분
		if (cnt == R) {
			// 적들의 정보 백업
			List<Enemy> temp = new ArrayList<>();
			for (Enemy e : enemies) {
				temp.add(new Enemy(e.r, e.c));
			}
			
			// 궁수 3명 생성하고 위치 저장
			List<Archer> archers = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				archers.add(new Archer(N, numbers[i]));  // 행은 같고(성의 위치), 열은 경우의 수로 구한 열 번호 사용)
			}
			
			int killCount = 0;
			
			do {
				
				// 궁수와 가까운 거리의 적을 찾아 제거
				for (Archer a : archers) {
					
					// 가장 가까운 적부터 찾기
					for (int i = 1; i <= D; i++) {  // 사거리를 1씩 늘리면서 탐색
						
						// 전체 적을 순회하면서 사격거리에 들어오는 적을 담기
						List<Enemy> targets = new ArrayList<>();
						for (Enemy e : enemies) {
							
							// 적과 궁수 간의 거리 구하기
							int dist = Math.abs(e.r - a.r) + Math.abs(e.c - a.c);  // 맨해튼 거리 공식
							if (dist == i) {
								targets.add(e);
							}
						}
						
						// targets 리스트가 비어있지 않으면, 사살할 수 있는 적이 있음
						if (!targets.isEmpty()) {
							
							// 가장 왼쪽 적부터 제거
							Collections.sort(targets);
							
							targets.get(0).damage++;
							break;
						}
					}
				}
				
				// 한 턴이 끝나고 타겟에 들어온 적을 제거하고, 적을 아래로 이동
				for (int i = enemies.size() - 1; i >= 0; i--) {  // 제거되는 적이 있기 때문에 뒤에서 탐색
					
					Enemy e = enemies.get(i);
					
					if (e.damage > 0) {
						enemies.remove(e);
						killCount++;
						continue;
					}
					
					// 해당 적을 한 칸 아래로 이동
					e.r += 1;
					
					// 만약 적이 격자판 밖으로 나가면 제거
					if (e.r >= N) {
						// 제거
						enemies.remove(e);
					}
				}
				
			} while (!enemies.isEmpty());  // 적이 없어질 때까지 반복 (게임 종료 조건)
			
			if (killCount > max) {
				max = killCount;
			}
			
			// 적들의 정보 원복
			enemies = new ArrayList<>();
			for (Enemy e : temp) {
				enemies.add(e);
			}
			return;
		}

		// 유도 부분
		for (int i = start; i < M; i++) {  // 선택지

			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
