package racingcar.vo;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.exception.ExceptionMessage;

public record ParsedInput(List<String> carNames, int totalRound) {
    private static final String COMMA = ",";

    public static ParsedInput parse(String rawCarNames, String rawTotalRound) {

        List<String> carNames = parseCarNames(rawCarNames);
        int totalRound = parseTotalRound(rawTotalRound);

        return new ParsedInput(carNames, totalRound);
    }

    private static List<String> parseCarNames(String rawCarNames) {
        validateBlank(rawCarNames);

        return Arrays.stream(rawCarNames.split(COMMA)).toList();
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
