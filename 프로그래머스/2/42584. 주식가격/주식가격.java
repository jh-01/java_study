import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < prices.length - 1; i++){
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                int temp = st.pop();
                answer[temp] = i - temp;
            }
            st.push(i);
        } 
        
        while(!st.isEmpty()){
            int temp = st.pop();
            answer[temp] = n - 1 - temp;
        }
        
        
        return answer;
    }
}