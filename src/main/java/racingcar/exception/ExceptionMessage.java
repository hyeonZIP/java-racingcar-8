package racingcar.exception;

public enum ExceptionMessage {
    // Car
    CAR_NAME_NOT_BLANK("[ERROR] 자동차 이름이 비어있습니다."),
    CAR_NAME_OUT_OF_LENGTH("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하 입니다."),

    // Cars
    CARS_NOT_EMPTY("[ERROR] 최소 한 개 이상의 객체가 저장되어야 합니다."),

    // ParsedInput
    INPUT_NOT_BLANK("[ERROR] 입력값이 비어있을 수 없습니다."),
    INPUT_NOT_INTEGER("[ERROR] 유효하지 않은 정수값 입니다."),

    // Round
    TOTAL_ROUND_OVER_MAXIMUM("[ERROR] 초기 시도 횟수는 최대값을 초과할 수 없습니다."),
    TOTAL_ROUND_UNDER_MINIMUM("[ERROR] 초기 시도 횟수는 최소값 미만일 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
