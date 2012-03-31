package com.ivanarellano.game.pm.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ivanarellano.game.pm.Assets;
import com.ivanarellano.game.pm.Assets.Colors;
import com.ivanarellano.game.pm.Board;
import com.ivanarellano.game.pm.Direction;
import com.ivanarellano.game.pm.GameState;
import com.ivanarellano.game.pm.PmGame;
import com.ivanarellano.game.pm.PmScreen;

public class GameScreen extends PmScreen {
	GameState state = GameState.READY;
	Board board = new Board("745216803");
	Group groupBoard = new Group("board");
	Group groupTiles = new Group("tiles");
	public Image grassBoard = new Image(Assets.atlas.findRegion("grassboard"));

	public GameScreen(PmGame game) {
		super(game);
		Gdx.gl.glClearColor(Colors.DARK_NAVY.r, Colors.DARK_NAVY.g, Colors.DARK_NAVY.b, Colors.DARK_NAVY.a);

		initStage();
	}

	public void update(float delta) {
		game.stage.act(delta);
		
		if (state == GameState.READY) {
			
			if (Gdx.input.getAccelerometerY() <= -7.0f) {
				if (board.slideTile(Direction.LEFT)) {
					Gdx.app.log("update", "went l");
				}
			} else if (Gdx.input.getAccelerometerY() >= 7.0f) {
				if (board.slideTile(Direction.RIGHT)) {
					Gdx.app.log("update", "went r");
				}
			
			} else if (Gdx.input.getAccelerometerX() >= 9.5f) {
				if (board.slideTile(Direction.DOWN)) {
					Gdx.app.log("update", "went down");
				}
			
			} else if (Gdx.input.getAccelerometerX() <= -7.5f) {
				if (board.slideTile(Direction.UP)) {
					Gdx.app.log("update", "went up");
				}
			
			}
			
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		update(delta);

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
		groupBoard.x = PmGame.SCREEN_WIDTH / 2 - grassBoard.width / 2;
		groupBoard.y = PmGame.SCREEN_HEIGHT / 2 - grassBoard.height / 2;

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
