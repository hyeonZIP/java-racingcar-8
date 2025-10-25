package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.dto.RoundResult;
import racingcar.mapper.RoundResultMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.ParsedInput;

public class RacingcarController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        String rawCarNames = getRawCarNames();
        String rawTotalRound = getRawTotalRound();

        ParsedInput input = ParsedInput.parse(rawCarNames, rawTotalRound);

        RacingGame racingGame = RacingGame.initializeRacingGame(input);

        playRounds(racingGame);
    }

    private void playRounds(RacingGame racingGame) {
        outputView.printRoundResultGuide();

        while (racingGame.isFinalRound()) {
            racingGame.playRound();
            RoundResult roundResult = RoundResultMapper.toDto(racingGame.getCars());
        }
    }

    private String getRawCarNames() {
        outputView.printRacingcarNameInputGuide();
        return inputView.getUserInput();
    }

    private String getRawTotalRound() {
        outputView.printTotalRoundInputGuide();
        return inputView.getUserInput();
    }
}
