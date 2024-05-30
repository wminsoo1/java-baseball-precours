package baseball.utils;

import baseball.Validate;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private final Validate validate;
    private final Output output;

    public Input() {
        this.validate = new Validate();
        this.output = new Output();
    }

    public String[] inputThreeNumber() {
        output.printInputNumberMessage();
        String[] input = readLine().split("");
        validate.validateThreeInput(input);

        return input;
    }

    public String[] inputOneNumber() {
        output.printInputOneOrTwoMessage();
        String[] input = readLine().split("");
        validate.validateOneInput(input);

        return input;
    }

}
