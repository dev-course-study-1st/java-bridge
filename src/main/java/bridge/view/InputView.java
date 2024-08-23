package bridge.view;

import bridge.model.BridgeSize;
import bridge.utils.validator.CommandValidator;
import bridge.utils.validator.MoveValidator;
import bridge.utils.validator.SizeValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.enums.IOMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSize readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
        String input = Console.readLine();
        return new BridgeSize(SizeValidator.validate(input));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_DIRECTION.getMessage());
        String input = Console.readLine();
        return MoveValidator.validate(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_GAME_RETRY.getMessage());
        String input = Console.readLine();
        return CommandValidator.validate(input);
    }
}
