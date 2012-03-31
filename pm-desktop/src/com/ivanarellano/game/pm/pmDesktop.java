package com.ivanarellano.game.pm;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;

public class PmDesktop {
	public static void main(String args[]) {
        Settings settings = new Settings();
        settings.padding = 6;
        settings.edgePadding = false;
        settings.maxWidth = 1024;
        settings.maxHeight = 1024;
        settings.incremental = true;
        settings.pot = true;
        TexturePacker.process(settings, "assets", "data");
                
		new LwjglApplication(new PmGame(), "Pestalotiopsis Microspora",
				PmGame.SCREEN_WIDTH, PmGame.SCREEN_HEIGHT, false);
	}
}
