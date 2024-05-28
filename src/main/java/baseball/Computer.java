package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Player{

    private List<Integer> numbers = new ArrayList<>();

    public Computer() {
        List<Integer> number = createNumber();
        if (number.size() != 3) {
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다");
        }
        this.numbers = number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getNumberIndex(int index) {
        return numbers.get(index);
    }

    private List<Integer> createNumber() {
        for(int i = 0; i < 3; i++) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (numbers.contains(pickNumber)) {
                i--;
            }else {
                numbers.add(pickNumber);
            }
        }
        return numbers;
    }
}
