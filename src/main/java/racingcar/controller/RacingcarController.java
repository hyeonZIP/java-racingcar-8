package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printRacingcarNameInputGuide();
        String userInput = inputView.getUserInput();
    }
}
