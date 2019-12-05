import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class TripDay {
    public static void main(String[] args) {

//        int[] A = new int[8];
//        A[0] = 7;
//        A[1] = 3;
//        A[2] = 7;
//        A[3] = 3;
//        A[4] = 1;
//        A[5] = 3;
//        A[6] = 4;
//        A[7] = 1;
//        int[] A = new int[]{2, 1, 1, 3, 2, 1, 1, 3};
        int[] A = new int[]{7, 5, 2, 7, 2, 7, 4, 7};
        int result = solution(A);
        System.out.println("result = " + result);
    }

    private static int solution(int[] A) {
        int min = 100000;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
           set.add(A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> indexList = new ArrayList<>();
            list.add(A[i]);
            indexList.add(i);
            for (int j = i+1; j < A.length; j++) {
                list.add(A[j]);
                indexList.add(j);
            }

//            boolean isAllContain = true;
            List<Integer> containList = new ArrayList<>(set);
            int firstContainIndex = indexList.get(0);
            int lastContainIndex = 0;
            for (int j = 0; j < list.size(); j++) {
                int elm = list.get(j);
                if(set.contains(elm)) {
                    int findContainIndex = containList.indexOf(elm);
                    if(findContainIndex > -1) {
                        containList.remove(findContainIndex);
                    }
                }

                if(containList.size() == 0) {
                    lastContainIndex = indexList.get(j);
                    break;
                }
            }

            if(containList.size() == 0) {
                int minTripDay = lastContainIndex - firstContainIndex + 1;
                if(minTripDay < min)
                    min = minTripDay;
            }

        }
        return min;
    }
}
