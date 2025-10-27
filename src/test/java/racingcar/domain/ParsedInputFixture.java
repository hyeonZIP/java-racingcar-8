package racingcar.domain;

import racingcar.vo.ParsedInput;

public class ParsedInputFixture {
    private static final String VALID_CAR_NAMES = "pobi,tobi,bibi";
    private static final String VALID_TOTAL_ROUND = "5";

    public static ParsedInput createValidInput() {
        return ParsedInput.parse(VALID_CAR_NAMES, VALID_TOTAL_ROUND);
    }

    public static ParsedInput createCustomCarNamesInput(String carNames){
        return ParsedInput.parse(carNames, VALID_TOTAL_ROUND);
    }

    public static ParsedInput createCustomRoundInput(String round){
        return ParsedInput.parse(VALID_CAR_NAMES, round);
    }
}
