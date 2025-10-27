package racingcar.controller;

import racingcar.view.RacingView;

public class RacingController {
    public static void run() {
        String carNames = RacingView.getCarsInput();
        int tryingCount = RacingView.getTryingCountInput();
    }
}
