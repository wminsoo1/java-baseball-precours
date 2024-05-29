package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constant.*;

public class Computer {

    private final List<Integer> numbers = new ArrayList<>();

    public Computer() {
    }

    public List<Integer> getNumbers() {
        return numbers;
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
     * 컴퓨터가 1 ~ 9까지의 임의의 서로 다른 숫자 3개를 생성해 numbers에 추가
     */
    public void createNumber() {
        numbers.clear();
        for(int i = 0; i < LENGTH_OF_NUMBERS; i++) {
            int pickNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (numbers.contains(pickNumber)) {
                i--;
            }else {
                numbers.add(pickNumber);
            }
        }
    }
}
