package baseball;

import baseball.player.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.utils.Constant.*;

public class Validate {

    /**
     * 사용자에게 입력받은 서로 다른 숫자 3개를 검증
     * @param input 입력 받은 숫자 배열
     */
    public void validateThreeInput(String[] input) {
        validateNoSpaces(input);
        validateAllAreNumbers(input);
        validateNoDecimals(input);
        validateLengthIsThree(input);
        validateZero(input);
        validateNoDuplicate(input);
    }

    /**
     * 사용자에게 입력받은 숫자를 검증
     * @param input 입력 받은 숫자 배열
     */
    public void validateOneInput(String[] input) {
        validateNoSpaces(input);
        validateOneOrTwo(input);
        validateAllAreNumbers(input);
        validateLengthIsOne(input);
    }


    /**
     * 사용자의 입력으로 받은 숫자가 1 또는 2인지 검증
     * 숫자가 1 또는 2가 아닐 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateOneOrTwo(String[] input) {
        if (!input[0].equals("1") && !input[0].equals("2")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONE_OR_TWO);
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자가 공백이 있는지 검증
     * 공백이 있는 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateNoSpaces(String[] input) {
        if (Arrays.asList(input).contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_SPACES);
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자가 소수인지 검증
     * 소수일 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateNoDecimals(String[] input) {
        for (String s: input) {
            if (s.contains(".")) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NO_DECIMALS);
            }
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자가 중복인지 검증
     * 숫자가 중복일 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateNoDuplicate(String[] input) {
        Set<String> set = new HashSet<>(Arrays.asList(input));
        if (set.size() != input.length) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_DUPLICATES);
        }
    }


    /**
     * 사용자의 입력이 int로 변환 되는지 검증
     * int로 변환이 안될 때 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateAllAreNumbers(String[] input) {
        if (!Arrays.stream(input).allMatch(Validate::isInputToInteger)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBERS);
        }
    }

    /**
     * 사용자의 입력이 int로 변환 되는지 검증
     * @param input 입력 받은 숫자 배열
     * @return int로 변환 가능하면 true, 그렇지 않으면 false
     */
    private static boolean isInputToInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자에 0이 포함되어 있는지 검증
     * 0이 포함될 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateZero(String[] input) {
        if (Arrays.asList(input).contains("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NO_ZERO);
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자의 길이가 3인지 검증
     * 길이가 3이 아닌 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateLengthIsThree(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_OF_NUMBERS);
        }
    }

    /**
     * 사용자의 입력으로 받은 숫자의 길이가 1인지 검증
     * 길이가 1이 아닌 경우 IllegalArgumentException 발생
     * @param input 입력 받은 숫자 배열
     */
    private void validateLengthIsOne(String[] input) {
        if (input.length != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_IS_ONE);
        }
    }
}
