class Solution {    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] count = new int[id_list.length];
        int[] numberOfMail = new int[id_list.length];
        int[][] reportMap = new int[id_list.length][id_list.length];
        
        for(int i = 0; i < report.length; i++){
            String s = report[i];
            String[] reportLine = s.split(" ");
            int reporter = getNumber(id_list, reportLine[0]);
            int reportee = getNumber(id_list, reportLine[1]);
            
            if(reportMap[reporter][reportee] == 0){
                reportMap[reporter][reportee] = 1;
                count[reportee]++;
            }
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] >= k){
                for(int j = 0; j < count.length; j++){
                    if(reportMap[j][i] == 1){
                        numberOfMail[j]++;
                    }
                }
            }
        }
        return numberOfMail;
    }
    
    private int getNumber(String[] id_list, String s){
        for(int i = 0; i < id_list.length; i++){
            if(s.equals(id_list[i])) return i;
        }
        return -1;
    }
}