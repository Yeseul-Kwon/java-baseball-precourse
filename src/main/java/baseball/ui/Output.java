package baseball.ui;

import baseball.Application;

public class Output {
    private static final String REQUEST_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REQUEST_REPLAY_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CORRECT_ANSWER_AND_EXIT_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    public static final String BASEBALL_SIZE_EXCEPTION_MESSAGE = "자리 수를 입력해야 합니다.";
    public static final String BASEBALL_DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자가 존재합니다.";
    public static final String INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE = "1부터 9까지의 숫자만 입력 가능합니다.";
    public static final String REPLAY_INPUT_FORMAT_EXCEPTION_MESSAGE = "1 또는 2만 입력 가능합니다.";
    public static final String RESULT_NOTHING_MESSAGE = "낫싱";
    public static final String RESULT_STRIKE_MESSAGE = "스트라이크 ";
    public static final String RESULT_BALL_MESSAGE = "볼 ";

    public static void printRequestNumberInput() {
        System.out.print(REQUEST_NUMBER_INPUT_MESSAGE);
    }

    public static void printRequestReplayInput() {
        System.out.println(REQUEST_REPLAY_INPUT_MESSAGE);
    }

    public static void printBaseballGameResult(String result) {
        System.out.println(result);
    }

    public static void printCorrectAnswer() {
        System.out.println(Application.NUMBER_OF_DIGITS + CORRECT_ANSWER_AND_EXIT_MESSAGE);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
