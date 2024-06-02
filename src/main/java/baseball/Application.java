package baseball;

import baseball.player.Computer;
import baseball.player.User;
import baseball.utils.Input;
import baseball.utils.Output;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        Output output = new Output();
        Validate validate = new Validate();

        Input input = new Input(validate, output);
        User user = new User(input);

        Computer computer = new Computer();

        BaseballGame baseballGame = new BaseballGame(computer, user, output);
        baseballGame.run();
    }
}
