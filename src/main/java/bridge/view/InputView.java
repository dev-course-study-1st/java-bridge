package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.util.converter.ConverterHolder;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RESTART_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static BridgeSize readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, BridgeSize.class);
    }

    public static MovingCommand readMoving() {
        System.out.println(INPUT_MOVING_COMMAND_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, MovingCommand.class);
    }

    public static RestartCommand readGameCommand() {
        System.out.println(INPUT_RESTART_COMMAND_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, RestartCommand.class);
    }
}
