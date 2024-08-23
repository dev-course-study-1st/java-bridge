package bridge.controller;

import bridge.domain.ApplicationStatus;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.service.BridgeGame;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BridgeController {

    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;
    private final BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.gameGuide = new EnumMap<>(ApplicationStatus.class);
        initializeGameGuide();
        OutputView.printStartMessage();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.CREATE_BRIDGE, this::createBridge);
        gameGuide.put(ApplicationStatus.GAME_START, this::startGame);
        gameGuide.put(ApplicationStatus.ROUND_END, this::endRound);
        gameGuide.put(ApplicationStatus.GAME_SUCCESS, this::handleGameSuccess);
        gameGuide.put(ApplicationStatus.RESTART_GAME, this::restartGame);
        gameGuide.put(ApplicationStatus.QUIT_GAME, this::quitGame);
    }

    public void run() {
        ApplicationStatus applicationStatus = progress(ApplicationStatus.CREATE_BRIDGE);
        while (applicationStatus.playable()) {
            applicationStatus = progress(applicationStatus);
        }
    }

    private ApplicationStatus progress(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (NullPointerException exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    public ApplicationStatus createBridge() {
        BridgeSize size = InputViewProxy.readBridgeSize();
        bridgeGame.makeBridge(size.getValue());
        return ApplicationStatus.GAME_START;
    }

    private ApplicationStatus startGame() {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            MovingCommand movingCommand = InputViewProxy.readMoving();
            BridgeMap bridgeMap = bridgeGame.move(i, movingCommand);
            OutputView.printMap(bridgeMap);
            if (bridgeGame.isRoundEnd(i, movingCommand)) {
                return ApplicationStatus.ROUND_END;
            }
        }
        return ApplicationStatus.GAME_SUCCESS;
    }

    private ApplicationStatus endRound() {
        RestartCommand restartCommand = InputViewProxy.readGameCommand();
        if (restartCommand.isQuitGame()) {
            return ApplicationStatus.QUIT_GAME;
        }
        return ApplicationStatus.RESTART_GAME;
    }

    private ApplicationStatus restartGame() {
        return bridgeGame.retry();
    }

    private ApplicationStatus quitGame() {
        OutputView.printResult(bridgeGame.getResult());
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private ApplicationStatus handleGameSuccess() {
        bridgeGame.setIsSuccessInGame();
        OutputView.printResult(bridgeGame.getResult());
        return ApplicationStatus.APPLICATION_EXIT;
    }
}
