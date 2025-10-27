package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
        validateName(name);
    }

    public static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

}
