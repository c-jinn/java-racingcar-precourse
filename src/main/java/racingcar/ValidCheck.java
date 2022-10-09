package racingcar;

import static java.lang.Character.isDigit;

public class ValidCheck {
    public static boolean SizeCheck(String inputName) {
        if (inputName.length() <= 5)
            return true;
        return false;
    }

    public static boolean inputNamesSizeCheck(String[] CarName) {

        for (int i = 0; i < CarName.length; i++) {
            if (CarName[i].length() > 5)
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

    public static void CheckInputNumber(String inputNumber) {
        if (!ValidCheck.inputNumberIsNUmber(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
    }

    public static void checkInputNames(String[] inputCars) {
        if (!ValidCheck.inputNamesSizeCheck(inputCars)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 너무 길게 입력했습니다.");
        }
    }
}
