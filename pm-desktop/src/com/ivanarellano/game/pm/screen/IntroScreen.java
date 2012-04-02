package com.ivanarellano.game.pm.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Align;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.ivanarellano.game.pm.Assets;
import com.ivanarellano.game.pm.Assets.Colors;
import com.ivanarellano.game.pm.PmGame;
import com.ivanarellano.game.pm.PmScreen;

public class IntroScreen extends PmScreen {
	Group groupIntroScreen = new Group("introscreen");
	
	Image logo = new Image(Assets.atlas.findRegion("logointro"));
	Image smallDeadGrass = new Image(Assets.atlas.findRegion("smalldeadgrass"));
	Image smallGrass = new Image(Assets.atlas.findRegion("smallgrass"));
	Image mushroom;
	Image milkJug;
	
	public IntroScreen(final PmGame game) {
		super(game);
		Gdx.gl.glClearColor(Colors.DARK_NAVY.r, Colors.DARK_NAVY.g, Colors.DARK_NAVY.b, Colors.DARK_NAVY.a);
		
		logo.x = PmGame.SCREEN_WIDTH/2 - logo.width/2;
		logo.y = PmGame.SCREEN_HEIGHT/2 + 95;
		
		ClickListener mushroomOnHit = new ClickListener() {
			@Override
			public void click(Actor actor, float x, float y) {				
				if (overlaps(actor, milkJug)) {
					game.groupMidGameScreen.clear();
					game.screenStack.add(new GameScreen(game));
				}
				else {
					actor.x = PmGame.SCREEN_WIDTH/2 - 60;
					actor.y = PmGame.SCREEN_HEIGHT/2 - 146;
				}

			}
		};
		
		mushroom = new Image(Assets.atlas.findRegion("mushroom"), Scaling.stretch, Align.CENTER, "mushroom") {
			
			@Override
			public void touchDragged(float x, float y, int pointer) {
				this.x += x - this.width/2;
				this.y += y - this.height/2;
			}
		};
		
		
		ClickListener milkJugOnHit = new ClickListener() {
			@Override
			public void click(Actor actor, float x, float y) {
				if (overlaps(actor, mushroom)) {
					game.groupMidGameScreen.clear();
					game.screenStack.add(new GameScreen(game));
				} else {
					actor.x = PmGame.SCREEN_WIDTH/2 + 111;
					actor.y = PmGame.SCREEN_HEIGHT/2 - 146;
				}

			}
		};
		
		milkJug = new Image(Assets.atlas.findRegion("milkjug"), Scaling.stretch, Align.CENTER, "milkjug") {
			@Override
			public void touchDragged(float x, float y, int pointer) {
				this.x += x - this.width/2;
				this.y += y - this.height/2;
			}
		};
		
		mushroom.touchable = true;
		mushroom.setClickListener(mushroomOnHit);
		mushroom.x = PmGame.SCREEN_WIDTH/2 - 60;
		mushroom.y = PmGame.SCREEN_HEIGHT/2 - 146;
		smallGrass.x = PmGame.SCREEN_WIDTH/2 - 85;
		smallGrass.y = PmGame.SCREEN_HEIGHT/2 - 169;
		
		milkJug.touchable = true;
		milkJug.setClickListener(milkJugOnHit);
		milkJug.x = PmGame.SCREEN_WIDTH/2 + 111;
		milkJug.y = PmGame.SCREEN_HEIGHT/2 - 146;
		smallDeadGrass.x = PmGame.SCREEN_WIDTH/2 + 85;
		smallDeadGrass.y = PmGame.SCREEN_HEIGHT/2 - 169;
		
		groupIntroScreen.addActor(logo);
		groupIntroScreen.addActor(smallDeadGrass);
		groupIntroScreen.addActor(smallGrass);
		groupIntroScreen.addActor(milkJug);
		groupIntroScreen.addActor(mushroom);
		
		game.groupMidGameScreen.addActor(groupIntroScreen);
	}
	
	public void update(float delta) {
		game.stage.act(delta);
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

	public boolean overlaps (Actor actorA, Actor actorB) {
		return !(actorA.x > actorB.x + actorB.width || actorA.x + actorA.width
				< actorB.x || actorA.y > actorB.y + actorB.height || actorA.y + actorA.height < actorB.y);
	}
}
