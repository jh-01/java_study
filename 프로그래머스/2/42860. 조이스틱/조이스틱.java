class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = n - 1;
        int minAlphCount = 0;
        
        for(int i = 0; i < n; i++){
            char c = name.charAt(i);
            if(c == 'A') continue;
            minAlphCount += getMinAlphCount(c);
        }
        
        for(int i = 0; i < n; i++){
            int nextInt = i + 1;
            while(nextInt < n && name.charAt(nextInt) == 'A'){
                nextInt++;
            }
            
            int leftMove = i * 2 + n - nextInt;
            answer = answer > leftMove ? leftMove : answer;
            
            int rightMove = (n - nextInt) * 2 + i;
            answer = answer > rightMove ? rightMove : answer;

        }
        return answer + minAlphCount;
    }
    
    private int getMinAlphCount(char c){
        int prevCount = c - 'A';
        int nextCount = 'Z' - c + 1;
        return prevCount >= nextCount? nextCount : prevCount;
    }
}