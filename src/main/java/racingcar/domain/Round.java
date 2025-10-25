package racingcar.domain;

import java.util.Objects;
import racingcar.exception.ExceptionMessage;

public class Round {
    private static final int MAXIMUM_ROUND = 100;
    private static final int MINIMUM_ROUND = 1;
    private static final int INITIAL_ROUND = 0;

    private final int totalRound;

    private Round(int totalRound) {
        this.totalRound = totalRound;
    }

    public static Round of(int totalRound) {
        validateMaximumRound(totalRound);
        validateMinimumRound(totalRound);

        return new Round(totalRound);
    }

    public static Round initialRound() {
        return new Round(INITIAL_ROUND);
    }

    private static void validateMaximumRound(int totalRound) {
        if (totalRound > MAXIMUM_ROUND) {
            throw new IllegalArgumentException(ExceptionMessage.TOTAL_ROUND_OVER_MAXIMUM.getMessage());
        }
    }

    private static void validateMinimumRound(int totalRound) {
        if (totalRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException(ExceptionMessage.TOTAL_ROUND_UNDER_MINIMUM.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Round that)) {
            return false;
        }

        return Objects.equals(totalRound, that.totalRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRound);
    }
}
