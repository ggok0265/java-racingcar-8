package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandomGenerator;

import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator = new RandomGenerator();

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

    public void race() {
        cars.forEach(car -> car.increaseMoveCount(randomGenerator.generateRandomNumber(0, 9)));
    }

    public String getRacingResults() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getWinners() {
        int maxMovedCount = cars.stream()
                .map(Car::getMoveCount)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMovedCount)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}
