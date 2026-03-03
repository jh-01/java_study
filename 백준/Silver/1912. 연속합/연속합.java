import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            nums[i] = x;
        }

        int[] dp = new int[N];
        dp[0] = nums[0];
        int maxResults = dp[0];

        for(int i = 1; i < N; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            maxResults = Math.max(maxResults, dp[i]);
        }

        System.out.println(maxResults);
    }
    
}