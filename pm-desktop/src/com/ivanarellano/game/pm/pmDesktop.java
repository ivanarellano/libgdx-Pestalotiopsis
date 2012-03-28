package com.ivanarellano.game.pm;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class pmDesktop {
	public static void main(String args[]) {
		new LwjglApplication(new pmGame(), "Pestalotiopsis Microspora",
				pmGame.SCREEN_WIDTH, pmGame.SCREEN_HEIGHT, false);
	}
}
