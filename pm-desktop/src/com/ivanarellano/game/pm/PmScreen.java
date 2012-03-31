package com.ivanarellano.game.pm;

import com.badlogic.gdx.Screen;

public abstract class PmScreen implements Screen {
	public PmGame game;

	public PmScreen(PmGame game) {
		this.game = game;
	}
}
