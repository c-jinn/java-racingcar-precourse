package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Race {

    private ConsoleInput RaceInput;
    private Cars racingCars;

    public Race() {
    }


    public void start() {

        InsertNames();
        InsertTryingNumber();
        Racing();
        RacingResult();

    }

    private void InsertNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        RaceInput = new ConsoleInput();
        RaceInput.setCarNames(Console.readLine());
        try {
            racingCars = new Cars(RaceInput.getCarNames().split(","));

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            InsertNames();
        }
    }

    private void InsertTryingNumber() {
        System.out.println("시도할 회수");
        RaceInput.setTryingNumber(Console.readLine());
        try {
            ValidCheck.CheckInputNumber(RaceInput.getTryingNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            InsertTryingNumber();

        }
    }


    private void Racing() {

        System.out.println("");
        System.out.println("실행 결과");
        for (int tryNum = 0; tryNum < RaceInput.getTryingNumberToInt(); tryNum++) {
            racingCars.run();
            for (int carNum = 0; carNum < racingCars.getCarCount(); carNum++)
                System.out.println(racingCars.getRacingCarName(carNum) + " : " + PositionToHipen(racingCars.getRacingCarPosition(carNum)));

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

    private int GetMaxPosition() {
        int MaxNumber = 0;
        for (int carNum = 0; carNum < racingCars.getCarCount(); carNum++)
            MaxNumber = max(MaxNumber, racingCars.getRacingCarPosition(carNum));

        return MaxNumber;
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
        for (int i = 0; i < racingCars.getCarCount(); i++) {
            if (maxPosition == racingCars.getRacingCarPosition(i))
                RaceResult.add(racingCars.getRacingCarName(i));
        }

        return RaceResult;
    }

}
