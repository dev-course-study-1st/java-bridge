package bridge.controller;

import bridge.domain.ApplicationStatus;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.service.BridgeService;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BridgeController {

    private final BridgeService bridgeService;
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
        this.gameGuide = new EnumMap<>(ApplicationStatus.class);
        initializeGameGuide();
        OutputView.printStartMessage();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.CREATE_BRIDGE, this::createBridge);
        gameGuide.put(ApplicationStatus.INITIALIZE_GAME, this::initializeGame);
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

    private ApplicationStatus initializeGame() {
        return ApplicationStatus.GAME_START;
    }

    public ApplicationStatus createBridge() {
        BridgeSize size = InputViewProxy.readBridgeSize();
        bridgeService.makeBridge(size);
        return ApplicationStatus.GAME_START;
    }

    private ApplicationStatus startGame() {
        for (int index = 0; index < bridgeService.getBridgeSize(); index++) {
            MovingCommand movingCommand = InputViewProxy.readMoving();
            bridgeService.move(index, movingCommand);
            OutputView.printMap();
            if (bridgeService.isRoundEnd(index, movingCommand)) {
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
        return bridgeService.retry();
    }

    private ApplicationStatus quitGame() {
        OutputView.printResult();
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private ApplicationStatus handleGameSuccess() {
        bridgeService.setIsSuccessInGame();
        OutputView.printResult();
        return ApplicationStatus.APPLICATION_EXIT;
    }
}
