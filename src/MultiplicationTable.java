/**
 * 구구단 for, while 과 같은 반복문 없이 재귀로만 구현해보기
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        // 2단부터 시작
        gugudan(2, 1);
    }

    private static void gugudan(int i, int j) {

        // 구구단은 곱해질 인수가 9까지만 있으므로 단수에 해당하는 i가 9에 도달하기 까지만 재귀 호출 하도록  기저 조건을 설정
        if(i <= 9) {
            System.out.println(i + " X " + j + " = " + i * j);
            if(j < 9) gugudan(i, j + 1);
            else gugudan(i + 1, 1);
        }
    }
}
