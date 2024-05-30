package baseball;

import baseball.player.Computer;
import baseball.player.User;
import baseball.utils.Output;

import static baseball.utils.Constant.*;

public class BaseballGame {

    private final Computer computer;
    private final User user;
    private final Output output;
    private int strike;
    private int ball;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.output = new Output();
        this.strike = 0;
        this.ball = 0;
    }

    /**
     * 숫자야구 게임을 시작하는 메서드
     * 각 회차가 종료되면 게임을 재시작할지 여부를 확인한다.
     */
    public void run() {
        do {
            computer.createNumber();
            System.out.println("answer = " + computer.getNumbers());
            gameStart();
        } while (gameRestart());
    }

    /**
     * 게임의 한 회차를 진행하는 메서드
     * 사용자로부터 숫자를 입력받아 스트라이크와 볼을 계산하고 출력한다.
     * 세 개의 스트라이크가 나오면 회차를 종료한다.
     */
    private void gameStart() {
        do {
            user.inputThreeNumber();
            calculateStrikesAndBalls();
            output.printStrikeAndBall(this.strike, this.ball);
        } while (!isStrikeThree());
    }

    /**
     * 게임을 재시작할지 종료할지 여부를 결정하는 메서드
     * @return 1을 입력하면 true, 2를 입력하면 false를 반환
     */
    private boolean gameRestart() {
        user.inputOneNumber();

        if (user.getOneOrTwo() == 1) {
            return true;
        }
        if (user.getOneOrTwo() == 2) {
            return false;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_ONE_OR_TWO);
    }

    /**
     * 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하여 스트라이크와 볼의 개수를 계산하는 메서드
     */
    private void calculateStrikesAndBalls() {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < LENGTH_OF_NUMBERS; i++) {
            if (isStrike(i)) {
                this.strike++;
            } else {
                if (isBall(i)) {
                    this.ball++;
                }
            }
        }
    }

    /**
     * 입력받은 인덱스 위치의 숫자가 스트라이크인지 확인하는 메서드
     * @param i 확인할 인덱스 위치
     * @return 스트라이크면 true, 아니면 false
     */
    private boolean isStrike(int i) {
        return user.getNumberIndex(i) == computer.getNumberIndex(i);
    }

    /**
     * 입력받은 인덱스 위치의 숫자가 볼인지 확인하는 메서드
     * @param i 확인할 인덱스 위치
     * @return 볼이면 true, 아니면 false
     */
    private boolean isBall(int i) {
        return computer.getNumbers().contains(user.getNumberIndex(i));
    }

    /**
     * 세 개의 스트라이크가 나왔는지 확인하는 메서드
     * @return 세 개의 스트라이크면 true, 아니면 false
     */
    public boolean isStrikeThree() {
        return this.strike == 3;
    }
}
