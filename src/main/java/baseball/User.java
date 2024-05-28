package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User implements Player{

    private final List<Integer> numbers = new ArrayList<>();
    private int oneOrTwo;

    public User() {
    }

    public int getNumberIndex(int index) {
        return numbers.get(index);
    }

    public void inputThreeNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        numbers.clear();
        String[] input = readLine().split("");
        validateThreeInput(input);
        inputToNumbers(input);
    }

    public void inputOneNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String[] input = readLine().split("");
        validateOneInput(input);
        inputToOneOrTwo(input);
    }

    private void inputToOneOrTwo(String[] input) {
        this.oneOrTwo = Integer.parseInt(input[0]);
    }

    private void validateOneInput(String[] input) {
        validateNoSpaces(input);
        validateOneOrTwo(input);
        validateAllAreNumbers(input);
        validateLengthIsOne(input);
    }

    private void validateOneOrTwo(String[] input) {
        if (!input[0].equals("1") && !input[0].equals("2")) {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다");
        }
    }

    private void validateThreeInput(String[] input) {
        validateNoSpaces(input);
        validateAllAreNumbers(input);
        validateNoDecimals(input);
        validateLengthIsThree(input);
        validateZero(input);
        validateNoDuplicate(input);
    }

    private void validateNoSpaces(String[] input) {
        if (Arrays.asList(input).contains(" ")) {
            throw new IllegalArgumentException("숫자는 붙여서 입력해야 합니다");
        }
    }


    private void validateNoDecimals(String[] input) {
        for (String s: input) {
            if (s.contains(".")) {
                throw new IllegalArgumentException("소수는 허용되지 않습니다");
            }
        }
    }

    private void validateNoDuplicate(String[] input) {
        Set<String> set = new HashSet<>(Arrays.asList(input));
        if (set.size() != input.length) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다");
        }
    }

    private void inputToNumbers(String[] input) {
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
    }

    private void validateAllAreNumbers(String[] input) {
        if (!Arrays.stream(input).allMatch(User::isInputToInteger)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
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
            throw new IllegalArgumentException("0은 허용하지 않습니다");
        }
    }

    private void validateLengthIsThree(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력하세요");
        }
    }

    private void validateLengthIsOne(String[] input) {
        if (input.length != 1) {
            throw new IllegalArgumentException("1개의 숫자를 입력하세요");
        }
    }

    public int getOneOrTwo() {
        return oneOrTwo;
    }
}
