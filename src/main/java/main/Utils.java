package main;

public class Utils {

    /**
     * Converts frames per second to seconds per frame
     * @param fps Frames per Second
     * @return spf - seconds per frame
     */
    public static double fpsToSpf(double fps) {
        return 1 / fps;
    }
}
