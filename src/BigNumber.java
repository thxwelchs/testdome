import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * int -2147483647 ~ 2147483647
 *                   27048749056
 *                   6227020800
 *
 */
public class BigNumber {

    public static void main(String[] args) {
//        sum();
//        multiplyByInt();
//        multiplyByBigInteger();
        multiplication(Arrays.asList(6, 7, 8, 9), Arrays.asList(2, 3, 6));
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
        List<Stack<Integer>> list = new ArrayList<>();


        for(int i = b.size()-1; i >= 0; i--) {
            int temp = 0;
            Stack<Integer> stack = new Stack<>();

            for(int j = 0; j < ((b.size() - 1) - i); j++) {
                stack.push(0);
            }

            for(int j = a.size()-1; j >= 0; j--) {
                int m = b.get(i) * a.get(j); // 각 원소의 값을 곱한다.
                int remainder = m % 10; // 나머지
                int quotient = m / 10; // 몫

                int v = remainder + temp;

                temp = quotient;

                if(v >= 10) {
                    v -= 10;
                    temp++;
                }

                if(j == 0 && temp > 0) {
                    stack.push(v);
                    stack.push(temp);
                } else {
                    stack.push(v);
                }

//                for(int k = 0; k < (a.size() -1) - j; k++ ) {
//                    
//                }

            }

//            System.out.println("iiiiii= " + i);
//            System.out.println("b.size() -1 -j = " + ((b.size() -1) -i));

            list.add(stack);

            System.out.println("stack = " + stack);
        }

        System.out.println("list = " + list);

        return new ArrayList<>();
    }

}
