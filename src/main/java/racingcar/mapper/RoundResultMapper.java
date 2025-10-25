package racingcar.mapper;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.RoundResult;
import racingcar.dto.RoundResultDetails;

public class RoundResultMapper {
    public static RoundResult toDto(Cars cars) {
        List<RoundResultDetails> roundResultDetails = cars.getCars().stream()
                .map(car -> new RoundResultDetails(car.getName(), car.getPosition()))
                .toList();

        return new RoundResult(roundResultDetails);
    }
}
