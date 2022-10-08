package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] inputcars) {


        this.cars = mapCars(inputcars);


    }

    private List<Car> mapCars(String[] inputcars) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputcars.length; i++) {
            cars.add(new Car(inputcars[i]));
//            System.out.println(inputcars[i]);
        }
        return cars;
    }
}
