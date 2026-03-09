import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int zeroCount = 0;
        int[] belt = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++){
            belt[i] = Integer.parseInt(st.nextToken());       
            if(belt[i] == 0) zeroCount++;
        }
        
        int stage = 0;
        boolean[] robots = new boolean[2*N];
        int start = 0;
        int robotNum = 0;
        while(true){
            if(zeroCount >= K) break;

            stage++;

            // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            start = (start - 1 + 2 * N) % (2 * N);
            int down = (start + N - 1) % (2 * N);
            robots[down] = false;

            // 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
            for(int i = N - 2; i >= 0; i--){
                int cur = (start + i) % (2 * N);
                int next = (start + i + 1) % (2 * N);

                if(robots[cur] && !robots[next] && belt[next] > 0){
                    robots[cur] = false;
                    robots[next] = true;
                    belt[next]--;
                    if(belt[next] == 0) zeroCount++;
                }
            }
            robots[down] = false;

            //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다
            if(!robots[start] && belt[start] > 0){
                robots[start] = true;
                belt[start]--;
                if(belt[start] == 0) zeroCount++;
            }
        }
        System.out.println(stage);
    }
}
