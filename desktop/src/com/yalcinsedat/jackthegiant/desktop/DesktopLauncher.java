package com.yalcinsedat.jackthegiant.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yalcinsedat.jackthegiant.GameMain;

import helpers.GameInfo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width= GameInfo.WIDTH;
		config.height= GameInfo.HEIGHT;

		new LwjglApplication(new GameMain(), config);
	}
}
