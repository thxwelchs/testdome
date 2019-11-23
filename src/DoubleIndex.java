import java.util.*;

// 인덱스 쌍 찾기

// N개의 배열 중 원소가 같은 2개의 쌍 찾기
// 0 <= P < Q < N
public class DoubleIndex {
    public static void main(String[] args) {
        solution(new int[]{3, 5, 6, 3, 3, 5});
    }

    public static int solution(int[] A) {
        Map<Integer, LinkedList<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            boolean hasKey = indexMap.containsKey(v);

            LinkedList<Integer> list = new LinkedList<>();
            if(hasKey) {
                list = indexMap.get(v);
            }
            list.add(i);
            indexMap.put(v, list);
        }

        /**
         * A[0] = 3
         * A[1] = 5
         * A[2] = 6
         * A[3] = 3
         * A[4] = 3
         * A[5] = 5
         */
        for(Integer key: indexMap.keySet()) {
            LinkedList<Integer> list = indexMap.get(key);

            if(list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i);

                }
            }

        }

        System.out.println("indexMap = " + indexMap);

        return 0;
    }
}
