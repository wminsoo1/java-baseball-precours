package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        while (true) {

            BaseballGame baseballGame = new BaseballGame();
            User user = baseballGame.getUser();

            System.out.println("answer = " + baseballGame.getComputer().getNumbers());

            do {

                user.inputThreeNumber();

                baseballGame.calculateStrikesAndBalls();

                baseballGame.printStrikeAndBall();

            } while (!baseballGame.isStrikeThree());


            user.inputOneNumber();

            if (!baseballGame.gameRestart()) {
                break;
            }
        }
    }

}
