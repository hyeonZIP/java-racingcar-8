package racingcar.controller;

import racingcar.domain.RacingGame;
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
