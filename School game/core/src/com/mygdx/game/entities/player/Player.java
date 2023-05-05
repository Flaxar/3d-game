package com.mygdx.game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.player.controlls.PlayerInputProcessor;

public class Player extends Entity {
    private Camera cam;
    private ModelInstance playerModel;

    public Player(String id) {
        super(id, null); // TODO: add player model to constructor and when calling
        setPlayerModel();
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

    private void setPlayerModel() {
        Model model = new Model();
        playerModel = new ModelInstance(model);
        super.setModel(playerModel);
    }

    public Camera getCam() {
        return cam;
    }
}
