package baseball.player;

import baseball.utils.Input;

import java.util.*;

public class User {

    private final Input input;
    private final List<Integer> numbers = new ArrayList<>();
    private int oneOrTwo;

    public User() {
        this.input = new Input();
    }

    /**
     * index 위치의 숫자를 반환해주는 함수
     * @param index 반환할 숫자의 위치
     * @return index 위치의 숫자
     */
    public int getNumberIndex(int index) {
        return numbers.get(index);
    }

    /**
     * 사용자에게 3개의 서로 다른 수를 입력받아 numbers에 추가
     */
    public void inputThreeNumber() {
        numbers.clear();
        String[] threeNumber = input.inputThreeNumber();
        for (String s : threeNumber) {
            numbers.add(Integer.parseInt(s));
        }
    }

    /**
     * 사용자에게 입력받은 숫자를 int형으로 변환해 oneOrTwo에 추가
     */
    public void inputOneNumber() {
        String[] oneNumber = input.inputOneNumber();
        this.oneOrTwo = Integer.parseInt(oneNumber[0]);
    }

    public int getOneOrTwo() {
        return oneOrTwo;
    }
}
