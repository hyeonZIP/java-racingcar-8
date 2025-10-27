package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class CarsTest {
    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @Test
        @DisplayName("자동차 이름이 담긴 배열이 오면 객체 리스트로 저장한다")
        void registerCarNames() {
            List<String> carNames = List.of("pobi", "woni", "jun");

            assertDoesNotThrow(() -> Cars.register(carNames));
        }

        @Test
        @DisplayName("모든 자동차가 같은 위치면 모두 반환한다")
        void getGameWinners() {
            List<String> carNames = List.of("pobi", "woni", "jun");
            Cars cars = Cars.register(carNames);

            assertThat(cars.getGameWinners()).containsExactly(cars.getCars().toArray(new Car[0]));
        }

        @Test
        @DisplayName("우승자는 다른 자동차들 보다 같거나 멀리 간 자동차다")
        void checkWinnersPosition() {
            List<String> carNames = List.of("pobi", "woni", "jun");
            Cars cars = Cars.register(carNames);

            for (int i = 0; i < 60; i++) {
                cars.move();
            }

            List<Car> allCars = cars.getCars();
            List<Car> winners = cars.getGameWinners();

            int maxPosition = winners.getFirst().getPosition();

            assertThat(winners).allMatch(car -> car.getPosition() == maxPosition);
            assertThat(allCars).allMatch(car -> car.getPosition() <= maxPosition);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class Fail {

        @Test
        @DisplayName("자동차 객체가 비어있으면 예외가 발생한다")
        void isEmpty() {
            List<String> carNames = List.of();

            assertThatThrownBy(() -> Cars.register(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.CARS_NOT_EMPTY.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 중복되면 예외가 발생한다")
        void isDuplicate() {
            List<String> carNames = List.of("pobi", "pobi", "pobi");

            assertThatThrownBy(() -> Cars.register(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.CARS_DUPLICATE.getMessage());
        }
    }
}
