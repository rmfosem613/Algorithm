import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static boolean[] visit;
    static int[] arr;


    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);

        visit = new boolean[n];
        arr = new int[m];
        
        combination(0,0);
    }

    private static void combination(int cnt, int start) {
        if (cnt == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[cnt] = i + 1;
                combination(cnt + 1, i+1);
                visit[i] = false;
            }
        }
    }
}