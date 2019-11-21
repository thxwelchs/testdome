import java.util.Arrays;

public class SmallLest {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 3, 6, 4, 1, 2},
                {1, 2, 3},
                {-1, -3}
        };

        for (int[] testCase: testCases) {
            int answer = solution(testCase);

            System.out.println("TEST");
            System.out.println("testCase = " + Arrays.toString(testCase));
            System.out.println("answer = " + answer);
            System.out.println("---------------------");
        }
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int result = 1;

        for (int i = 0; i < A.length; i++){
            if(A[i] == result){
                result++;
            }
        }

        return result;
    }
}
