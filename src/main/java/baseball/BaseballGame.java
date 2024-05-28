package baseball;

import camp.nextstep.edu.missionutils.Console;

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

    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }

    private boolean isStrike(int i) {
        return user.getNumberIndex(i) == computer.getNumberIndex(i);
    }

    private boolean isBall(int i) {
        return computer.getNumbers().contains(user.getNumberIndex(i));
    }

    public void calculateStrikesAndBalls() {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < computer.getNumbers().size(); i++) {
            if (isStrike(i)) {
                this.strike += 1;
            } else {
                if (isBall(i)) {
                    this.ball += 1;
                }
            }
        }
    }

    public boolean isStrikeThree() {
        return strike == 3;
    }

    public void printStrikeAndBall() {
        if (this.strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (this.strike == 0 && this.ball== 0) {
            System.out.println("낫싱");
        } else if (this.strike == 0) {
            System.out.println(this.ball + "볼");
        }else if (this.ball == 0) {
            System.out.println(this.strike + "스트라이크");
        } else {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }

    public boolean gameRestart() {
        return user.getOneOrTwo() == 1;
    }


}
