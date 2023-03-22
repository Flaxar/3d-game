package game;

public class Window {
    private String windowTitle;
    private int width;
    private int height;
    private boolean vSync;

    public Window(String windowTitle, int width, int height, boolean vSync) {
        this.windowTitle = windowTitle;
        this.width = width;
        this.height = height;
        this.vSync = vSync;
    }
}
