package racingcar;

public class Car {

    private final String CarName;
    int Position;

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public Car(String carName) {
        this.CarName = carName;

        this.setPosition(0);

    }

    public String getCarName() {
        return CarName;
    }


    public CarCondition run(int conditionValue) {
        if (conditionValue >= 4)
            return CarCondition.Forword;
        return CarCondition.Stop;
    }

    public void goForward() {

        this.setPosition(this.getPosition() + 1);
    }
}
