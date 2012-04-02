package com.ivanarellano.game.pm;

import com.badlogic.gdx.backends.lwjgl.LwjglApplet;

public class PmApplet extends LwjglApplet {
    private static final long serialVersionUID = 1L;
    public PmApplet() {
    	super (new PmGame(), false);
    }
}