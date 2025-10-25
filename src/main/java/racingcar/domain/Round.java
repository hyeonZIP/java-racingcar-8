package racingcar.domain;

import racingcar.exception.ExceptionMessage;

public class Round {
    private static final int MAXIMUM_ROUND = 100;
    private static final int MINIMUM_ROUND = 1;

    private final int totalRound;

    private Round(int totalRound) {
        this.totalRound = totalRound;
    }

    public static Round of(int totalRound) {
        validateMaximumRound(totalRound);
        validateMinimumRound(totalRound);

        return new Round(totalRound);
    }

    private static void validateMaximumRound(int totalRound) {
        if (totalRound > MAXIMUM_ROUND) {
            throw new IllegalArgumentException(ExceptionMessage.TOTAL_ROUND_OVER_MAXIMUM.getMessage());
        }
    }

    private static void validateMinimumRound(int totalRound){
        if(totalRound < MINIMUM_ROUND){
            throw new IllegalArgumentException(ExceptionMessage.TOTAL_ROUND_UNDER_MINIMUM.getMessage());
        }
    }
}
