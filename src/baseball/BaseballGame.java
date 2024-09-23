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


    public BaseballGame() {
        display = new BaseballGameDisplay();
        // 정답 숫자 분리해서 담기
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int digit = rand.nextInt(9) + 1;
            if (test.add(digit)) {
                sb.append(digit);
            }
        }
        answer = sb.toString();
    }

    public int play() {     // setter
        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.print("숫자를 입력하세요: ");     /// 입력 및 출력 개선
            inputnum = sc.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if (!validateInput(inputnum)) {
                System.out.println("정확한 숫자를 입력하세요: ");
                continue;
            }
            // 3. 게임 진행횟수 증가
            count++;
            // 4. 스트라이크 개수 계산
            strike = countStrike(inputnum);
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strike == 3) {
                break;
            }
            // 6. 볼 개수 계산
            ball = countBall(inputnum);
            // 7. 힌트 출력
            display.displayHint(strike, ball);

        }
        // 게임 진행횟수 반환
        return count;
    }

    protected boolean validateInput(String input) {
        if (input.length() != 3 || !input.matches("[1-9]{3}")) {
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

    private int countStrike(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    private int countBall(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != answer.charAt(i) && answer.contains(String.valueOf(input.charAt(i)))) {
                result++;
            }
        }
        return result;
    }
}