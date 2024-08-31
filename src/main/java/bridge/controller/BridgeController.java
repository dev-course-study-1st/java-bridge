package bridge.controller;

import bridge.model.BridgeLength;
import bridge.service.BridgeGame;
import bridge.util.constant.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;


    public void run() {
        startGame();
        playGame();
        printResult();
    }

    private void startGame() {
        outputView.printStart();
        BridgeLength length = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(length);
    }

    public void playGame() {
        do {
            movePlayer();
            printCurrentBridgeState();
        } while(!isGameFinished());
        finishOrContinueGame();
    }

    private boolean isGameFinished() {
        return bridgeGame.isGameCompleted() || bridgeGame.isGameOver();
    }

    private void movePlayer() {
        bridgeGame.move(inputView.readMoving());
    }

    private void printCurrentBridgeState() {
        List<String> userBridge = bridgeGame.getUserBridge();
        List<String> bridgeLog = bridgeGame.getBridgeLog();
        outputView.printMap(userBridge, bridgeLog);
    }

    private void finishOrContinueGame() {
        if(bridgeGame.isGameOver()) {
            retryOrQuitGame();
        }
    }

    private void retryOrQuitGame() {
        if(inputView.readGameCommand().equals(Command.RETRY)) {
           bridgeGame.retry();
           playGame();
        }
    }

    private void printResult() {
        outputView.printResult();
        printCurrentBridgeState();
        outputView.printResult(bridgeGame.getResult());
    }
}
