package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void carNametest () {
        Cars testcars = new Cars("testcar1,testcar2,testcar3".split(","));

        assertThat(testcars.getRacingCars().get(0).getCarName()).isEqualTo("testcar1");

        assertThat(testcars.getRacingCars().get(1).getCarName()).isEqualTo("testcar2");
        assertThat(testcars.getRacingCars().get(2).getCarName()).isEqualTo("testcar3");
    }

}
