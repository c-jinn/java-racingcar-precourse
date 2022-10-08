package racingcar;

public class ValidCheck {
    public boolean SizeCheck(String inputName) {
        if (inputName.length() <= 5)
            return true;
        return false;


    }
}
