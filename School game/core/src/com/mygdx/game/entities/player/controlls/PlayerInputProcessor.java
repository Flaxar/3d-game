package com.mygdx.game.entities.player.controlls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.entities.player.Camera;

public class PlayerInputProcessor implements InputProcessor {
    Camera cam;

    public PlayerInputProcessor(Camera cam) {
        Gdx.input.setCursorCatched(true);
        this.cam = cam;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        cam.rotateUsingMouse();
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }




}
