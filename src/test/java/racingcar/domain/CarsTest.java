package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
            String[] carNames = new String[]{"pobi", "woni", "jun"};

            assertDoesNotThrow(() -> Cars.register(carNames));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class Fail {

        @Test
        @DisplayName("자동차 객체가 비어있으면 예외가 발생한다")
        void isEmpty() {
            String[] carNames = new String[]{};

            assertThatThrownBy(() -> Cars.register(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.CARS_NOT_EMPTY.getMessage());
        }
    }
}
