package racingcar.view;

public class OutputView {
    private static final String RACINGCAR_NAME_ENTER_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_ROUND_ENTER_GUIDE = "시도할 횟수는 몇 회인가요?";

    public void printRacingcarNameInputGuide() {
        System.out.println(RACINGCAR_NAME_ENTER_GUIDE);
    }

    public void printTotalRoundInputGuide() {
        System.out.println(TOTAL_ROUND_ENTER_GUIDE);
    }
}
