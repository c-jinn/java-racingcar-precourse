package racingcar;

public class Car {


    private final String CarName;

    public Car(String carName) {
        this.CarName = carName;

    }

    public CarCondition run(int conditionValue) {
        if (conditionValue >= 4)
            return CarCondition.Forword;
        return CarCondition.Stop;
    }
}
