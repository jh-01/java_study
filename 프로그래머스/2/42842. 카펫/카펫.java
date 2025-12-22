class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
       
        // 가능한 모든 (a, b)를 구함
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i != 0) continue;
            int a = i;
            int b = yellow / i;
            
            if((a + 2) * (b + 2) - yellow == brown) {
                answer[0] = b + 2 ;
                answer[1] = a + 2;
            }
        }      
        return answer;
    }
}