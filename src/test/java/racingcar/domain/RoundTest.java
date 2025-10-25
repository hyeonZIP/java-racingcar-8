package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class RoundTest {
    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @Test
        @DisplayName("유효한 시도 횟수 값이면 예외가 발생하지 않는다")
        void validTotalRound() {
            int totalRound = 5;

            assertDoesNotThrow(() -> Round.of(totalRound));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class Fail {

        @Test
        @DisplayName("시도 횟수가 최대값(100)을 초과하면 예외가 발생한다")
        void overMaximumRound() {
            int totalRound = 101;

            assertThatThrownBy(() -> Round.of(totalRound))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.TOTAL_ROUND_OVER_MAXIMUM.getMessage());
        }

        @Test
        @DisplayName("시도 횟수가 최소값(1)보다 미만이면 예외가 발생한다")
        void underMinimumRound() {
            int totalRound = 0;

            assertThatThrownBy(() -> Round.of(totalRound))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.TOTAL_ROUND_OVER_MAXIMUM.getMessage());
        }
    }
}
