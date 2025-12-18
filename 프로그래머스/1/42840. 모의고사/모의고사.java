import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        String[] choices = {"12345","21232425", "3311224455"};
        int maxGrade = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            int grade = 0;
            for(int j = 0; j < answers.length; j++){
                int choice = choices[i].charAt(j % choices[i].length()) - '0';
                if(choice == answers[j]) grade++;
            }
            if(grade > maxGrade) {
                maxGrade = grade;
                list = new ArrayList<>();
                list.add(i + 1);
            } else if(grade == maxGrade) list.add(i + 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}