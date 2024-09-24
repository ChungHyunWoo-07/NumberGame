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


    public BaseballGame(int dt) { //정답자리 숫자 받아옴, 난이도에 따른 자리값 입력을 위해 int dt 추가
        display = new BaseballGameDisplay();
        // 정답 숫자 만들기
        StringBuilder sb = new StringBuilder();
        while (sb.length() < dt) { //dt의 길이 만큼 자리수 생성
            int digit = rand.nextInt(9) + 1;
            if (test.add(digit)) {
                sb.append(digit); //StringBuilder 를 사용해서 int 형 digit 을 문자열로 바꾼 후 sb에 넣음
            }
        }
        answer = sb.toString();
    }

    public int play(int dt) { //난이도에 따른 자리값 입력을 위해 int dt 추가
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
            // 볼 개수 계산
            ball = countBall(inputnum);
            // 힌트 출력
            display.displayHint(strike, ball);

        }
        // 게임 진행횟수 반환
        return count;
    }
    //입력된 문자열이 특정 조건으 만족하는지 검증
    //문자열의 길이와 문자열의 형식을 확인하여 조건에 맞지 않으면 false 를 반환
    // 길이가 3자리 이면서 1~9 사이의 값
    // 난이도가 설정되면 설정된 난이도 자리수에 따른 값 검증
    protected boolean validateInput(String input, int dt) {
        String regex = "[1-9]{" + dt + "}";
        if (input.length() != dt || !input.matches(regex)) {
            return false;
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) { //문자열 input 을 char 로 변환하여 각 문자를 하나씩 순회
            if (!set.add(c)) { //add 메서드는 해당 문자가 이미 set 에 존재하지 않으면 추가하고 true 를 반환
                return false; // 해당 문자가 이미 존재하면 추가하지 않고 false를 반환
            }
        }
        return true;
    }

    //스트라이크의 개수를 반환
    //입력된 문자열과 정답 문자열(answer)을 비교하여 위치와 문자가 같은 경우를 카운트
    private int countStrike(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) { // 자리도 같고 숫자도 같은 조건 input, answer 비교
                result++;
            }
        }
        return result;
    }

    //볼의 개수를 반환
    //입력된 문자열과 정답 문자열의 문자는 같지만 위치가 다른 경우 카운트
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