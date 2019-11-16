import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * int -2147483647 ~ 2147483647
 *                   27048749056
 *                   6227020800
 *
 */
public class BigNumber {

    public static void main(String[] args) {
        sum();
        multiplyByInt();
        multiplyByBigInteger();
        multiplication(Arrays.asList(6, 7, 8, 9), Arrays.asList(3, 4, 5));
    }

    /**
     * 더해보기 1~ 100
     */
    private static void sum() {
        int result = 0;

        for(int i = 1; i <= 100; i++) {
            result += i;
        }


        System.out.println("sum result = " + result);
    }


    /**
     * int로 곱해보기 1 ~ 100
     */
    private static void multiplyByInt() {
        int result = 1;

        for(int i = 1; i <= 100; i++) {
            result *= i;
        }

        // 곱해지면서 int 데이터 타입의 범위가 넘어가기 때문에 0으로 출력된다!
        System.out.println("multiplyByInt result = " + result);
    }

    /**
     * BigInteger로 곱해보기
     */
    private static void multiplyByBigInteger() {
        BigInteger result = BigInteger.ONE;

        for(int i = 1; i <= 100; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println("multiplyByBigInteger rsult = " + result);

    }

    private static List<Integer> multiplication(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        int temp = 0;

        for(int i = b.size()-1; i >= 0; i--) {
            for(int j = a.size()-1; j >= 0; j++) {
                int m = b.get(i) * a.get(j); // 각 원소의 값을 곱한다.
                int remainder = m % 10; // 나머지
                int quotient = m / 10; // 몫

                int v = quotient + temp; // temp 값과 몫값을 더하여 실제 곱한 값을 추려낸다.
                if(v >= 10) {
                    // 추려낸 값이 또 10이 넘을 수도 있으니 넘어간 값을 temp에 저장하고
                    v = 10;
                    temp = v - 10;
                }


                result.add(quotient + temp);

            }
        }

        return new ArrayList<>();
    }

}
