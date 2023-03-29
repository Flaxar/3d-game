package game;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Game {
    private GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err);
    private GLFWKeyCallback keyCallback;
    private long window;

    public Game() throws IllegalStateException {
        glfwSetErrorCallback(errorCallback);

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        createWindow();
    }

    public void createWindow() {
        window = glfwCreateWindow(640, 480, "Simple example", NULL, NULL);
        if (window == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed to create the GLFW window");
        }

        createCallbacks();
        glfwSetKeyCallback(window, keyCallback);

        glfwMakeContextCurrent(window);
        GL.createCapabilities();
    }

    private void createCallbacks() {
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true);
                }
            }
        };
    }

    public void endGame() {
        glfwDestroyWindow(window);
        keyCallback.free();
        glfwTerminate();
        errorCallback.free();
    }
}