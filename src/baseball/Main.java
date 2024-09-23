package baseball;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt, chk = 0;

        while(true) {
            BaseballGame game = new BaseballGame();
            System.out.println("1. 게임하기 2. 기록하기 3. 종료하기");
            chk = sc.nextInt();
            switch (chk){
                case 1:
                    cnt = game.play();
                    System.out.println("정답입니다. 도전횟수는: " + cnt);
                    break;

                case 2:
                    System.out.println("기록: 준비중");
                    break;

                case 3:
                    System.out.println("종료합니다.");
                    break;

                default:
                    System.out.println("다시 입력하세요.");
            }
            if (chk == 3) break;
        }
    }
}