package racingcar.exception;

public enum ExceptionMessage {
    // Car
    CAR_NAME_NOT_BLANK("[ERROR] 자동차 이름이 비어있습니다."),
    CAR_NAME_OUT_OF_LENGTH("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하 입니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
