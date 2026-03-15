import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                    
                }
            }
        }

        // 결과 출력
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j] == Integer.MAX_VALUE) System.out.print("INF ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
