package baseball;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        String hint = "";
        if (strike > 0) hint += strike + " 스트라이크 "; //스트라이크가 1 이상이면 힌트
        if (ball > 0) hint += ball + " 볼 "; // 볼이 1 이상이면 힌트 추가
        if (hint.isEmpty()) hint = "아웃"; //스트라이크와 볼이 0이면 아웃
        System.out.println(hint.trim());
    }
}
