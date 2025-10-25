package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.ExceptionMessage;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars register(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::register)
                .toList();

        validateEmpty(cars);

        return new Cars(cars);
    }

    private static void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_NOT_EMPTY.getMessage());
        }
    }
}
