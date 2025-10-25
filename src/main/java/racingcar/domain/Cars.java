package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.exception.ExceptionMessage;

public class Cars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        this.moveStrategy = new RandomMoveStrategy();
    }

    public static Cars register(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::register)
                .toList();

        validateEmpty(cars);

        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        cars.forEach(this::tryMove);
    }

    public List<Car> getGameWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.CARS_NOT_EMPTY.getMessage()));
    }

    private static void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_NOT_EMPTY.getMessage());
        }
    }

    private void tryMove(Car car) {
        if (moveStrategy.canMove()) {
            car.increasePosition();
        }
    }
}
