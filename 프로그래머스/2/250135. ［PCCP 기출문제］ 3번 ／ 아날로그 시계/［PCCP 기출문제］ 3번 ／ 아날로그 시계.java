class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = h1 * 3600 + m1 * 60 + s1;
        int end   = h2 * 3600 + m2 * 60 + s2;
        
        // 시작 시간에 이미 겹쳐 있는 경우 처리 (0시 또는 12시)
        if (isMatch(start)) answer++;

        for(int i = start; i< end; i++){
            double secAngle1  = (i % 60) * 6;
            double minAngle1  = (i % 3600) / 60.0 * 6;
            double hourAngle1 = (i % 43200) / 3600.0 * 30;
            
            double secAngle2  = ((i + 1) % 60 == 0) ? 360 : ((i + 1) % 60) * 6;
            double minAngle2  = ((i + 1) % 3600 == 0) ? 360 : ((i + 1) % 3600) / 60.0 * 6;
            double hourAngle2 = ((i + 1) % 43200 == 0) ? 360 : ((i + 1) % 43200) / 3600.0 * 30;
            
            boolean moveS_over_M = (secAngle1 < minAngle1) && (secAngle2 >= minAngle2);
            boolean moveS_over_H = (secAngle1 < hourAngle1) && (secAngle2 >= hourAngle2);
            if (moveS_over_M && moveS_over_H) {
                // 시침과 분침이 같은 위치에 있어서 초침이 동시에 둘 다 만나는 경우
                if (minAngle2 == hourAngle2) answer++;
                else answer += 2;
            } else if (moveS_over_M || moveS_over_H) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 특정 시간에 초침이 시침이나 분침과 겹치는지 확인하는 헬퍼 함수
    private boolean isMatch(int time) {
        double s = (time % 60) * 6;
        double m = (time % 3600) / 60.0 * 6;
        double h = (time % 43200) / 3600.0 * 30;
        return s == m || s == h;
    }
}