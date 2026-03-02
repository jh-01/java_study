import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String roomNumber = sc.nextLine();
        int[] numberCounts = new int[9];

        for(char c : roomNumber.toCharArray()){
            int temp = c - '0';
            if(temp == 9) numberCounts[6]++;
            else numberCounts[c - '0']++;
        }

        int result = 0;

        for(int i = 0; i < 9; i++){
            int need = 0;
            if(i == 6){
                need = (numberCounts[6] + 1) / 2;;
            } else {
                need = numberCounts[i];
            }
            result = Math.max(result, need);
        }

        System.out.println(result);
    }
}
