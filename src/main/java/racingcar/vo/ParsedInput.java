package racingcar.vo;

import org.junit.platform.commons.util.StringUtils;
import racingcar.exception.ExceptionMessage;

public record ParsedInput(String[] carNames, int totalRound) {
    private static final String COMMA = ",";

    public static ParsedInput parse(String rawCarNames, String rawTotalRound) {

        String[] carNames = parseCarNames(rawCarNames);
        int totalRound = parseTotalRound(rawTotalRound);

        return new ParsedInput(carNames, totalRound);
    }

    private static String[] parseCarNames(String rawCarNames) {
        validateBlank(rawCarNames);

        return rawCarNames.split(COMMA);
    }

    private static int parseTotalRound(String rawTotalRound) {
        validateBlank(rawTotalRound);
        validateParsingInteger(rawTotalRound);

        return Integer.parseInt(rawTotalRound);
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_BLANK.getMessage());
        }
    }

    private static void validateParsingInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_INTEGER.getMessage());
        }
    }
}
