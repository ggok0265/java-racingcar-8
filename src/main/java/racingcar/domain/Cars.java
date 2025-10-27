package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawNames) {
        validateNames(rawNames);
        cars = Arrays.stream(rawNames.split(","))
                .map(Car::new)
                .toList();
    }

    public static void validateNames(String rawNames) {
        if (rawNames == null || rawNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어있습니다.");
        }
    }
}
