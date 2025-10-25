package racingcar.domain;

import racingcar.vo.ParsedInput;

public class RacingGame {
    private final Cars cars;
    private final Round totalRound;
    private Round currentRound;

    private RacingGame(Cars cars, Round totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
        this.currentRound = Round.initialRound();
    }

    public static RacingGame initializeRacingGame(ParsedInput input) {
        Cars cars = Cars.register(input.carNames());
        Round totalRound = Round.of(input.totalRound());

        return new RacingGame(cars, totalRound);
    }

    public boolean hasMoreRound() {
        return currentRound.hasNextRound(totalRound);
    }

    public void playRound() {
        cars.move();
        currentRound = currentRound.nextRound();
    }

    public Cars getCars() {
        return cars;
    }
}
