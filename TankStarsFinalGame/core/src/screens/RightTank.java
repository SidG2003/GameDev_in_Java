package screens;

import com.badlogic.gdx.graphics.Texture;

public class RightTank extends tank{

    Texture img;

    public RightTank(tankGame game) {
        super(game);

    }

    public void show(){
        img = new Texture("purpleLeft.png");
    }
}
