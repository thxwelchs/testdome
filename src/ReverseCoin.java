/**
 * 동전 뒤집기
 */
public class ReverseCoin {

    public static void main(String[] args) {
        int result = solution(new int[]{1, 0, 0, 0, 0, 1, 0, 0});
        System.out.println("result = " + result);

    }

    private static int solution(int[] A) {
        int heads = 0, tails = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == 1) {
                tails++;
                continue;
            }

            heads++;
        }

        return heads > tails ? tails : heads;
    }

}
