package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.dto.GameWinners;
import racingcar.dto.RoundResult;
import racingcar.mapper.GameWinnersMapper;
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

        printWinners(racingGame);
    }

    private void printWinners(RacingGame racingGame) {
        GameWinners gameWinners = GameWinnersMapper.toDto(racingGame.getGameWinners());

        outputView.printGameWinners(gameWinners);
    }

    private void playRounds(RacingGame racingGame) {
        outputView.printRoundResultGuide();

        while (racingGame.hasMoreRound()) {
            racingGame.playRound();

            RoundResult roundResult = RoundResultMapper.toDto(racingGame.getCars());

            outputView.printRoundResult(roundResult);
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
