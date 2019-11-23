import java.util.HashMap;
import java.util.Map;

public class Season {
    public static void main(String[] args) {
        String result = solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3});
        System.out.println("result = " + result);

        String result2 = solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18});
        System.out.println("result2 = " + result2);

    }

    public static String solution(int[] T) {

        String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};

        // 진폭값을 저장할 HashMap 키는 계절명으로 하고 값은 진폭값이 된다.
        Map<String, Integer> ampMap = new HashMap<>();
        int season = 0;

        // 계절 4분기
        int quarter = T.length / 4;

        // 계절 별 최고, 최저 온도 값
        int max = 0;
        int min = 0;

        for (int i = 0; i < T.length; i++) {
            int v = T[i];

            if(v > max) max = v;
            // min값 초기화시 min값으로 넣어주기 위한 조건 min == 0
            if(min == 0 || v < min) min = v;

            if(i > 0 && (i+1) % quarter == 0) {
                // 진폭 값 계산하여 절대값으로 hashmap에 put
                int amp = max - min;
                ampMap.put(seasons[season], Math.abs(amp));

                max = 0;
                min = 0;
                // 다음시즌으로 넘기기
                season++;
            }
        }

        // HashMap에 저장되어 있는 계절별 진폭값을 순회하여 최고값을 구한다.
        String result = "";
        int ampMax = 0;
        for(String key: ampMap.keySet()) {
            int seasonAmp = ampMap.get(key);
            if(seasonAmp > ampMax) {
                ampMax = seasonAmp;
                result = key;
            }
        }

        return result;
    }
}
