package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Race {
    private String inputNames;
    private String inputNumber;

    private Cars racingCars;

    public void start() {

        InsertNames();
        InsertTryingNumber();
        Racing();
        RacingResult();

    }

    private void InsertNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        inputNames = Console.readLine();
        try {
            racingCars = new Cars(inputNames.split(","));

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            InsertNames();
        }
    }

    private void InsertTryingNumber() {
        System.out.println("시도할 회수");
        inputNumber = Console.readLine();
        try {
            ValidCheck.CheckInputNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            InsertTryingNumber();

        }
    }


    private void Racing() {

        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(inputNumber); i++) {
            racingCars.run();
            for (int j = 0; j < racingCars.getCount(); j++) {
                System.out.println(racingCars.getRacingCar().get(j).getCarName() + " : " + PositionToHipen(racingCars.getRacingCar().get(j).getPosition()));
            }
            System.out.println("");
        }
    }

    private String PositionToHipen(int position) {
        String hipens = "";
        for (int i = 0; i < position; i++) {
            hipens += "-";
        }
        return hipens;
    }

    private void RacingResult() {

        int MaxPosition = GetMaxPosition();
        List<String> RaceResult = GetWinnerName(MaxPosition);
        String ResultString = "최종 우승자 : ";
        ResultString += WinnerToString(RaceResult);
        System.out.println(ResultString);
    }

    private String WinnerToString(List<String> raceResult) {
        String returnString = "";
        for (int i = 0; i < raceResult.size(); i++) {
            if (i > 0) {
                returnString += ", ";
            }
            returnString += raceResult.get(i);
        }
        return returnString;
    }

    private List<String> GetWinnerName(int maxPosition) {
        List<String> RaceResult = new ArrayList<String>();
        for (int i = 0; i < racingCars.getCount(); i++) {
            if (maxPosition == racingCars.getRacingCar().get(i).getPosition())
                RaceResult.add(racingCars.getRacingCar().get(i).getCarName());
        }

        return RaceResult;
    }

    private int GetMaxPosition() {


        int MaxNumber = 0;
        for (int i = 0; i < racingCars.getCount(); i++)
            MaxNumber = max(MaxNumber, racingCars.getRacingCar().get(i).getPosition());

        return MaxNumber;
    }
}
