package racingcar.util;

import java.util.HashSet;
import racingcar.view.InputView;

public class UserInput {
    static final int NAME_LENGTH = 5;

    public static String[] getCarNames() {
        String[] carNames = InputView.setUserInput().split(",");
        checkNameLength(carNames);
        checkDuplicates(carNames);
        return carNames;
    }

    public static void checkNameLength(String[] nameList) {
        for (String name : nameList) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException(String.format("자동차의 이름을 %s자 이내로 입력해주세요.", NAME_LENGTH));
            }
        }
    }

    public static void checkDuplicates(String[] nameList) {
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : nameList) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차의 이름을 중복되지 않게 입력해주세요.");
            }
        }
    }

    public static int getTotalRound() {
        String inputRaceCount = InputView.setRaceCount();
        int raceCount = checkInteger(inputRaceCount);
        checkPositiveInteger(raceCount);
        return raceCount;
    }

    public static int checkInteger(String inputRaceCount) {
        try {
            return Integer.parseInt(inputRaceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void checkPositiveInteger(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
    }
}
