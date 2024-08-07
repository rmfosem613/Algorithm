import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Solution
{
	static List<List<Integer>> graph;
	static int N,M;
	static boolean[] visited;
	static int cnt;
        
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input1.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        int T;
        T = Integer.parseInt(in.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            
            String arr[] = in.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            graph = new ArrayList<>();
            
            for(int i = 0; i <= N; i++) {
            	graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < M; i++) {
            	String line[] = in.readLine().split(" ");
            	int u = Integer.parseInt(line[0]);
            	int v = Integer.parseInt(line[1]);
            	
            	graph.get(u).add(v);
            	graph.get(v).add(u);
            }
            
            visited = new boolean[N+1];
            cnt = 0;
            
            for(int i = 1; i <= N; i++) {
            	if(!visited[i]) {
            		cnt++;
            		dfs(i);
            	}
            }
            
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
	}

	private static void dfs(int node) {
		
		visited[node] = true;
		for(int neighbor : graph.get(node)) {
			if(!visited[neighbor]) {
				dfs(neighbor);
			}
		}
		
	}

	
}
