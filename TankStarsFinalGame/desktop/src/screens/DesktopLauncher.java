package screens;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration con = new Lwjgl3ApplicationConfiguration();
		con.setForegroundFPS(60);
		con.setTitle("Tank Game");
		con.setWindowedMode(1280,720);
		new Lwjgl3Application(new tankGame(), con);

	}
}