package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.player.controlls.PlayerInputProcessor;

public class Player {
    private Camera cam;

    public Player() {
        initCamera();
    }

    public void update() {
        cam.update();

//        Gdx.app.log("INFO", "X = " + cam.position.x + ", Y = " + cam.position.y + ", Z = " + cam.position.z);
    }

    private void initCamera() {
        cam = new Camera(77, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new PlayerInputProcessor(cam));
    }


    public Camera getCam() {
        return cam;
    }
}
