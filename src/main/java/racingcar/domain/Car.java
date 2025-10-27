package racingcar.domain;

import java.util.Objects;
import org.junit.platform.commons.util.StringUtils;
import racingcar.exception.ExceptionMessage;

public class Car {
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;
    private final static int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public static Car register(String name) {
        validateCarName(name);

        return new Car(name);
    }

    public void increasePosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    private static void validateCarName(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private static void validateBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_NOT_BLANK.getMessage());
        }
    }

    private static void validateLength(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OUT_OF_LENGTH.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car other)) {
            return false;
        }

        return name.equals(other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
