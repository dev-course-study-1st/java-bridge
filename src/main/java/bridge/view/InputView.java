package bridge.view;

import bridge.model.BridgeLength;
import bridge.util.constant.Messages;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {



    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeLength readBridgeSize() {
        System.out.println(Messages.INPUT_LENGTH_MSG.getMessage());
        return new BridgeLength(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
