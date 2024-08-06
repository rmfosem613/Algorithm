import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        /**
         * 0. 입력파일 읽어들이기
         */
        // System.setIn(new FileInputStream("input2.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            // 둘째 줄
            int size = Integer.parseInt(in.readLine());

            map = new int[size][size];

            for (int i = 0; i < size; i++) {
                String line = in.readLine();
                String[] arr = line.split("");
                
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(arr[j]);
                }
            }
            
            int sum = 0;
            int limit = size / 2;
            
            for(int i = 0; i < size; i++) {
                if(i == limit) {
                    for(int j = 0; j < size; j++) {
                        sum += map[i][j];
                    }
                } else if (i < limit) {
                    for(int j = limit - i; j <= limit + i; j++) {
                        sum += map[i][j];
                    }
                } else {
                    for(int j = i - limit; j < size - (i - limit); j++) {
                        sum += map[i][j];
                    }
                }
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}