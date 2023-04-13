package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class Player {
    private PerspectiveCamera cam;
    public CameraInputController camController;

    public Player() {
        initCamera();
    }

    public void update() {
        Vector3 currentCamVector = cam.direction.cpy();
        cam.translate(currentCamVector.rotate(Vector3.Y, 90).setLength(1f));
        cam.transform(new Matrix4());
        camController.update();

        Gdx.app.log("INFO", "X = " + cam.position.x + ", Y = " + cam.position.y + ", Z = " + cam.position.z);
    }

    private void initCamera() {
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(10f, 10f, 10f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        camController = new CameraInputController(cam);

        Gdx.input.setInputProcessor(camController);
    }


    public PerspectiveCamera getCam() {
        return cam;
    }
}
