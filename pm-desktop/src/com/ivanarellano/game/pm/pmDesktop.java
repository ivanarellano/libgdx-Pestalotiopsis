package com.ivanarellano.game.pm;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;

public class pmDesktop {
	public static void main(String args[]) {
        Settings settings = new Settings();
        settings.padding = 6;
        settings.edgePadding = false;
        settings.maxWidth = 1024;
        settings.maxHeight = 1024;
        settings.incremental = true;
        settings.pot = true;
        TexturePacker.process(settings, "assets", "data");
        
		new LwjglApplication(new pmGame(), "Pestalotiopsis Microspora",
				pmGame.SCREEN_WIDTH, pmGame.SCREEN_HEIGHT, false);
	}
}
