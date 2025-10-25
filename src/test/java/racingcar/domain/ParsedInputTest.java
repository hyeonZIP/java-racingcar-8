package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class ParsedInputTest {
    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @Test
        @DisplayName("자동차 이름과 시도 횟수가 유효하면 예외가 발생하지 않는다")
        void parse() {
            assertDoesNotThrow(ParsedInputFixture::createValidInput);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class Fail {

        @Test
        @DisplayName("자동차 이름이 공백이면 예외가 발생한다")
        void emptyCarNames() {
            assertThatThrownBy(ParsedInputFixture::createEmptyCarNamesInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_NOT_BLANK.getMessage());
        }

        @Test
        @DisplayName("시도 횟수가 공백이면 예외가 발생한다")
        void emptyTotalRound() {
            assertThatThrownBy(ParsedInputFixture::createEmptyTotalRoundInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_NOT_BLANK.getMessage());
        }

        @Test
        @DisplayName("시도 횟수가 정수가 아니면 예외가 발생한다")
        void notIntegerTotalRound() {
            assertThatThrownBy(ParsedInputFixture::createNotIntegerTotalRoundInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_NOT_INTEGER.getMessage());
        }

        @Test
        @DisplayName("시도 횟수가 Integer 표현 범위를 벗어난 값이면 예외가 발생한다")
        void outOfIntegerTotalRound() {
            assertThatThrownBy(ParsedInputFixture::createOutOfIntegerTotalRoundInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_NOT_INTEGER.getMessage());
        }
    }
}
