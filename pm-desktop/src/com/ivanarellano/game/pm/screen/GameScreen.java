package com.ivanarellano.game.pm.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.ivanarellano.game.pm.PmGame;
import com.ivanarellano.game.pm.PmScreen;

public class GameScreen extends PmScreen {

	public GameScreen(PmGame game) {
		super(game);
		Gdx.gl.glClearColor(game.bgColor.r, game.bgColor.g, game.bgColor.b, game.bgColor.a);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        game.stage.act(delta);
        game.stage.draw();
	}

	@Override
	public void resize(int width, int height) {		
	}

	@Override
	public void show() {		
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {
		game.stage.dispose();
	}

}
