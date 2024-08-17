import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	static int buildingNum;
	static List<Building> buildings;

	static class Building {
		int x;
		int y;

		public Building(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		buildingNum = Integer.parseInt(br.readLine());
		buildings = new ArrayList<>();

		for (int cnt = 0; cnt < buildingNum; cnt++) {
			String[] split = br.readLine().split(" ");
			buildings.add(new Building(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}

		solution();
	}

	private static void solution() {
		// Comparator를 사용해 Building을 x 기준으로 정렬
		Collections.sort(buildings, new Comparator<Building>() {
			@Override
			public int compare(Building b1, Building b2) {
				if (b1.x != b2.x) {
					return b1.x - b2.x;
				}
				return b1.y - b2.y;
			}
		});

		int[] dp = new int[buildingNum + 1];

		for (int basisIdx = 1; basisIdx <= buildingNum; basisIdx++) {
			int dist = 0;
			dp[basisIdx] = Integer.MAX_VALUE;

			for (int idx = basisIdx; idx >= 1; idx--) {
				dist = Math.max(dist, Math.abs(buildings.get(idx - 1).y));
				dp[basisIdx] = Math.min(dp[basisIdx],
						dp[idx - 1] + Math.max(2 * dist, buildings.get(basisIdx - 1).x - buildings.get(idx - 1).x));
			}
		}

		System.out.println(dp[buildingNum]);

	}

}
