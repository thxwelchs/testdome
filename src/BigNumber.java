import com.sun.deploy.util.StringUtils;

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
        sum();
        multiplyByInt();
        multiplyByBigInteger();
        multiplyByNotBigInteger();
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

        System.out.println("multiplyByBigInteger result = " + result);
    }
    
    private static void multiplyByNotBigInteger() {
        List<Integer> result = Arrays.asList(1);
        
        for(int i = 1; i <= 100; i++) {
            result = longMultiplication(result, Arrays.asList(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            String s = Integer.toString(result.get(i));
            sb.append(s);
        }

        // 이렇게 BigInteger 없이 Long Multiplication 기법과 List 컬렉션을 통해 큰 수 곱하기를 오버플로우 없이 구현하였다.
        System.out.println("multiplyByNotBigInteger result = " + sb);
//        System.out.println("multiplyByNotBigInteger result" + result);
    }

    /**
     * 사람이 보통 곱셈을 할 때 사용하는 LongMultiplication을 활용한 방법
     * 오버플로우 되지 않게 각 곱해지는 한자리의 인수들을 List에 넣어 연산한다.
     *
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> longMultiplication(List<Integer> a, List<Integer> b) {
        
        if((a.size() == 1 && a.get(0) == 0) || (b.size() == 1 && b.get(0) == 0)) {
            return new ArrayList<Integer>() {{ add(0); }};
        }
        
        List<Stack<Integer>> list = new ArrayList<>();

        for(int i = b.size()-1; i >= 0; i--) {
            int temp = 0;
            Stack<Integer> stack = new Stack<>();

            // Long Nultiplication 할 때 곱할 십의 자리수 부터 차례대로 zerofill 해주기
            for(int j = 0; j < ((b.size() - 1) - i); j++) {
                stack.push(0);
            }

            for(int j = a.size()-1; j >= 0; j--) {
                int m = b.get(i) * a.get(j); // 각 원소의 값을 곱한다.
                int remainder = m % 10; // 나머지
                int quotient = m / 10; // 몫

                int v = remainder + temp;

                temp = quotient;

                // 실제 스택에 넣어야 할 값이 10이 넘을 때 10을 뺀 나머지 값만 취하고, 다음 나머지 값과 더할 temp값 증가
                if(v >= 10) {
                    v -= 10;
                    temp++;
                }

                // 곱할 인수의 가장 마지막 자릿수에 해당하고 temp에 값이 있다면 10이 넘어가는 수를 처리하여 스택에 저장
                if(j == 0 && temp > 0) {
                    stack.push(v);
                    stack.push(temp);
                } else {
                    stack.push(v);
                }
            }

            list.add(stack);
        }

        /*
        * 여기서 부터는 각 자릿수별로 첫번째 인수와 곱해진 수들을 스택에서 꺼내서 더하는 부분
        * 귀찮아서 더 이상 주석은.. 생략
        * */
        int len = list.size() - 1;
        List<Integer> result = new ArrayList<>();

        for(int i = len; i >= 0; i--) {
            Stack<Integer> s = list.get(i);

            if(i < len) {
                for(int j = 0; j < ((list.size() - 1) - i); j++) {
                    s.push(0);
                }
            }

            int idx = 0;
            while (!s.empty()) {
                int v = s.pop();
                int o = 0;

                if(i == len) {
                    result.add(idx, v + o);
                } else {
                    o = result.get(idx);
                    result.set(idx, v + o);
                }
                idx++;
            }
        }

        int t = 0;
        for(int i = result.size() - 1; i >= 0; i--) {
            int v = result.get(i) + t;

            if(v >= 10) {
                t = v / 10;
                v = v % 10;
            } else {
                t = 0;
            }

            result.set(i, v);
        }

        if(t > 0) {
            result.add(0, t);
        }

        return result;
    }

}
