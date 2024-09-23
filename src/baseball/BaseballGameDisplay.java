package baseball;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        String hint = "";
        if (strike > 0) hint += strike + " 스트라이크 ";
        if (ball > 0) hint += ball + " 볼 ";
        if (hint.isEmpty()) hint = "아웃";
        System.out.println(hint.trim());
    }
}
