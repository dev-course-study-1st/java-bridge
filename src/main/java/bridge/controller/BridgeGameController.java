package bridge.controller;
import bridge.model.AttemptCount;
import bridge.model.BridgeSize;
import bridge.model.BridgeState;
import bridge.service.BridgeGameService;
import bridge.utils.handler.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService;
    private final AttemptCount attemptCount;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
        this.attemptCount = new AttemptCount();
    }

    public void run() {
        initialGame();
        playGame();
        printResult();
    }

    private void initialGame() {
        OutputView.printGameStart();
        BridgeSize bridgeSize = InputHandler.handleInput(InputView::readBridgeSize);
        bridgeGameService.initializeGame(bridgeSize);
    }

    private void playGame() {
        do {
            String moveCommand = InputHandler.handleInput(InputView::readMoving);
            bridgeGameService.move(moveCommand);
            BridgeState bridgeState = bridgeGameService.getBridgeState();
            OutputView.printMap(bridgeState);
            // 게임에서 이긴 경우
            if (bridgeGameService.isGameWon()) {
                return;
            }
        } while (bridgeGameService.isGameSuccess());
        retryGame();
    }

    private void retryGame() {
        String gameCommand = InputHandler.handleInput(InputView::readGameCommand);
        // 재시작 하는 경우
        if (bridgeGameService.retry(gameCommand)) {
            attemptCount.increment();
            playGame();
        }
    }

    private void printResult(){
        BridgeState bridgeState = bridgeGameService.getBridgeState();
        boolean success = bridgeGameService.isGameWon();
        OutputView.printResult(bridgeState, attemptCount, success);
    }

}
