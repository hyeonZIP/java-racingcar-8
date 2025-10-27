package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MINIMUM_RANDOM_RANGE = 0;
    private static final int MAXIMUM_RANDOM_RANGE = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int randomNumber = generateRandomNumber();

        return randomNumber >= MOVE_THRESHOLD;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_RANGE, MAXIMUM_RANDOM_RANGE);
    }
}
