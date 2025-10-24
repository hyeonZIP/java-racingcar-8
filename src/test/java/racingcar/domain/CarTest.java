package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class CarTest {
    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @Test
        @DisplayName("자동차 이름이 유효하면 초기 위치 값으로 등록된다")
        void registerCar() {
            Car car = Car.register("pobi");

            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class Fail {

        @Test
        @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
        void invalidCarName() {
            assertThatThrownBy(() -> Car.register("i'm pobi"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.CAR_NAME_OUT_OF_LENGTH.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 공백이면 예외가 발생한다")
        void carNameBlank() {
            assertThatThrownBy(() -> Car.register(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.CAR_NAME_NOT_BLANK.getMessage());
        }
    }
}
