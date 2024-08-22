package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.util.converter.ConverterHolder;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSize readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return ConverterHolder.convert(input, BridgeSize.class);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MovingCommand readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return ConverterHolder.convert(input, MovingCommand.class);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RestartCommand readGameCommand() {
        return null;
    }
}
