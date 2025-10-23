package racingcar.controller;

import racingcar.view.OutputView;

public class RacingcarController {
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printRacingcarNameInputGuide();
    }
}
