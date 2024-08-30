package bridge.controller;

import static bridge.view.InputViewProxy.*;
import static bridge.view.OutputView.*;

import bridge.domain.ApplicationStatus;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.service.BridgeGame;
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
        printStartMessage();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.CREATE_BRIDGE, this::createBridge);
        gameGuide.put(ApplicationStatus.GAME_START, this::startGame);
        gameGuide.put(ApplicationStatus.ROUND_END, this::endRound);
        gameGuide.put(ApplicationStatus.FINISH_GAME, this::finishGame);
        gameGuide.put(ApplicationStatus.RESTART_GAME, this::restartGame);
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
        BridgeSize size = readBridgeSize();
        bridgeGame.makeBridge(size.getValue());
        return ApplicationStatus.GAME_START;
    }

    private ApplicationStatus startGame() {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            MovingCommand movingCommand = readMoving();
            BridgeMap bridgeMap = bridgeGame.move(i, movingCommand);
            printMap(bridgeMap);
            if (bridgeGame.isRoundEnd(i, movingCommand)) {
                return ApplicationStatus.ROUND_END;
            }
        }
        bridgeGame.setIsSuccessInGame();
        return ApplicationStatus.FINISH_GAME;
    }

    private ApplicationStatus endRound() {
        RestartCommand restartCommand = readGameCommand();
        if (restartCommand.isQuitGame()) {
            return ApplicationStatus.FINISH_GAME;
        }
        return ApplicationStatus.RESTART_GAME;
    }

    private ApplicationStatus restartGame() {
        bridgeGame.retry();
        return ApplicationStatus.GAME_START;
    }

    private ApplicationStatus finishGame() {
        printResult(bridgeGame.getResult());
        return ApplicationStatus.APPLICATION_EXIT;
    }
}
