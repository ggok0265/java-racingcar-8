package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.RacingView;

public class RacingController {
    public static void run() {
        String carNames = RacingView.getCarsInput();
        int tryingCount = RacingView.getTryingCountInput();

        Cars cars = new Cars(carNames);
        System.out.println("실행 결과");
        runRacing(cars, tryingCount);
    }

    private static void runRacing(Cars cars, int tryingCount) {
        for (int i = 0; i < tryingCount; i++) {
            cars.race();
            RacingView.pringResults(cars.getRacingResults());
        }
    }
}
