package 강의.구현.three;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] startIndex = s.split("");

        int row = Integer.parseInt(startIndex[1]);
        int column = startIndex[0].charAt(0) - 'a' + 1;

        int[][] steps = {
            {-2, -1},
            {-2, 1},
            {2, -1},
            {2, 1},
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
        };

        int result = 0;

        for(int i = 0; i < steps.length; i++){
            int dx = column + steps[i][0];
            int dy = row + steps[i][1];
            if(dx > 0 && dx <= 8 && dy > 0 && dy <= 8)
                result++;
        }

        System.out.println(result);
    }
}