package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

public abstract class Entity {
    private final String id;
    private ModelInstance model;

    public Entity(String id, ModelInstance model) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public ModelInstance getModel() {
        return model;
    }

    public void setModel(ModelInstance model) {
        this.model = model;
    }
}
