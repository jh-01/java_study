import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, List<Integer>> genreListMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            // total.compute(genres[i], (key, value) -> value == null ? plays[i] : value + plays[i]);
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            // genreListMap.compute(genres[i], (key, value) -> {
            //     if (value == null) {
            //         List<Integer> list = new ArrayList<>();
            //         list.add(i);
            //         return list;
            //     } else {
            //         value.add(i);
            //         return value;
            //     }
            // });
            genreListMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }

        // 장르별 내림차순
        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((a, b) -> total.get(b) - total.get(a));

        // 상위 두개만 포함
        for (String genre : keySet) {
            List<Integer> list = genreListMap.get(genre);

            list.sort((a, b) -> {
                if (plays[b] != plays[a]) return plays[b] - plays[a];
                return a - b;
            });

            answer.add(list.get(0));
            if (list.size() > 1)
                answer.add(list.get(1));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}