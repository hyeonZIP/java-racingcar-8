package racingcar.domain;

import racingcar.vo.ParsedInput;

public class ParsedInputFixture {
    private static final String VALID_CAR_NAMES = "pobi,tobi,bibi";
    private static final String VALID_TOTAL_ROUND = "5";
    private static final String EMPTY_INPUT = "";
    private static final String NOT_DIGIT = "오";
    private static final String OUT_OF_INTEGER = String.valueOf(Long.MAX_VALUE);

    public static ParsedInput createValidInput() {
        return ParsedInput.parse(VALID_CAR_NAMES, VALID_TOTAL_ROUND);
    }

    public static void createEmptyCarNamesInput() {
        ParsedInput.parse(EMPTY_INPUT, VALID_TOTAL_ROUND);
    }

    public static void createEmptyTotalRoundInput() {
        ParsedInput.parse(VALID_CAR_NAMES, EMPTY_INPUT);
    }

    public static void createNotIntegerTotalRoundInput() {
        ParsedInput.parse(VALID_CAR_NAMES, NOT_DIGIT);
    }

    public static void createOutOfIntegerTotalRoundInput() {
        ParsedInput.parse(VALID_CAR_NAMES, OUT_OF_INTEGER);
    }
}
