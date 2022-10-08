package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    private Car car;

    @Test
    void 전진(){
        CarCondition carCondition = car.run(5);

        assertThat(carCondition).isEqualTo(CarCondition.Forword);

    }


}
