package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.entities.CollisionManager;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {
	public ModelBatch modelBatch;
	public Environment environment;

	private Player player;
	private EntityManager entityManager;
	private CollisionManager collisionManager;

	private static int idCounter = 0;

	@Override
	public void create () {
		modelBatch = new ModelBatch();
		entityManager = new EntityManager();
		collisionManager = new CollisionManager();
		player = new Player("player");

		collisionManager.add(player);

		entityManager.add(player);
		entityManager.createRectangle(
				new Vector3(100, 1, 100),
				new Vector3(0, 0, 0),
				Vector3.Z,
				Color.BLUE);
		entityManager.createRectangle(
				new Vector3(50, 25, 50),
				new Vector3(50, 1, 50),
				Vector3.Z,
				Color.GREEN);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		Gdx.app.log("INFO", "Game initialization finished!");
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

//		Gdx.app.log("INFO", "Current FPS: " + Gdx.graphics.getFramesPerSecond());

		player.update();

		modelBatch.begin(player.getCam());
		entityManager.render(modelBatch, environment);
		modelBatch.end();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose () {
		modelBatch.dispose();
		entityManager.disposeAll();
		Gdx.app.log("INFO", "Everything disposed of!");
	}

	public static int getNewId() {
		return idCounter++;
	}
}
