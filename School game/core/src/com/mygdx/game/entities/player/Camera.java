package com.mygdx.game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameProperties;

public class Camera extends PerspectiveCamera{
    private final Vector3 right = new Vector3();
    private final Vector3 up = new Vector3(0, 1, 0);
    private final Vector3 direction = new Vector3();


    public Camera(float fieldOfViewY, float viewportWidth, float viewportHeight) {
        super(fieldOfViewY, viewportWidth, viewportHeight);
        position.set(0, 10f, 0f);
        lookAt(10,10,10);
        near = 1f;
        far = 300f;
    }

    public void rotateUsingMouse() {

        float deltaX = -Gdx.input.getDeltaX() * GameProperties.mouseSensitivity; // adjust sensitivity
        float deltaY = -Gdx.input.getDeltaY() * GameProperties.mouseSensitivity;

//        System.out.println(deltaX + ", " + deltaY);

        // get the camera's direction vector and the up vector
        Vector3 newDirection = super.direction.cpy();

//        System.out.println(newDirection);

        // rotate the direction vector based on the mouse movement
        newDirection.rotate(Vector3.Y, deltaX);
        newDirection.rotate(super.direction.cpy().crs(up).nor(), deltaY);

        // set the camera's new direction and update it
        super.direction.set(newDirection);
        update();
    }
}
