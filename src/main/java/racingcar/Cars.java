package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> RacingCar;
    private int count = 0;

    public Cars(String[] inputcars) {


        this.RacingCar = mapCars(inputcars);

    }

    public List<Car> getRacingCar() {
        return RacingCar;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private List<Car> mapCars(String[] inputcars) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputcars.length; i++) {
            cars.add(new Car(inputcars[i]));
            this.count = this.count + 1;
        }
        return cars;
    }

    public void run() {
        for (int i = 0; i < RacingCar.size(); i++) {
            if (RacingCar.get(i).run(Randoms.pickNumberInRange(0, 9)) == CarCondition.Forword) {
                RacingCar.get(i).goForward();
            }
        }

    }

    public String toResult() {
        return "";
    }
}
