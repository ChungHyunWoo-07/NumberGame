package baseball;
import java.util.*;

public class BaseballGame {
    BaseballGameDisplay display;
    Scanner sc = new Scanner(System.in);
    HashSet<Integer> test = new HashSet<>();
    private Random rand = new Random();
    private String inputnum;
    String answer = "";
    int count = 0;
    int strike;
    int ball;


    public BaseballGame(int dt) {
        display = new BaseballGameDisplay();
        // 정답 숫자 만들기
        StringBuilder sb = new StringBuilder();
        while (sb.length() < dt) {
            int digit = rand.nextInt(9) + 1;
            if (test.add(digit)) {
                sb.append(digit);
            }
        }
        answer = sb.toString();
    }

    public int play(int dt) {     // setter
        while (true) {
            // 입력값 받음
            System.out.print("숫자를 입력하세요: ");
            inputnum = sc.nextLine();

            // 입력값이 올바른지 확인
            if (!validateInput(inputnum, dt)) {
                System.out.println("정확한 숫자를 입력하세요: ");
                continue;
            }
            // 게임 진행횟수 카운트
            count++;
            // 스트라이크 개수 카운트
            strike = countStrike(inputnum);
            // 만약 3스트라이크로 정답이라면 break로  반복문 종료
            if (strike == dt) {
                break;
            }
            // 6. 볼 개수 계산
            ball = countBall(inputnum);
            // 7. 힌트 출력
            display.displayHint(strike, ball);

            System.out.println(answer);

        }
        // 게임 진행횟수 반환
        return count;
    }
    // 길이가 3자리 이면서 1~9 사이의 값
    protected boolean validateInput(String input, int dt) {
        String regex = "[1-9]{" + dt + "}";
        if (input.length() != dt || !input.matches(regex)) {
            return false;
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    private int countStrike(String input) {  //스트라이크 결과 반환
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) { // 자리도 같고 숫자도 같은 조건
                result++;
            }
        }
        return result;
    }

    private int countBall(String input) {  // 볼 결과 반환
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            // 자리는 다르지만 숫자는 같은 조건
            if (input.charAt(i) != answer.charAt(i) && answer.contains(String.valueOf(input.charAt(i)))) {
                result++;
            }
        }
        return result;
    }
}