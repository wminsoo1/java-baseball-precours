package baseball.utils;

public class Output {
    public final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    public final String INPUT_ONE_OR_TWO = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public final String STRIKE = "스트라이크";
    public final String BALL = "볼";
    public final String NOTHING = "낫싱";

    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBERS);
    }

    public void printInputOneOrTwoMessage() {
        System.out.println(INPUT_ONE_OR_TWO);
    }

    /**
     * 스트라이크와 볼의 개수를 출력하는 메서드
     */
    public void printStrikeAndBall(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3" + STRIKE);
            System.out.println(SUCCESS_MESSAGE);
        } else if (strike == 0 && ball== 0) {
            System.out.println(NOTHING);
        } else if (strike == 0) {
            System.out.println(ball + BALL);
        }else if (ball == 0) {
            System.out.println(strike + STRIKE);
        } else {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }
}
