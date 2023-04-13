package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {
	public ModelBatch modelBatch;

	public Model groundModel;

	List<ModelInstance> instances = new ArrayList<>();
	public ModelInstance groundInstance;
	public Model cubeModel;
	public ModelInstance cube;
	public Environment environment;

	private Player player;

	@Override
	public void create () {
		modelBatch = new ModelBatch();

		player = new Player();

		ModelBuilder modelBuilder = new ModelBuilder();
		groundModel = modelBuilder.createBox(100f, 1f, 100f,
				new Material(ColorAttribute.createDiffuse(Color.WHITE)),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		cubeModel = modelBuilder.createBox(100f, 1f, 100f,
				new Material(ColorAttribute.createDiffuse(Color.RED)),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		cube = new ModelInstance(cubeModel);
		groundInstance = new ModelInstance(groundModel);
		cube.transform.setToWorld(Vector3.Zero, Vector3.Z, Vector3.Y);
		instances.add(cube);
//		instances.add(groundInstance);

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
		for(ModelInstance instance : instances) {
			modelBatch.render(instance, environment);
		}
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
		groundModel.dispose();
	}
}
