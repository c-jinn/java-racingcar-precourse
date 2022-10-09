package racingcar;

import static java.lang.Character.isDigit;

public class ValidCheck {
    public static boolean SizeCheck(String inputName) {
        if (inputName.length() <= 5)
            return true;
        return false;


    }

    public static boolean inputNameSizeCheck(Cars cars) {

//        System.out.println("cars count " + cars.count);
        for (int i = 0; i < cars.getCount() ; i++) {
//            System.out.println(cars.getRacingCar().get(i).getCarName().length());
            if(cars.getRacingCar().get(i).getCarName().length() >5)
                return false;
        }
        return true;



    }

    public static boolean inputNumberIsNUmber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!isDigit(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
