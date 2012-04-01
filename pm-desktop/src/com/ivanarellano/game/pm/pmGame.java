package com.ivanarellano.game.pm;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ivanarellano.game.pm.screen.GameScreen;

public class PmGame extends Game implements ApplicationListener {
	public static final int SCREEN_WIDTH = 1196; //1280
	public static final int SCREEN_HEIGHT = 720;
	
	public Stage stage;
	public Group groupTopGameScreen = new Group("topgamescreen");
	public Group groupMidGameScreen = new Group("midgamescreen");
	public ScreenStack screenStack = new ScreenStack(this);

	@Override
	public void create() {
		Gdx.app.log("libGdx ver", Integer.toString(Gdx.app.getVersion()));
		
		Gdx.graphics.setVSync(true);
		Gdx.input.setCatchBackKey(true);
		
		Assets.create();
		
		stage = new Stage(SCREEN_WIDTH, SCREEN_HEIGHT, false);
		
		groupMidGameScreen.width = groupTopGameScreen.width = SCREEN_WIDTH;
		groupMidGameScreen.height = groupTopGameScreen.height = SCREEN_HEIGHT;
		stage.addActor(groupMidGameScreen);
		stage.addActor(groupTopGameScreen);
		
		screenStack.add(new GameScreen(this));
		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.manager.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		Assets.manager.update();
		Assets.manager.finishLoading();
		super.resume();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
