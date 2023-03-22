package game;

public class GameEngine implements Runnable {
    private final Thread gameLoopThread;

    public GameEngine(String windowTitle, int width, int height, boolean vsSync, IGameLogic gameLogic) throws Exception {
        gameLoopThread = new Thread(this, "GAME_LOOP_THREAD");
        window = new Window(windowTitle, width, height, vsSync);
        this.gameLogic = gameLogic;
        //..[Removed code]..
    }

    @Override
    public void run() {

    }
}
