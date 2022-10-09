package racingcar;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private String inputNames;
    private String inputNumber;

    private Cars racingcars;

    public void start() {


        InsertNames();
        InsertTryingNumber();
        Racing();
        RacingResult();

    }

    private void RacingResult() {

        int MaxNumber = 0;
        List<String> RaceResult = new ArrayList<String>();
        String ResultString = "최종 우승자 : ";
        for (int i = 0; i < racingcars.getCount(); i++) {
            if(MaxNumber < racingcars.getRacingCar().get(i).getPosition())
                MaxNumber = racingcars.getRacingCar().get(i).getPosition();
        }
        for (int i = 0; i < racingcars.getCount(); i++) {
            if(MaxNumber == racingcars.getRacingCar().get(i).getPosition())
                RaceResult.add(racingcars.getRacingCar().get(i).getCarName());

        }


        for (int i = 0; i < RaceResult.size(); i++) {
            if (i > 0 ) {
                ResultString += ", ";
            }

            ResultString += RaceResult.get(i);


        }
        System.out.println(ResultString);

    }

    private void InsertTryingNumber() {
        System.out.println("시도할 회수");
        inputNumber = Console.readLine();

        try {
            if (!ValidCheck.inputNumberIsNUmber(inputNumber)) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
            }
        }
        catch(IllegalArgumentException e ){
            System.out.println(e);
            InsertTryingNumber();

        }
    }

    private void InsertNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        inputNames = Console.readLine();
        racingcars = new Cars(inputNames.split(","));

        try {
            if (!ValidCheck.inputNameSizeCheck(racingcars)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름을 너무 길게 입력했습니다.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            InsertNames();
        }
    }

    private void Racing() {

        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(inputNumber) ; i++) {
            racingcars.run();

            for (int j = 0; j < racingcars.getCount(); j++) {

                System.out.println(racingcars.getRacingCar().get(j).getCarName() + " : " + PositionToHipen(racingcars.getRacingCar().get(j).getPosition()) );

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
}
