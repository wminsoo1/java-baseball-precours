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

    public int getNumberIndex(int index) {
        return numbers.get(index);
    }

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
