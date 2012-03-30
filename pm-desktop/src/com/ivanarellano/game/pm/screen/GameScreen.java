package com.ivanarellano.game.pm.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ivanarellano.game.pm.Assets;
import com.ivanarellano.game.pm.Board;
import com.ivanarellano.game.pm.PmGame;
import com.ivanarellano.game.pm.PmScreen;

public class GameScreen extends PmScreen {
	Board board = new Board("745216803");
	Group groupBoard = new Group("board");
	Group groupTiles = new Group("tiles");
	public Image grassBoard = new Image(Assets.atlas.findRegion("grassboard"));

	public GameScreen(PmGame game) {
		super(game);
		Gdx.gl.glClearColor(game.bgColor.r, game.bgColor.g, game.bgColor.b, game.bgColor.a);

		initStage();
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
	
	void initStage() {
		// add some grass
		groupBoard.addActor(grassBoard);
		
		// place board in the middle
		groupBoard.x = PmGame.SCREEN_WIDTH/2 - grassBoard.width/2;
		
		// add and arrange tiles
		int XOffset = 45;
		int YOffset = 465;
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				board.tiles[row][col].x = XOffset;
				board.tiles[row][col].y = YOffset;
				
				groupTiles.addActor(board.tiles[row][col]);
								
				if (col >= 2)
					XOffset = 45;
				else
					XOffset += 215;
				
				if (board.tiles[row][col].number.contentEquals("0"))
					board.tiles[row][col].visible = false;
			}
			
			YOffset -= 215;
		}
		
		// layer tiles on top of grass
		groupBoard.addActor(groupTiles);
		
		// place it all on the stage
		game.stage.addActor(groupBoard);
	}

}
