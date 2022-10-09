package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void carNametest () {
        Cars testcars = new Cars("testcar1,testcar2,testcar3".split(","));

        assertThat(testcars.getRacingCar().get(0).getCarName()).isEqualTo("testcar1");

        assertThat(testcars.getRacingCar().get(1).getCarName()).isEqualTo("testcar2");
        assertThat(testcars.getRacingCar().get(2).getCarName()).isEqualTo("testcar3");
    }

}
