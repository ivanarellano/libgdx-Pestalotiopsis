package com.ivanarellano.game.pm;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ivanarellano.game.pm.Assets.LabelStyles;

public class Tile extends Group {
	Image texture = new Image(Assets.atlas.findRegion("tile"));
	public String number = new String();
	Label label;
	
	public Tile(String number) {
		this.number = number;
		label = new Label(number, LabelStyles.TILE_NUMBERS);
		
		label.x = texture.width/2 - label.getTextBounds().width/2;
		label.y = -35;
		
		addActor(texture);
		addActor(label);
	}

}
