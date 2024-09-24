package baseball;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt, chk, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        j = 3;


        while(true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("0. 자리수 설정 1. 게임하기 2. 기록하기 3. 종료하기");
            try {
                chk = sc.nextInt();
            } catch (InputMismatchException e) {  //원래 나오던 오류대신 내가 정한 문구 또는 역할을 출력
                System.out.println("올바른 숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }
            switch (chk){
                case 0:
                    System.out.println("설정하고자 하는 자리수를 입력하세요(3, 4, 5 중에 선택).");
                    switch (sc.nextInt()){ // 설정하고자 하는 자리수 입력
                        case 3:
                            j = 3;
                            break;
                        case 4:
                            j = 4;
                            break;
                        case 5:
                            j = 5;
                            break;
                        default:
                            System.out.println("다시 입력하세요.");
                            continue;
                    }
                    chk = 1;

                case 1:
                    BaseballGame game = new BaseballGame(j);
                    System.out.println("게임을 시작합니다.");
                    cnt = game.play(j);
                    System.out.println("정답입니다. 도전횟수는: " + cnt);
                    arr.add(cnt);
                    break;

                case 2:
                    System.out.println("게임 기록 보기");
                    // 출력하려고 하는 만큰만 for 언제끝날지 모르는 출력을 원할 때 while
                    for (int i = 0; i < arr.size(); i++) {
                        System.out.println(i+1 + "번째 게임 : 시도 횟수 - " + arr.get(i)); //기능을 확인하고 사용
                    }
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