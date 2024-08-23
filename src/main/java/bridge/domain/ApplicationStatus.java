package bridge.domain;

public enum ApplicationStatus {
    CREATE_BRIDGE,
    INITIALIZE_GAME,
    GAME_START,
    ROUND_START,
    ROUND_CONTINUE,
    ROUND_END,
    SELECT_RESTART,
    RESTART_GAME,
    QUIT_GAME,
    FINISH_GAME,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
}
