import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;

		String a = (k == 10) ? Integer.toString(n) : Integer.toString(n, k);

		System.out.println(a);

		String[] split = a.split("0");

		List<String> list = new ArrayList<>();

		for (String s : split) {
			if(!s.isEmpty()) {
//				System.out.println(s);
				list.add(s);
			}
		}

		for (String l : list) {
			if (check(l)) {
				answer++;
			}
		}
        return answer;
    }
    private static boolean check(String string) {

		long c = Long.parseLong(string);

		if (c < 2) {
			return false;
		}

		for (long i = 2; i * i <= c; i++) {
			if (c % i == 0)
				return false;
		}

		return true;
	}
}