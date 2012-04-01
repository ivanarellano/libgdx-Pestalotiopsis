package com.ivanarellano.game.pm;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ivanarellano.game.pm.Assets.LabelStyles;
import com.ivanarellano.game.pm.screen.GameScreen;

public class GameOverUI extends Group {	
	GameScreen gameScreen;
	
	Image newGame;
	Image quitGame;
	Image tintOverlay = new Image(Assets.atlas.findRegion("tintoverlay"));
	Image logo = new Image(Assets.atlas.findRegion("logogameover")); 
	Image scoreText = new Image(Assets.atlas.findRegion("scoregameover"));
	Label scoreNumber = new Label("0", LabelStyles.MOVES_COUNTER);
		
	public GameOverUI(final GameScreen game) {
		gameScreen = game;
		
		logo.x = PmGame.SCREEN_WIDTH - logo.width - 10;
		logo.y = PmGame.SCREEN_HEIGHT - logo.height - 40;
		
		newGame = new Image(Assets.atlas.findRegion("newlandgameover")) {
			@Override
			public boolean touchDown(float x, float y, int pointer) {
				gameScreen.resetBoard();
				removeUI();
				gameScreen.state = GameState.READY;
				return super.touchDown(x, y, pointer);
			}
		};
		
		quitGame = new Image(Assets.atlas.findRegion("quitgameover")) {
			@Override
			public boolean touchDown(float x, float y, int pointer) {
				gameScreen.game.screenStack.setPrevious();
				return super.touchDown(x, y, pointer);
			}
		};
		
		newGame.touchable = true;
		newGame.x = PmGame.SCREEN_WIDTH - newGame.width - 10;
		newGame.y = PmGame.SCREEN_HEIGHT - newGame.height - 211;
		
		quitGame.touchable = true;
		quitGame.x = PmGame.SCREEN_WIDTH - quitGame.width - 10;
		quitGame.y = PmGame.SCREEN_HEIGHT - quitGame.height - 288;
		
		scoreNumber.x = PmGame.SCREEN_WIDTH - scoreNumber.width - 165;
		scoreNumber.y = -50;
		
		scoreText.x = PmGame.SCREEN_WIDTH - scoreText.width - 156;
		scoreText.y = 20;
		
		tintOverlay.scaleX = 3.0f;
		tintOverlay.scaleY = 3.0f;
	}
	
	public void init() {		
		addActor(tintOverlay);
		addActor(logo);
		addActor(newGame);
		addActor(quitGame);
		addActor(scoreNumber);
		addActor(scoreText);
		
		gameScreen.game.groupMidGameScreen.addActor(this);
	}
	
	public void removeUI() {		
		gameScreen.game.groupMidGameScreen.removeActor(this);
	}
	
}
