import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        List<Integer> stack = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        HashMap<String, Integer> termsArray = new HashMap<String, Integer>();
        String[][] privacyArray = new String[privacies.length][2];
        
        for(int i = 0; i < terms.length; i++){
            String[] sArray = terms[i].split(" ");
            termsArray.put(sArray[0], Integer.parseInt(sArray[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] sArray = privacies[i].split(" ");
            privacyArray[i][0] = sArray[0];
            privacyArray[i][1] = sArray[1];
        }
        
        for(int i = 0; i < privacies.length; i++){
            try{
                Date startDate = formatter.parse(privacyArray[i][0]);
                int period = termsArray.get(privacyArray[i][1]);

                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.add(Calendar.MONTH, period);
                cal.add(Calendar.DATE, -1);

                // 오늘 날짜와 비교
                Date todayDate = formatter.parse(today);
                if (cal.getTime().compareTo(todayDate) < 0) {
                    stack.add(i + 1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    
        answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}