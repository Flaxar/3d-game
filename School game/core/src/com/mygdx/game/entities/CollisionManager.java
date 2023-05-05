package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.physics.bullet.collision.*;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private List<Entity> entities = new ArrayList<>();



    public boolean checkCollision(btCollisionObject obj1, btCollisionObject obj2) {
        CollisionObjectWrapper co0 = new CollisionObjectWrapper(obj1);
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(obj2);

        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
//        ci.setDispatcher1(dispatcher);
        btCollisionAlgorithm algorithm = new btSphereBoxCollisionAlgorithm(null, ci, co0.wrapper, co1.wrapper, false);

        btDispatcherInfo info = new btDispatcherInfo();
        btManifoldResult result = new btManifoldResult(co0.wrapper, co1.wrapper);

        algorithm.processCollision(co0.wrapper, co1.wrapper, info, result);

        boolean r = result.getPersistentManifold().getNumContacts() > 0;

        result.dispose();
        info.dispose();
        algorithm.dispose();
        ci.dispose();
        co1.dispose();
        co0.dispose();

        return r;
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
