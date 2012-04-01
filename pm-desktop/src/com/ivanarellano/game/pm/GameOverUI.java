package com.ivanarellano.game.pm;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ivanarellano.game.pm.Assets.LabelStyles;

public class GameOverUI extends Group {
	PmGame game;
	
	Image tintOverlay = new Image(Assets.atlas.findRegion("tintoverlay"));
	Image logo = new Image(Assets.atlas.findRegion("logogameover")); 
	Image newGame = new Image(Assets.atlas.findRegion("newlandgameover"));
	Image quitGame = new Image(Assets.atlas.findRegion("quitgameover"));
	Image scoreText = new Image(Assets.atlas.findRegion("scoregameover"));
	Label scoreNumber = new Label("0", LabelStyles.MOVES_COUNTER);
	
	boolean isActive = false;
	
	public GameOverUI(PmGame game) {
		this.game = game;
		
		logo.x = PmGame.SCREEN_WIDTH - logo.width - 10;
		logo.y = PmGame.SCREEN_HEIGHT - logo.height - 40;
		
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
		
		tintOverlay.setFillParent(true);
	}
	
	public void init() {
		isActive = true;
		
		addActor(logo);
		addActor(newGame);
		addActor(quitGame);
		addActor(scoreNumber);
		addActor(scoreText);
		
		game.stage.addActor(tintOverlay);
		game.stage.addActor(this);
	}
	
	public void removeUI() {
		isActive = false;
		
		game.stage.removeActor(tintOverlay);
		game.stage.removeActor(this);
	}
}
