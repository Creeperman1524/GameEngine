package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
    public static void main(String[] args) {

        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = { 
            -0.5f, 0.5f, 0, //V0
            -0.5f, -0.5f, 0, //V1
            0.5f, -0.5f, 0, //V2
            0.5f, 0.5f, 0 //V3
        };

        int[] indicies = { 0, 1, 3, 3, 1, 2 };

        RawModel model = loader.loadToVao(vertices, indicies);

        while (!Display.isCloseRequested()) {
            renderer.prepare();

            // game logic
            // render
            renderer.render(model);
            DisplayManager.updateDisplay();

        }

        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
}
