package racingcar;

public class Car {

    private final String CarName;
    int Position ;

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public Car(String carName) {
//        ValidCheck.SizeCheck(carName);
        this.CarName = carName;

        this.setPosition(0);

    }
    public String getCarName() {
        return CarName;
    }


    public CarCondition run(int conditionValue) {
//        System.out.println(this.CarName + " : " + conditionValue );
        if (conditionValue >= 4)
            return CarCondition.Forword;
        return CarCondition.Stop;
    }

    public void goForward() {

//        System.out.println("Go Forward : ");
//        System.out.println(this.getPosition());
        this.setPosition(this.getPosition() +1 );
//        System.out.println( this.getPosition());
    }
}
