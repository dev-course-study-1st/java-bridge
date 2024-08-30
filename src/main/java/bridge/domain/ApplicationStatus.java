package bridge.domain;

public enum ApplicationStatus {
    CREATE_BRIDGE,
    GAME_START,
    ROUND_END,
    RESTART_GAME,
    FINISH_GAME,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
}
