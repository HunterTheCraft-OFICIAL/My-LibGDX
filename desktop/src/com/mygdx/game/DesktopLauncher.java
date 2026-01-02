package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "StressTest";
    config.width = 480;
    config.height = 800;
    new LwjglApplication(new MainClass("desktop", "iRXcZRTSAd8+a4nCieRlNwOjBlU="), config);
  }
}
