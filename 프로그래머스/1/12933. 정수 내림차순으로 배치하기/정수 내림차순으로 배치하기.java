import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int N = Long.valueOf(n).toString().length();

		char[] list = new char[N];

		list = Long.valueOf(n).toString().toCharArray();

		System.out.println(list);

		List<Integer> OrderList = new ArrayList<Integer>();

		for (int i = 0; i < list.length; i++) {
			OrderList.add(list[i] - 48);
		}

		Collections.sort(OrderList);
		
		Collections.reverse(OrderList);

		String temp = "";

		for (int i = 0; i < OrderList.size(); i++) {
			temp += OrderList.get(i) + "";
		}
		
		answer += Long.valueOf(temp);
        return answer;
    }
}