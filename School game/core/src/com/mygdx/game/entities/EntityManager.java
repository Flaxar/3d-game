package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Game;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    List<Entity> entities;
    ModelBuilder modelBuilder;

    public EntityManager() {
        this.entities = new ArrayList<>();
        modelBuilder = new ModelBuilder();
    }

    public String createRectangle(Vector3 dimensions, Vector3 position, Vector3 direction, Color color) {
        Model model = modelBuilder.createBox(dimensions.x, dimensions.y, dimensions.z,
                new Material(ColorAttribute.createDiffuse(color)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        ModelInstance modelInstance = new ModelInstance(model);
        modelInstance.transform.setToWorld(position, direction, Vector3.Y);

        String rigidBodyId = "rigid_body_" + Game.getNewId();
        RigidBody rigidBody = new RigidBody(rigidBodyId, modelInstance);
        this.add(rigidBody);
        return rigidBodyId;
    }

    public void render(ModelBatch modelBatch, Environment environment) {
        for(Entity entity : entities) {
            System.out.println(entity.getId());
            modelBatch.render(entity.getModel(), environment);
        }
    }

    public void disposeAll() {
        for(Entity entity : entities) {
            entity.getModel().model.dispose();
        }
    }

    public void add(Entity newEntity) {
        Entity tmp = contains(newEntity.getId());
        if(tmp == null) {
            entities.add(newEntity);
        }
    }

    /**
     * @param id entity to remove
     * @return true if found and removed, false if not found
     */
    public boolean remove(String id) {
        Entity tmp = contains(id);
        if(tmp == null) {
            return false;
        } else {
            entities.remove(tmp);
            return true;
        }
    }

    /**
     * @param id entity to find
     * @return entity if found, null if nothing found
     */
    public Entity contains(String id) {
        for(Entity entity : entities) {
            if(entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }
}
