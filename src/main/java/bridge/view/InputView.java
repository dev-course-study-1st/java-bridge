package bridge.view;

import bridge.model.BridgeLength;
import bridge.util.constant.Command;
import bridge.util.constant.MoveKey;
import camp.nextstep.edu.missionutils.Console;

import static bridge.util.constant.Messages.*;
import static bridge.util.constant.Messages.INPUT_MOVE_KEY_MSG;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeLength readBridgeSize() {
        try {
            return requestBridgeLength();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readBridgeSize();
        }
    }

    private BridgeLength requestBridgeLength() {
        System.out.println(INPUT_LENGTH_MSG.getMessage());
        return new BridgeLength(Console.readLine().trim());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveKey readMoving() {
        try {
            return requestMoveKey();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readMoving();
        }
    }

    private static MoveKey requestMoveKey() {
        System.out.println(INPUT_MOVE_KEY_MSG.getMessage());
        return MoveKey.getEnum(Console.readLine().trim());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        try {
            return requestRetryOrExit();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readGameCommand();
        }
    }

    private static Command requestRetryOrExit() {
        System.out.println(INPUT_RETRY_OR_QUIT_MSG.getMessage());
        return Command.getEnum(Console.readLine().trim());
    }
}
