import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][N + 1];
        // 길이가 1
        for(int i = 1; i <= N; i++){
            dp[i][i] = 1;
        }

        // 길이가 2
        for(int i = 1; i < N; i++){
            if(nums[i] == nums[i + 1]){
                dp[i][i + 1] = 1;
            }
        }

        // 나머지 (길이가 3 이상이니까 3부터 시작)
        for(int len = 3; len <= N; len++){
            for(int s = 1; s <= N - len + 1; s++){ // 시작 인덱스
                int e = s + len - 1; // 끝 인덱스
                if(nums[s] == nums[e] && dp[s + 1][e - 1] == 1){
                    dp[s][e] = 1;
                }

            }
        }
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append('\n');
        }

        System.out.print(sb);
    }
}
