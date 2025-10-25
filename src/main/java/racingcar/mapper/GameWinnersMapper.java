package racingcar.mapper;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.GameWinners;

public class GameWinnersMapper {
    public static GameWinners toDto(List<Car> cars) {
        List<String> gameWinners = cars.stream()
                .map(Car::getName)
                .toList();

        return new GameWinners(gameWinners);
    }
}
