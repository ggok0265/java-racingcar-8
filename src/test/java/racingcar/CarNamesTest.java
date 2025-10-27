package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {
    @Test
    void 입력값_null_검증() {
        assertThatThrownBy(() -> Cars.validateNames(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_빈_문자열_검증() {
        assertThatThrownBy(() -> Cars.validateNames("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_파싱_테스트() {
        Assertions.assertDoesNotThrow(() -> Cars.validateNames("pobi,woni,jun"));
    }

    @Test
    void 이름_길이_테스트() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Car("abcdef")
        );
    }

}
