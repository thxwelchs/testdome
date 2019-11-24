import java.util.HashMap;
import java.util.Map;

/**
 * N등급의 군인이 있고, N+1등급의 군인에게 경례할 수 있을 때
 * 경례할 수 있는 횟수를 구하기
 */
public class SoldiersCanReport {
    public static void main(String[] args) {
        int[] ranks = new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0};
        int result = solution(ranks);
        System.out.println("result = " + result);

        int[] ranks2 = new int[]{4, 4, 3, 3, 1, 0};
        int result2 = solution(ranks2);
        System.out.println("result2 = " + result2);

        int[] ranks3 = new int[]{4, 2, 0};
        int result3 = solution(ranks3);
        System.out.println("result3 = " + result3);
    }

    public static int solution(int[] ranks) {

        // 계급별 군인 명수 카운트
        Map<Integer, Integer> rankCntMap = new HashMap<>();
        
        for (int i = 0; i < ranks.length; i++) {
            int rank = ranks[i];
            
            // null이 될 수 있는 Wrapper class로 변수 할당
            Integer rankCnt = rankCntMap.get(rank);
            if(rankCnt == null) {
                rankCntMap.put(rank, 1);
                continue;
            }

            rankCnt++;
            rankCntMap.put(rank, rankCnt);
        }

        /**
         * HashMap을 순회하여 경례 받을 대상의 카운트를 합산
         */
        int result = 0;

        for(Integer key: rankCntMap.keySet()) {
            int rank = key;
            Integer saluteTargetRank = rankCntMap.get(rank- 1);
            if(saluteTargetRank != null) {
                result += saluteTargetRank;
            }
        }

        return result;
    }
}
