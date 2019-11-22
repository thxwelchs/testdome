public class Target {

    /*
주어진 배열 arr에 n개의 정수 타입 숫자들이 정렬 되어 들어가 있다. 여기서 임의의 숫자 target가 그 배열의 몇 번 째에 있는지 반환하는 함수를 구현하라.

arr = [1, 2, 9, 78, 124]
target = 9

the return value should be 2
 */

    public static void main(String[] args) {
        target(new int[]{1, 2, 9 , 78, 124}, 9);

    }


    public static int target(int[] arr, int n) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n) return i;
        }

        return -1;
    }

}
