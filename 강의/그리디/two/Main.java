package 강의.그리디.two;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int result = 0;

        String[] numArray = s.split("");
        for(int i = 0; i < numArray.length; i++){
            System.out.println(i + "번쩨 숫자는 : " + numArray[i]);
            int num = Integer.parseInt(numArray[i]);
            if(i == 0) result += num;
            else {
                if(num < 2 || result < 2){
                    result += num;
                } else {
                    result *= num;
                }
            }
            
        }

        System.out.println(result);
        sc.close();
    }
}
