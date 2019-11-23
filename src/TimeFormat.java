public class TimeFormat {
    public static void main(String[] args) {
        String result = format(86400);
        System.out.println("result = " + result);


    }

    public static String format(int T) {
        // 로직 초기에 나눌 단위값 (시간 하루 초(86400) 기준 86400 / 24 = 3600)
        int timeUnit = 3600;
        String formatUnit = "h";

        // 문자열 연산에 유리한 StrintBuilder 사용
        StringBuilder formatted = new StringBuilder();
        do {
            int time = T / timeUnit;
            formatted.append(time);
            formatted.append(formatUnit);

            T -= time * timeUnit;
            timeUnit /= 60;

            formatUnit = timeUnit == 60 ? "m" : "s";
        }while (T > 0 || timeUnit >= 1); // timeUnit >= 1 조건이 없을 시 값의 단위가 0인 경우 0{m|s} 를 만들어주는 로직에 대한 부분 스킵되어짐
        // 예로 86400인 경우 24h0m0s로 되어져야 하는데 24h까지만 진행하고 루프 종료

        return formatted.toString();
    }
}
