package game;

import main.Parameters;
import main.Utils;

import static java.lang.Thread.sleep;
import static org.lwjgl.glfw.GLFW.*;

public class Renderer {
    private final long window;

    public Renderer(long window) {
        this.window = window;
    }

    public void startGameLoop() throws InterruptedException {
        double funcStartTime = glfwGetTime();
        double secondsPerFrame = Utils.fpsToSpf(Parameters.FPS);


        while (!glfwWindowShouldClose(window)) {
            double loopStartTime = glfwGetTime();

            // do game logic here

            double timeDelta = glfwGetTime() - loopStartTime;
            sleep(timeDelta < secondsPerFrame ? (long) timeDelta : 0);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }
}
