package racingcar.view;

import racingcar.dto.GameWinners;
import racingcar.dto.RoundResult;
import racingcar.dto.RoundResultDetails;

public class OutputView {
    private static final String RACINGCAR_NAME_ENTER_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_ROUND_ENTER_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String ROUND_RESULT_GUIDE = "\n실행 결과";
    private static final String CAR_POSITION_FORMAT = "%s : %s";
    private static final String GAME_WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";

    public void printRacingcarNameInputGuide() {
        System.out.println(RACINGCAR_NAME_ENTER_GUIDE);
    }

    public void printTotalRoundInputGuide() {
        System.out.println(TOTAL_ROUND_ENTER_GUIDE);
    }

    public void printRoundResultGuide() {
        System.out.println(ROUND_RESULT_GUIDE);
    }

    public void printRoundResult(RoundResult roundResult) {
        String output = buildRoundResultOutput(roundResult);

        System.out.println(output);
    }

    public void printGameWinners(GameWinners gameWinners) {
        String output = buildGameWinnersOutput(gameWinners);

        System.out.println(output);
    }

    private String buildGameWinnersOutput(GameWinners gameWinners) {
        StringBuilder output = new StringBuilder();

        gameWinners.gameWinners()
                .forEach(text -> output.append(text).append(COMMA));

        return String.format(GAME_WINNERS_FORMAT, output);
    }

    private String buildRoundResultOutput(RoundResult roundResult) {
        StringBuilder output = new StringBuilder();

        roundResult.roundResultDetails().stream()
                .map(this::formatCarPosition)
                .forEach(text -> output.append(text).append(NEW_LINE));

        return output.toString();
    }

    private String formatCarPosition(RoundResultDetails roundResultDetails) {
        String position = DASH.repeat(roundResultDetails.position());

        return String.format(CAR_POSITION_FORMAT, roundResultDetails.carName(), position);
    }
}
