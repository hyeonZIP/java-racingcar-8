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

    public static Cars register(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::register)
                .toList();

        validateCars(cars);

        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        cars.forEach(this::tryMove);
    }

    public List<Car> getGameWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.CARS_NOT_EMPTY.getMessage()));
    }

    private void tryMove(Car car) {
        if (moveStrategy.canMove()) {
            car.increasePosition();
        }
    }

    private static void validateCars(List<Car> cars) {
        validateEmpty(cars);
        validateDuplicate(cars);
    }

    private static void validateDuplicate(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_DUPLICATE.getMessage());
        }
    }

    private static void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_NOT_EMPTY.getMessage());
        }
    }
}
