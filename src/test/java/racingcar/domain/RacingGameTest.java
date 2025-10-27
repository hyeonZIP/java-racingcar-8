package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.vo.ParsedInput;

class RacingGameTest {
    @Nested
    @DisplayName("성공 케이스")
    class Success {

        @Test
        @DisplayName("게임을 초기화 한다")
        void initializeRacingGame() {
            ParsedInput parsedInput = ParsedInputFixture.createValidInput();

            RacingGame racingGame = RacingGame.initializeRacingGame(parsedInput);

            assertThat(racingGame.hasMoreRound()).isTrue();
        }
    }
}
