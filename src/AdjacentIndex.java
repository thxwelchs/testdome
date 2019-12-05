/**
 *
 */
public class AdjacentIndex {
    public static void main(String[] args) {
        int[] A = new int[8];
        A[0] =  0;
        A[1] =  3;
        A[2] =  3;
        A[3] =  7;
        A[4] =  5;
        A[5] =  3;
        A[6] = 11;
        A[7] =  1;
        int result = solution(A);
        System.out.println("result = " + result);
    }

    private static int solution(int[] A) {
        int min = 100000000;

        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
               int distance = Math.abs(A[i] - A[j]);
               if(distance == 0) return 0;
               if(distance > 100000000) return -1;
               if(distance < min) {
                   min = distance;
               }
            }
        }

        return min;
    }
}
