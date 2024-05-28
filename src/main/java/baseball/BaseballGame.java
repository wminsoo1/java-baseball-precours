package baseball;

import baseball.player.Computer;
import baseball.player.User;

import static baseball.utils.Constant.*;

public class BaseballGame {

    private final Computer computer;
    private final User user;
    private int strike;
    private int ball;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.strike = 0;
        this.ball = 0;
    }

    public void run() {
        do {
            computer.createNumber();
            System.out.println("answer = " + computer.getNumbers());
            gameStart();
        } while (gameRestart());
    }

    private void gameStart() {
        do {
            user.inputThreeNumber();
            calculateStrikesAndBalls();
            printStrikeAndBall();
        } while (!isStrikeThree());
    }

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

    private void printStrikeAndBall() {
        if (this.strike == 3) {
            System.out.println("3" + STRIKE);
            System.out.println(SUCCESS_MESSAGE);
        } else if (this.strike == 0 && this.ball== 0) {
            System.out.println(NOTHING);
        } else if (this.strike == 0) {
            System.out.println(this.ball + BALL);
        }else if (this.ball == 0) {
            System.out.println(this.strike + STRIKE);
        } else {
            System.out.println(this.ball + BALL + " " + this.strike + STRIKE);
        }
    }

    private boolean isStrike(int i) {
        return user.getNumberIndex(i) == computer.getNumberIndex(i);
    }

    private boolean isBall(int i) {
        return computer.getNumbers().contains(user.getNumberIndex(i));
    }

    public boolean isStrikeThree() {
        return this.strike == 3;
    }
}
