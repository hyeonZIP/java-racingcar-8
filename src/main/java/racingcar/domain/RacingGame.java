package racingcar.domain;

import racingcar.vo.ParsedInput;

public class RacingGame {
    private final Cars cars;
    private final Round totalRound;

    private RacingGame(Cars cars, Round totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public static RacingGame initializeRacingGame(ParsedInput input) {
        Cars cars = Cars.register(input.carNames());
        Round totalRound = Round.of(input.totalRound());

        return new RacingGame(cars, totalRound);
    }
}
