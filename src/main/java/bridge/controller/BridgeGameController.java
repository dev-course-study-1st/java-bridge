package bridge.controller;

import bridge.model.AttemptCount;
import bridge.model.BridgeSize;
import bridge.model.BridgeState;
import bridge.service.BridgeGameService;
import bridge.utils.handler.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.enums.Const.ATTEMPT_INIT_NUMBER;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService;
    private final AttemptCount attemptCount;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
        this.attemptCount = new AttemptCount(ATTEMPT_INIT_NUMBER.getNumber());

    }

    public void run() {
        OutputView.printGameStart();
        BridgeSize bridgeSize = InputHandler.handleInput(InputView::readBridgeSize);
        bridgeGameService.initializeGame(bridgeSize);
        while (true) {
            String moveCommand = InputHandler.handleInput(InputView::readMoving);
            BridgeState bridgeState = bridgeGameService.move(moveCommand);
            OutputView.printMap(bridgeState);
            // 게임이 끝났으면 최종 결과 출력
            if(bridgeGameService.isGameWon()){
                OutputView.printResult(bridgeState, attemptCount, true);
                return;
            }
            // 안끝났지만, 마지막이 성공한 경우 continue
            else if(bridgeGameService.isGameSuccess()){
                continue;
            }
            String gameCommand = InputHandler.handleInput(InputView::readGameCommand);
            // 재시작 하는 경우 시도 횟수 증가 후 retry
            if(bridgeGameService.retry(gameCommand)){
                attemptCount.increment();
                continue;
            }
            // 재시작 아닌 겨웅 최종 결과 출력 후 종료
            OutputView.printResult(bridgeState, attemptCount, false);
            return;
        }
    }
}
