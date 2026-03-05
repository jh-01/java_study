import java.io.*;
import java.util.*;

public class Main {

    private static int[][] cogwheels;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cogwheels = new int[4][8];
        for(int i = 0; i < 4; i++){
            String s = br.readLine();
            for(int j = 0; j < 8; j++){
                cogwheels[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{t, d});
        }

        for(int i = 0; i < K; i++){
            int[] temp = list.get(i);
            int t = temp[0] - 1;
            int d = temp[1];
            int[] rotateDir = new int[4];
            rotateDir[t] = d;

            // 왼쪽 전파
            for(int j = t; j > 0; j--){ 
                if(cogwheels[j][6] != cogwheels[j-1][2]){
                    rotateDir[j-1] = -rotateDir[j];
                } else break;
            }

            // 오른쪽 전파
            for(int j = t; j < 3; j++){
                if(cogwheels[j][2] != cogwheels[j+1][6]){
                    rotateDir[j+1] = -rotateDir[j];
                } else break;
            }

            for(int j = 0; j < 4; j++){
                if(rotateDir[j] == 1){
                    int c = cogwheels[j][7];
                    for(int k = 7; k > 0; k--){
                        cogwheels[j][k] = cogwheels[j][k - 1];
                    }
                    cogwheels[j][0] = c;
                } else if(rotateDir[j] == -1){
                    int c = cogwheels[j][0];
                    for(int k = 0; k < 7; k++){
                        cogwheels[j][k] = cogwheels[j][k + 1];
                    }
                    cogwheels[j][7] = c;
                }
                
            }
        }
        
        int score = 0;
        if(cogwheels[0][0] == 1) score += 1;
        if(cogwheels[1][0] == 1) score += 2;
        if(cogwheels[2][0] == 1) score += 4;
        if(cogwheels[3][0] == 1) score += 8;

        System.out.println(score);
    }
}
