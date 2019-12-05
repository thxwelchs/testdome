/**
 * 언덕과 계곡 성
 * The terrain height of each segment from P to Q is the same (A[P] = A[P+1] = ... = A[Q]) // 계곡
 * If P > 0 then A[P−1] < A[P] (for a hill) or A[P−1] > A[P] (for a valley)
 * If Q < N−1 then A[Q+1] < A[Q] (for a hill) or A[Q+1] > A[Q] (for a valley)
 *
 */
public class HillAndVally {
    public static void main(String[] args) {
        int[] A = new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        int result = solution(A);
        System.out.println("result = " + result);

        int[] A2 = new int[]{-3, -3};
        int result2 = solution(A2);
        System.out.println("result2 = " + result2);
    }

    private static int solution(int[] A) {
        int castleCount = 0;
        int segmentStartIdx = 0;
        int segmentNum = A[segmentStartIdx];

        boolean isLastSegmentProcess = false;

        for (int i = 0; i < A.length; i++) {
            if(i > 0 && A[i] != A[i-1]) {
                if(i == A.length-1) {
                    castleCount++;
                    isLastSegmentProcess = true;
                    continue;
                }
                if(segmentStartIdx == 0) {
                    castleCount++;
                } else {
                    boolean isValley = A[segmentStartIdx - 1] > segmentNum && A[i] > segmentNum;
                    boolean isHill = A[segmentStartIdx - 1] < segmentNum && A[i] < segmentNum;

                    if(isValley || isHill) {
                        castleCount++;
                    }
                }
                segmentStartIdx = i;
                segmentNum = A[i];
            }
        }

        if(!isLastSegmentProcess) {
            castleCount++;
        }

        return castleCount;
    }
}
