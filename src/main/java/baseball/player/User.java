package baseball.player;

import java.util.*;

import static baseball.utils.Constant.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private final List<Integer> numbers = new ArrayList<>();
    private int oneOrTwo;

    public User() {
    }

    public int getNumberIndex(int index) {
        return numbers.get(index);
    }

    public void inputThreeNumber() {
        numbers.clear();
        System.out.print(INPUT_NUMBERS);
        String[] input = readLine().split("");
        validateThreeInput(input);
        inputToNumbers(input);
    }

    public void inputOneNumber() {
        System.out.println(INPUT_ONE_OR_TWO);
        String[] input = readLine().split("");
        validateOneInput(input);
        inputToOneOrTwo(input);
    }

    private void inputToNumbers(String[] input) {
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
    }

    private void inputToOneOrTwo(String[] input) {
        this.oneOrTwo = Integer.parseInt(input[0]);
    }

    private void validateThreeInput(String[] input) {
        validateNoSpaces(input);
        validateAllAreNumbers(input);
        validateNoDecimals(input);
        validateLengthIsThree(input);
        validateZero(input);
        validateNoDuplicate(input);
    }

    private void validateOneInput(String[] input) {
        validateNoSpaces(input);
        validateOneOrTwo(input);
        validateAllAreNumbers(input);
        validateLengthIsOne(input);
    }

    private void validateOneOrTwo(String[] input) {
        if (!input[0].equals("1") && !input[0].equals("2")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONE_OR_TWO);
        }
    }

    private void validateNoSpaces(String[] input) {
        if (Arrays.asList(input).contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_SPACES);
        }
    }


    private void validateNoDecimals(String[] input) {
        for (String s: input) {
            if (s.contains(".")) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NO_DECIMALS);
            }
        }
    }

    private void validateNoDuplicate(String[] input) {
        Set<String> set = new HashSet<>(Arrays.asList(input));
        if (set.size() != input.length) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_DUPLICATES);
        }
    }



    private void validateAllAreNumbers(String[] input) {
        if (!Arrays.stream(input).allMatch(User::isInputToInteger)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBERS);
        }
    }

    private static boolean isInputToInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void validateZero(String[] input) {
        if (Arrays.asList(input).contains("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_ZERO);
        }
    }

    private void validateLengthIsThree(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_OF_NUMBERS);
        }
    }

    private void validateLengthIsOne(String[] input) {
        if (input.length != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_IS_ONE);
        }
    }

    public int getOneOrTwo() {
        return oneOrTwo;
    }
}
