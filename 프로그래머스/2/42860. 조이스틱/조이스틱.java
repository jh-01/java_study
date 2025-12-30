class Solution {
    public int solution(String name) {
        int answer = 0;
        int index = 0;
        int n = name.length();
        
        // 알파벳 계산
        for(int i = 0; i < n; i++){
            if(name.charAt(i) == 'A') continue;
            answer += getMinAlphabetCount(name.charAt(i));
        }
        
        // 커서 이동 계산
        int move = n - 1;
        for(int i = 0; i < n - 1; i++){
            int j = i + 1;
            
            // 연속된 A 구간 찾기
            while (j < n && name.charAt(j) == 'A') {
                j++;
            }
            move = Math.min(move, i * 2 + (n - j));
            move = Math.min(move, (n - j) * 2 + i);
        }
        
        return answer += move;
    }
    
    private int getMinAlphabetCount(char c){
        return Math.min(
            c - 'A',
            'Z' - c + 1
        );
    }
}