class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int yLength = park.length;
        int xLength = park[0].length();
        System.out.println("xLen : " + xLength);
        System.out.println("yLen : " + yLength);
        
        int[][] parkInfo = new int[yLength][xLength];
        for(int i = 0; i < yLength; i++){
            String[] parkLine = park[i].split("");
            for(int j = 0; j < xLength; j++){
                if(parkLine[j].equals("O")){
                    parkInfo[i][j] = 0;
                } else if(parkLine[j].equals("S")){
                    answer[0] = i;
                    answer[1] = j;
                    parkInfo[i][j] = 0;
                } else {
                    parkInfo[i][j] = -1;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");
            int walk = Integer.parseInt(route[1]);
            boolean flag = true;
            
            if(route[0].equals("E")){
                if(answer[1] + walk < xLength){
                    for(int k = 1; k <= walk; k++){
                        if(parkInfo[answer[0]][answer[1] + k] == -1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer[1] += walk;
                }
            } else if(route[0].equals("W")){
                if(answer[1] - walk >= 0){
                    for(int k = 1; k <= walk; k++){
                        if(parkInfo[answer[0]][answer[1] - k] == -1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer[1] -= walk;
                }
            } else if(route[0].equals("S")){
                if(answer[0] + walk < yLength){
                    for(int k = 1; k <= walk; k++){
                        if(parkInfo[answer[0] + k][answer[1]] == -1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer[0] += walk;
                }
            } else {
                if(answer[0] - walk >= 0){
                    for(int k = 1; k <= walk; k++){
                        if(parkInfo[answer[0] - k][answer[1]] == -1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer[0] -= walk;
                }
            }
        }
        return answer;
    }
}